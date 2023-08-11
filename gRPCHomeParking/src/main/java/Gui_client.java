import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ds.home.unary.Unary.Confirmation;
import ds.home.unary.Unary.ConfirmationRequest;
import ds.home.unary.BookConfirmationGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Gui_client extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gui_client frame = new Gui_client();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Gui_client() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        JDesktopPane desktopPane = new JDesktopPane();
        contentPane.add(desktopPane);

        JLabel lblNewLabel = new JLabel("Home Parking");
        lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.DARK_GRAY);
        lblNewLabel.setBounds(146, 11, 144, 39);
        desktopPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Car plate Number");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(10, 63, 112, 14);
        desktopPane.add(lblNewLabel_1);

        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setBounds(125, 62, 100, 20);
        desktopPane.add(formattedTextField);

        JButton btnNewButton = new JButton("Send");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String carPlate = formattedTextField.getText();

                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                        .usePlaintext()
                        .build();

                BookConfirmationGrpc.BookConfirmationBlockingStub stub = BookConfirmationGrpc.newBlockingStub(channel);

                ConfirmationRequest request = ConfirmationRequest.newBuilder()
                        .setCarPlate(carPlate)
                        .build();

                Confirmation response = stub.getConfirmantion(request);

                textField.setText(response.getReservation());

                channel.shutdown();
            }
        });
        btnNewButton.setBounds(235, 61, 84, 23);
        desktopPane.add(btnNewButton);

        textField = new JTextField();
        textField.setBackground(new Color(192, 192, 192));
        textField.setBounds(39, 119, 343, 20);
        desktopPane.add(textField);
        textField.setColumns(10);
    }
}
