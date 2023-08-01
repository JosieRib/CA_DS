package ds.home.unary;

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
    comments = "Source: unary.proto")
public class BookConfirmationGrpc {

  private BookConfirmationGrpc() {}

  public static final String SERVICE_NAME = "BookConfirmation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.home.unary.Unary.ConfirmationRequest,
      ds.home.unary.Unary.Confirmation> getGetConfirmantionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getConfirmantion",
      requestType = ds.home.unary.Unary.ConfirmationRequest.class,
      responseType = ds.home.unary.Unary.Confirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.home.unary.Unary.ConfirmationRequest,
      ds.home.unary.Unary.Confirmation> getGetConfirmantionMethod() {
    io.grpc.MethodDescriptor<ds.home.unary.Unary.ConfirmationRequest, ds.home.unary.Unary.Confirmation> getGetConfirmantionMethod;
    if ((getGetConfirmantionMethod = BookConfirmationGrpc.getGetConfirmantionMethod) == null) {
      synchronized (BookConfirmationGrpc.class) {
        if ((getGetConfirmantionMethod = BookConfirmationGrpc.getGetConfirmantionMethod) == null) {
          BookConfirmationGrpc.getGetConfirmantionMethod = getGetConfirmantionMethod = 
              io.grpc.MethodDescriptor.<ds.home.unary.Unary.ConfirmationRequest, ds.home.unary.Unary.Confirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BookConfirmation", "getConfirmantion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.home.unary.Unary.ConfirmationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.home.unary.Unary.Confirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new BookConfirmationMethodDescriptorSupplier("getConfirmantion"))
                  .build();
          }
        }
     }
     return getGetConfirmantionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookConfirmationStub newStub(io.grpc.Channel channel) {
    return new BookConfirmationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookConfirmationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookConfirmationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookConfirmationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookConfirmationFutureStub(channel);
  }

  /**
   */
  public static abstract class BookConfirmationImplBase implements io.grpc.BindableService {

    /**
     */
    public void getConfirmantion(ds.home.unary.Unary.ConfirmationRequest request,
        io.grpc.stub.StreamObserver<ds.home.unary.Unary.Confirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getGetConfirmantionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetConfirmantionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.home.unary.Unary.ConfirmationRequest,
                ds.home.unary.Unary.Confirmation>(
                  this, METHODID_GET_CONFIRMANTION)))
          .build();
    }
  }

  /**
   */
  public static final class BookConfirmationStub extends io.grpc.stub.AbstractStub<BookConfirmationStub> {
    private BookConfirmationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookConfirmationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookConfirmationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookConfirmationStub(channel, callOptions);
    }

    /**
     */
    public void getConfirmantion(ds.home.unary.Unary.ConfirmationRequest request,
        io.grpc.stub.StreamObserver<ds.home.unary.Unary.Confirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetConfirmantionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BookConfirmationBlockingStub extends io.grpc.stub.AbstractStub<BookConfirmationBlockingStub> {
    private BookConfirmationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookConfirmationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookConfirmationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookConfirmationBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.home.unary.Unary.Confirmation getConfirmantion(ds.home.unary.Unary.ConfirmationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetConfirmantionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookConfirmationFutureStub extends io.grpc.stub.AbstractStub<BookConfirmationFutureStub> {
    private BookConfirmationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookConfirmationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookConfirmationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookConfirmationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.home.unary.Unary.Confirmation> getConfirmantion(
        ds.home.unary.Unary.ConfirmationRequest request) {
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
    private final BookConfirmationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookConfirmationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CONFIRMANTION:
          serviceImpl.getConfirmantion((ds.home.unary.Unary.ConfirmationRequest) request,
              (io.grpc.stub.StreamObserver<ds.home.unary.Unary.Confirmation>) responseObserver);
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

  private static abstract class BookConfirmationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookConfirmationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.home.unary.Unary.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BookConfirmation");
    }
  }

  private static final class BookConfirmationFileDescriptorSupplier
      extends BookConfirmationBaseDescriptorSupplier {
    BookConfirmationFileDescriptorSupplier() {}
  }

  private static final class BookConfirmationMethodDescriptorSupplier
      extends BookConfirmationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookConfirmationMethodDescriptorSupplier(String methodName) {
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
      synchronized (BookConfirmationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookConfirmationFileDescriptorSupplier())
              .addMethod(getGetConfirmantionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
