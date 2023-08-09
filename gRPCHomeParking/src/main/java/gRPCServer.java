import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import ds.home.serverStreaming.AddressAvailabilityGrpc;
import ds.home.serverStreaming.ServerStreaming;
import ds.home.unary.BookConfirmationGrpc;
import ds.home.unary.Unary;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import ds.home.serverStreaming.AddressAvailabilityGrpc;

//import ds.home.serverStreaming.AddressRequest;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class gRPCServer {
    public static void main(String[] args) {
        gRPCServer gRPCServer = new gRPCServer();

        Properties prop =gRPCServer.getProperties();

        gRPCServer.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port"));

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(new Unary())
                    .addService(new ServerStreaming())
                    .build()
                    .start();
            System.out.println("Server started, listening on "+port);

            server.awaitTermination();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private Properties getProperties(){
        Properties prop =null;
        try (InputStream input = new FileInputStream("src/main/resources/math.properties")){
            prop = new Properties();

            prop.load(input);

            System.out.println("Service properies ...");
            System.out.println("\t service_type: "+prop.getProperty("service_type"));
            System.out.println("\t service_name: "+prop.getProperty("service_name"));
            System.out.println("\t service_description: "+prop.getProperty("service_description"));
            System.out.println("\t service_port: "+prop.getProperty("service_port"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    private void registerService(Properties prop){
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            String service_type = prop.getProperty("service_type");
            String service_name = prop.getProperty("service_name");

            int service_port = Integer.valueOf(prop.getProperty("service_port"));

            String service_description_properties = prop.getProperty("service_description");

            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);

            System.out.printf("registering service with type %s and name %s \n",service_type, service_name);

            Thread.sleep(1000);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static class Unary extends BookConfirmationGrpc.BookConfirmationImplBase{
        @Override
        public void getConfirmantion(ds.home.unary.Unary.ConfirmationRequest request, StreamObserver<ds.home.unary.Unary.Confirmation> responseObserver) {
            String carPlate = request.getCarPlate();
            String result = checkConfirmation(carPlate);

            ds.home.unary.Unary.Confirmation response = ds.home.unary.Unary.Confirmation.newBuilder()
                    .setReservation(result)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
        private String checkConfirmation(String carPlate) {
            if (confirmedPlates.contains(carPlate)) {
                return "Your booking is confirmed.";
            } else {
                return "No booking was found for the given plate.";
            }
        }
        private List<String> confirmedPlates;

        public Unary() {
            confirmedPlates = new ArrayList<>();
            confirmedPlates.add("NCI123");
            confirmedPlates.add("XYZ789");
            confirmedPlates.add("DEF456");
            confirmedPlates.add("GHI987");
            confirmedPlates.add("JKL321");
        }
    }

    public static class ServerStreaming extends AddressAvailabilityGrpc.AddressAvailabilityImplBase{

        @Override
        public void getAddress(ds.home.serverStreaming.ServerStreaming.AddressRequest request, StreamObserver<ds.home.serverStreaming.ServerStreaming.Address> responseObserver) {
            ds.home.serverStreaming.ServerStreaming.AddressRequest.City city = request.getCity();

            Map<String,String> addressMap = getAddressfromMap(city);

            try {
                for (Map.Entry<String,String> entry: addressMap.entrySet()){
                    String addressKey = entry.getKey();
                    String addressValue = entry.getValue();

                    ds.home.serverStreaming.ServerStreaming.Address response = ds.home.serverStreaming.ServerStreaming.Address.newBuilder()
                            .setAddress(addressKey)
                            .setGarageNumber(addressValue)
                            .build();

                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    responseObserver.onNext(response);

                }
            }
            finally {
                responseObserver.onCompleted();
            }
        }

        private Map<String,String> getAddressfromMap(ds.home.serverStreaming.ServerStreaming.AddressRequest.City city){
            Map<String,String> addressMap = new HashMap<>();

            if (city == ds.home.serverStreaming.ServerStreaming.AddressRequest.City.Dublin){
                addressMap.put("30, Cabriff street, Dublin 2, D02FHJD, Price: 25.50", "Garage number: 102");
                addressMap.put("81 South Circular road, Dublin 8, D08DFHJ, Price: 10.20", "Garage number: 181");
                addressMap.put("02, Candem St, Dublin 2, D02PGV, Price: 15.50", "Garage number: 10");
                addressMap.put("30, ABC street, Dublin 2, D02FHJD, Price: 25.52", "Garage number: 10");

            } else if (city== ds.home.serverStreaming.ServerStreaming.AddressRequest.City.Cork) {
                addressMap.put("40,Weir st, Cork , C2FHJD, Price: 25.52", "Garage number: 10");
                addressMap.put("23, Wouter st, Cork, C23VFH, Price: 25.52", "Garage number: 10");
                addressMap.put("28, St James rd,Cork, CF23BN, Price: 25.52", "Garage number: 10");
                addressMap.put("36, Clark st, Cork, C2FFHJD, Price: 25.52", "Garage number: 10");
            }

            else {
                addressMap.put("default","default");
            }
            return addressMap;
        }
    }



}
