package org.example.client;

import com.sun.org.apache.xml.internal.utils.QName;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannelBuilder;
import org.example.ServiceBookconfirmation.ServiceBookconfirmationGrpc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookingClientTest {
    private BookingClient client;
    @BeforeAll
    public void setup(){

        String host = "localhost";
        int port = 50051;


        client = new BookingClient(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());

        ServiceBookconfirmationGrpc.ServiceBookconfirmationFutureStub serviceBookconfirmationFutureStub = ServiceBookconfirmationGrpc.newFutureStub(client);




    }
}
