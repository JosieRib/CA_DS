package org.example.client;

import com.sun.org.apache.xml.internal.utils.QName;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannelBuilder;
import org.example.ServiceBookconfirmation.ServiceBookconfirmationGrpc;
import org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookingClientTest {
    private BookingClient client;
    private ServiceBookconfirmationGrpc.ServiceBookconfirmationFutureStub serviceBookconfirmationFutureStub;
    @BeforeAll
    public void setup(){

        String host = "localhost";
        int port = 50051;


        client = new BookingClient(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());

        serviceBookconfirmationFutureStub = ServiceBookconfirmationGrpc.newFutureStub(client);
    }

    @Test
    public void testBookingClient() {
        ServiceBookconfirmationOuterClass.ConfirmationRequest request = ServiceBookconfirmationOuterClass.ConfirmationRequest.newBuilder()
                .setCarPlate("NCI123")
                .build();

        ServiceBookconfirmationOuterClass.Confirmation response = serviceBookconfirmationFutureStub.getConfirmation(request);

        System.out.println("Response: " + response.getReservation());

     }

}
