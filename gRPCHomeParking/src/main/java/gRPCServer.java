import java.util.Properties;

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
public class gRPCServer {
    public static void main(String[] args) {
        gRPCServer gRPCServer = new gRPCServer();

        Properties prop =gRPCServer.getProperties();

        gRPCServer.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port"));

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(new Unary())
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
                return "Booking confirmado.";
            } else {
                return "Booking não confirmado.";
            }
        }
        private List<String> confirmedPlates;

        public Unary() {
            confirmedPlates = new ArrayList<>();
            confirmedPlates.add("ABC123");
            confirmedPlates.add("XYZ789");
            confirmedPlates.add("DEF456");
            confirmedPlates.add("GHI987");
            confirmedPlates.add("JKL321");
        }
    }
    
}
