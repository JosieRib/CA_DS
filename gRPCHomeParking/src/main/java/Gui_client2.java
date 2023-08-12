import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ds.home.serverStreaming.AddressAvailabilityGrpc;
import ds.home.serverStreaming.ServerStreaming;
import ds.home.serverStreaming.ServerStreaming.AddressRequest;
import ds.home.serverStreaming.ServerStreaming.Address;
import ds.home.serverStreaming.ServerStreaming.AddressRequest.City;
import io.grpc.stub.StreamObserver;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class Gui_client2 extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> cityComboBox;
    private JTextArea addressTextArea;
    private JButton fetchButton;
    private ManagedChannel channel;
    private AddressAvailabilityGrpc.AddressAvailabilityStub addressStub;
    /**
     * @wbp.nonvisual location=121,9
     */
    private final JLabel lblCheckGarageAvailable = new JLabel("Check garage available");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gui_client2 frame = new Gui_client2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Gui_client2() {
    	lblCheckGarageAvailable.setForeground(SystemColor.activeCaption);
    	lblCheckGarageAvailable.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cityComboBox = new JComboBox<>();
        cityComboBox.addItem("Dublin");
        cityComboBox.addItem("Cork");
        cityComboBox.setBounds(10, 11, 131, 20);
        contentPane.add(cityComboBox);

        addressTextArea = new JTextArea();
        addressTextArea.setFont(new Font("MS Gothic", Font.PLAIN, 13));
        addressTextArea.setBackground(SystemColor.control);
        addressTextArea.setEditable(false);
        addressTextArea.setBounds(10, 53, 414, 163);
        contentPane.add(addressTextArea);

        fetchButton = new JButton("Fetch Addresses");
        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchAddresses();
            }
        });
        fetchButton.setBounds(151, 10, 143, 23);
        contentPane.add(fetchButton);

        channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
        addressStub = AddressAvailabilityGrpc.newStub(channel);
    }

    private void fetchAddresses() {
        String selectedCity = (String) cityComboBox.getSelectedItem();
        AddressRequest.City city = selectedCity.equals("Dublin") ? City.Dublin : City.Cork;

        addressTextArea.setText("Fetching addresses...");

        StreamObserver<Address> responseObserver = new StreamObserver<Address>() {
            @Override
            public void onNext(Address address) {
                String addressStr = "Address: " + address.getAddress() + "\nGarage Number: " + address.getGarageNumber() + "\n";
                addressTextArea.append(addressStr);
            }

            @Override
            public void onError(Throwable t) {
                addressTextArea.setText("Error fetching addresses: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                addressTextArea.append("\nFetching addresses completed.");
            }
        };

        addressStub.getAddress(AddressRequest.newBuilder().setCity(city).build(), responseObserver);
    }
}
