package org.example.ServiceBookconfirmation;

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
    comments = "Source: ServiceBookconfirmation.proto")
public final class ServiceBookconfirmationGrpc {

  private ServiceBookconfirmationGrpc() {}

  public static final String SERVICE_NAME = "ServiceBookconfirmation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest,
      org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation> getGetConfirmantionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getConfirmantion",
      requestType = org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest.class,
      responseType = org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest,
      org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation> getGetConfirmantionMethod() {
    io.grpc.MethodDescriptor<org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest, org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation> getGetConfirmantionMethod;
    if ((getGetConfirmantionMethod = ServiceBookconfirmationGrpc.getGetConfirmantionMethod) == null) {
      synchronized (ServiceBookconfirmationGrpc.class) {
        if ((getGetConfirmantionMethod = ServiceBookconfirmationGrpc.getGetConfirmantionMethod) == null) {
          ServiceBookconfirmationGrpc.getGetConfirmantionMethod = getGetConfirmantionMethod = 
              io.grpc.MethodDescriptor.<org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest, org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ServiceBookconfirmation", "getConfirmantion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new ServiceBookconfirmationMethodDescriptorSupplier("getConfirmantion"))
                  .build();
          }
        }
     }
     return getGetConfirmantionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceBookconfirmationStub newStub(io.grpc.Channel channel) {
    return new ServiceBookconfirmationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceBookconfirmationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServiceBookconfirmationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceBookconfirmationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServiceBookconfirmationFutureStub(channel);
  }

  /**
   */
  public static abstract class ServiceBookconfirmationImplBase implements io.grpc.BindableService {

    /**
     */
    public void getConfirmantion(org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest request,
        io.grpc.stub.StreamObserver<org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getGetConfirmantionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetConfirmantionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest,
                org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation>(
                  this, METHODID_GET_CONFIRMANTION)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceBookconfirmationStub extends io.grpc.stub.AbstractStub<ServiceBookconfirmationStub> {
    private ServiceBookconfirmationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceBookconfirmationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceBookconfirmationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceBookconfirmationStub(channel, callOptions);
    }

    /**
     */
    public void getConfirmantion(org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest request,
        io.grpc.stub.StreamObserver<org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetConfirmantionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceBookconfirmationBlockingStub extends io.grpc.stub.AbstractStub<ServiceBookconfirmationBlockingStub> {
    private ServiceBookconfirmationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceBookconfirmationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceBookconfirmationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceBookconfirmationBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation getConfirmantion(org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetConfirmantionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceBookconfirmationFutureStub extends io.grpc.stub.AbstractStub<ServiceBookconfirmationFutureStub> {
    private ServiceBookconfirmationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceBookconfirmationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceBookconfirmationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceBookconfirmationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation> getConfirmantion(
        org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetConfirmantionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CONFIRMANTION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceBookconfirmationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceBookconfirmationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CONFIRMANTION:
          serviceImpl.getConfirmantion((org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.ConfirmationRequest) request,
              (io.grpc.stub.StreamObserver<org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.Confirmation>) responseObserver);
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

  private static abstract class ServiceBookconfirmationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceBookconfirmationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.ServiceBookconfirmation.ServiceBookconfirmationOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceBookconfirmation");
    }
  }

  private static final class ServiceBookconfirmationFileDescriptorSupplier
      extends ServiceBookconfirmationBaseDescriptorSupplier {
    ServiceBookconfirmationFileDescriptorSupplier() {}
  }

  private static final class ServiceBookconfirmationMethodDescriptorSupplier
      extends ServiceBookconfirmationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceBookconfirmationMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceBookconfirmationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceBookconfirmationFileDescriptorSupplier())
              .addMethod(getGetConfirmantionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
