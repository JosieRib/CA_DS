package ds.home.serverStreaming;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: ServerStreaming.proto")
public final class AddressAvailabilityGrpc {

  private AddressAvailabilityGrpc() {}

  public static final String SERVICE_NAME = "AddressAvailability";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.home.serverStreaming.ServerStreaming.AddressRequest,
      ds.home.serverStreaming.ServerStreaming.Address> getGetAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAddress",
      requestType = ds.home.serverStreaming.ServerStreaming.AddressRequest.class,
      responseType = ds.home.serverStreaming.ServerStreaming.Address.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.home.serverStreaming.ServerStreaming.AddressRequest,
      ds.home.serverStreaming.ServerStreaming.Address> getGetAddressMethod() {
    io.grpc.MethodDescriptor<ds.home.serverStreaming.ServerStreaming.AddressRequest, ds.home.serverStreaming.ServerStreaming.Address> getGetAddressMethod;
    if ((getGetAddressMethod = AddressAvailabilityGrpc.getGetAddressMethod) == null) {
      synchronized (AddressAvailabilityGrpc.class) {
        if ((getGetAddressMethod = AddressAvailabilityGrpc.getGetAddressMethod) == null) {
          AddressAvailabilityGrpc.getGetAddressMethod = getGetAddressMethod = 
              io.grpc.MethodDescriptor.<ds.home.serverStreaming.ServerStreaming.AddressRequest, ds.home.serverStreaming.ServerStreaming.Address>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AddressAvailability", "getAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.home.serverStreaming.ServerStreaming.AddressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.home.serverStreaming.ServerStreaming.Address.getDefaultInstance()))
                  .setSchemaDescriptor(new AddressAvailabilityMethodDescriptorSupplier("getAddress"))
                  .build();
          }
        }
     }
     return getGetAddressMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AddressAvailabilityStub newStub(io.grpc.Channel channel) {
    return new AddressAvailabilityStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AddressAvailabilityBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AddressAvailabilityBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AddressAvailabilityFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AddressAvailabilityFutureStub(channel);
  }

  /**
   */
  public static abstract class AddressAvailabilityImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAddress(ds.home.serverStreaming.ServerStreaming.AddressRequest request,
        io.grpc.stub.StreamObserver<ds.home.serverStreaming.ServerStreaming.Address> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAddressMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAddressMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.home.serverStreaming.ServerStreaming.AddressRequest,
                ds.home.serverStreaming.ServerStreaming.Address>(
                  this, METHODID_GET_ADDRESS)))
          .build();
    }
  }

  /**
   */
  public static final class AddressAvailabilityStub extends io.grpc.stub.AbstractStub<AddressAvailabilityStub> {
    private AddressAvailabilityStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddressAvailabilityStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressAvailabilityStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddressAvailabilityStub(channel, callOptions);
    }

    /**
     */
    public void getAddress(ds.home.serverStreaming.ServerStreaming.AddressRequest request,
        io.grpc.stub.StreamObserver<ds.home.serverStreaming.ServerStreaming.Address> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAddressMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AddressAvailabilityBlockingStub extends io.grpc.stub.AbstractStub<AddressAvailabilityBlockingStub> {
    private AddressAvailabilityBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddressAvailabilityBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressAvailabilityBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddressAvailabilityBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.home.serverStreaming.ServerStreaming.Address> getAddress(
        ds.home.serverStreaming.ServerStreaming.AddressRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAddressMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AddressAvailabilityFutureStub extends io.grpc.stub.AbstractStub<AddressAvailabilityFutureStub> {
    private AddressAvailabilityFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddressAvailabilityFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressAvailabilityFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddressAvailabilityFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_ADDRESS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AddressAvailabilityImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AddressAvailabilityImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ADDRESS:
          serviceImpl.getAddress((ds.home.serverStreaming.ServerStreaming.AddressRequest) request,
              (io.grpc.stub.StreamObserver<ds.home.serverStreaming.ServerStreaming.Address>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AddressAvailabilityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AddressAvailabilityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.home.serverStreaming.ServerStreaming.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AddressAvailability");
    }
  }

  private static final class AddressAvailabilityFileDescriptorSupplier
      extends AddressAvailabilityBaseDescriptorSupplier {
    AddressAvailabilityFileDescriptorSupplier() {}
  }

  private static final class AddressAvailabilityMethodDescriptorSupplier
      extends AddressAvailabilityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AddressAvailabilityMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AddressAvailabilityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AddressAvailabilityFileDescriptorSupplier())
              .addMethod(getGetAddressMethod())
              .build();
        }
      }
    }
    return result;
  }
}
