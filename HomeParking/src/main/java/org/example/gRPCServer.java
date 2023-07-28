package org.example;

import com.google.common.net.InetAddresses;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.ServiceBookconfirmation.ServiceBookconfirmationGrpc;
import org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass;

import java.net.InetAddress;
import io.grpc.stub.StreamObserver;
import java.util.Map;
import java.util.HashMap;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class gRPCServer {
    public static void main(String[] args) {
        gRPCServer gRPCServer = new gRPCServer();

        Properties prop =gRPCServer.getProperties();

        gRPCServer.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port"));

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(new Service1())
                    .build()
                    .start();
            System.out.println("server started, listem on" + port);

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
       try(InputStream input = new FileInputStream("src/main/resources/math.properties")){
           prop = new Properties();

           prop.load(input);

        System.out.println("Service properties...");
        System.out.println("\t service_type:" +prop.getProperty("service_type"));
        System.out.println("\t service_name:" +prop.getProperty("service_name"));
        System.out.println("\t service_description:"+prop.getProperty("service_description"));
        System.out.println("\t service_port:"+prop.getProperty("service_port"));

      }

       catch(IOException ex){
           ex.printStackTrace();
       }
        return prop;
   }


   private void registerService(Properties prop) {
       try {
           InetAddress localHost = InetAddress.getLocalHost();
           JmDNS jmdns = JmDNS.create(localHost);

           String service_type = prop.getProperty("service_type");
           String service_name = prop.getProperty("service_name");

           int service_port = Integer.valueOf(prop.getProperty("service_port"));

           String service_description_properties = prop.getProperty("service_description");

           ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
           jmdns.registerService(serviceInfo);

           System.out.printf("registering service with type %s and name %s \n", service_type, service_name);

           Thread.sleep(1000);
       } catch (IOException e) {
           System.out.println(e.getMessage());
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

   }
   public static class Service1 extends ServiceBookconfirmationGrpc.ServiceBookconfirmationImplBase{


   }


}

