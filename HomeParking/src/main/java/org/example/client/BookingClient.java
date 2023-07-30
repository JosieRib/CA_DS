package org.example.client;

import io.grpc.*;

public class BookingClient extends Channel {
    public BookingClient(ManagedChannel build) {
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return null;
    }

    @Override
    public String authority() {
        return null;
    }
}
