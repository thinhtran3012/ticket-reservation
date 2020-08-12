package io.cinema.proto;

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
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: cinema.proto")
public final class CinemaServiceGrpc {

  private CinemaServiceGrpc() {}

  private static <T> io.grpc.stub.StreamObserver<T> toObserver(final io.vertx.core.Handler<io.vertx.core.AsyncResult<T>> handler) {
    return new io.grpc.stub.StreamObserver<T>() {
      private volatile boolean resolved = false;
      @Override
      public void onNext(T value) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture(value));
        }
      }

      @Override
      public void onError(Throwable t) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.failedFuture(t));
        }
      }

      @Override
      public void onCompleted() {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture());
        }
      }
    };
  }

  public static final String SERVICE_NAME = "CinemaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.cinema.proto.SubmitReserveTicketRequest,
      io.cinema.proto.ReserveTicketResponse> getSubmitReserveTicketMethod;

  public static io.grpc.MethodDescriptor<io.cinema.proto.SubmitReserveTicketRequest,
      io.cinema.proto.ReserveTicketResponse> getSubmitReserveTicketMethod() {
    io.grpc.MethodDescriptor<io.cinema.proto.SubmitReserveTicketRequest, io.cinema.proto.ReserveTicketResponse> getSubmitReserveTicketMethod;
    if ((getSubmitReserveTicketMethod = CinemaServiceGrpc.getSubmitReserveTicketMethod) == null) {
      synchronized (CinemaServiceGrpc.class) {
        if ((getSubmitReserveTicketMethod = CinemaServiceGrpc.getSubmitReserveTicketMethod) == null) {
          CinemaServiceGrpc.getSubmitReserveTicketMethod = getSubmitReserveTicketMethod = 
              io.grpc.MethodDescriptor.<io.cinema.proto.SubmitReserveTicketRequest, io.cinema.proto.ReserveTicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CinemaService", "SubmitReserveTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cinema.proto.SubmitReserveTicketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cinema.proto.ReserveTicketResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CinemaServiceMethodDescriptorSupplier("SubmitReserveTicket"))
                  .build();
          }
        }
     }
     return getSubmitReserveTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.cinema.proto.Empty,
      io.cinema.proto.GetAvailableSeatsResponse> getSubmitGetAvailableSeatsRequestMethod;

  public static io.grpc.MethodDescriptor<io.cinema.proto.Empty,
      io.cinema.proto.GetAvailableSeatsResponse> getSubmitGetAvailableSeatsRequestMethod() {
    io.grpc.MethodDescriptor<io.cinema.proto.Empty, io.cinema.proto.GetAvailableSeatsResponse> getSubmitGetAvailableSeatsRequestMethod;
    if ((getSubmitGetAvailableSeatsRequestMethod = CinemaServiceGrpc.getSubmitGetAvailableSeatsRequestMethod) == null) {
      synchronized (CinemaServiceGrpc.class) {
        if ((getSubmitGetAvailableSeatsRequestMethod = CinemaServiceGrpc.getSubmitGetAvailableSeatsRequestMethod) == null) {
          CinemaServiceGrpc.getSubmitGetAvailableSeatsRequestMethod = getSubmitGetAvailableSeatsRequestMethod = 
              io.grpc.MethodDescriptor.<io.cinema.proto.Empty, io.cinema.proto.GetAvailableSeatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CinemaService", "SubmitGetAvailableSeatsRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cinema.proto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cinema.proto.GetAvailableSeatsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CinemaServiceMethodDescriptorSupplier("SubmitGetAvailableSeatsRequest"))
                  .build();
          }
        }
     }
     return getSubmitGetAvailableSeatsRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CinemaServiceStub newStub(io.grpc.Channel channel) {
    return new CinemaServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CinemaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CinemaServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CinemaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CinemaServiceFutureStub(channel);
  }

  /**
   * Creates a new vertx stub that supports all call types for the service
   */
  public static CinemaServiceVertxStub newVertxStub(io.grpc.Channel channel) {
    return new CinemaServiceVertxStub(channel);
  }

  /**
   */
  public static abstract class CinemaServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void submitReserveTicket(io.cinema.proto.SubmitReserveTicketRequest request,
        io.grpc.stub.StreamObserver<io.cinema.proto.ReserveTicketResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubmitReserveTicketMethod(), responseObserver);
    }

    /**
     */
    public void submitGetAvailableSeatsRequest(io.cinema.proto.Empty request,
        io.grpc.stub.StreamObserver<io.cinema.proto.GetAvailableSeatsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubmitGetAvailableSeatsRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubmitReserveTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.cinema.proto.SubmitReserveTicketRequest,
                io.cinema.proto.ReserveTicketResponse>(
                  this, METHODID_SUBMIT_RESERVE_TICKET)))
          .addMethod(
            getSubmitGetAvailableSeatsRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.cinema.proto.Empty,
                io.cinema.proto.GetAvailableSeatsResponse>(
                  this, METHODID_SUBMIT_GET_AVAILABLE_SEATS_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class CinemaServiceStub extends io.grpc.stub.AbstractStub<CinemaServiceStub> {
    public CinemaServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    public CinemaServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceStub(channel, callOptions);
    }

    /**
     */
    public void submitReserveTicket(io.cinema.proto.SubmitReserveTicketRequest request,
        io.grpc.stub.StreamObserver<io.cinema.proto.ReserveTicketResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubmitReserveTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void submitGetAvailableSeatsRequest(io.cinema.proto.Empty request,
        io.grpc.stub.StreamObserver<io.cinema.proto.GetAvailableSeatsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubmitGetAvailableSeatsRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CinemaServiceBlockingStub extends io.grpc.stub.AbstractStub<CinemaServiceBlockingStub> {
    public CinemaServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    public CinemaServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.cinema.proto.ReserveTicketResponse submitReserveTicket(io.cinema.proto.SubmitReserveTicketRequest request) {
      return blockingUnaryCall(
          getChannel(), getSubmitReserveTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.cinema.proto.GetAvailableSeatsResponse submitGetAvailableSeatsRequest(io.cinema.proto.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSubmitGetAvailableSeatsRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CinemaServiceFutureStub extends io.grpc.stub.AbstractStub<CinemaServiceFutureStub> {
    public CinemaServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    public CinemaServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.cinema.proto.ReserveTicketResponse> submitReserveTicket(
        io.cinema.proto.SubmitReserveTicketRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSubmitReserveTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.cinema.proto.GetAvailableSeatsResponse> submitGetAvailableSeatsRequest(
        io.cinema.proto.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSubmitGetAvailableSeatsRequestMethod(), getCallOptions()), request);
    }
  }

  /**
   */
  public static abstract class CinemaServiceVertxImplBase implements io.grpc.BindableService {

    /**
     */
    public void submitReserveTicket(io.cinema.proto.SubmitReserveTicketRequest request,
        io.vertx.core.Promise<io.cinema.proto.ReserveTicketResponse> response) {
      asyncUnimplementedUnaryCall(getSubmitReserveTicketMethod(), CinemaServiceGrpc.toObserver(response));
    }

    /**
     */
    public void submitGetAvailableSeatsRequest(io.cinema.proto.Empty request,
        io.vertx.core.Promise<io.cinema.proto.GetAvailableSeatsResponse> response) {
      asyncUnimplementedUnaryCall(getSubmitGetAvailableSeatsRequestMethod(), CinemaServiceGrpc.toObserver(response));
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubmitReserveTicketMethod(),
            asyncUnaryCall(
              new VertxMethodHandlers<
                io.cinema.proto.SubmitReserveTicketRequest,
                io.cinema.proto.ReserveTicketResponse>(
                  this, METHODID_SUBMIT_RESERVE_TICKET)))
          .addMethod(
            getSubmitGetAvailableSeatsRequestMethod(),
            asyncUnaryCall(
              new VertxMethodHandlers<
                io.cinema.proto.Empty,
                io.cinema.proto.GetAvailableSeatsResponse>(
                  this, METHODID_SUBMIT_GET_AVAILABLE_SEATS_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class CinemaServiceVertxStub extends io.grpc.stub.AbstractStub<CinemaServiceVertxStub> {
    public CinemaServiceVertxStub(io.grpc.Channel channel) {
      super(channel);
    }

    public CinemaServiceVertxStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceVertxStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceVertxStub(channel, callOptions);
    }

    /**
     */
    public void submitReserveTicket(io.cinema.proto.SubmitReserveTicketRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<io.cinema.proto.ReserveTicketResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(getSubmitReserveTicketMethod(), getCallOptions()), request, CinemaServiceGrpc.toObserver(response));
    }

    /**
     */
    public void submitGetAvailableSeatsRequest(io.cinema.proto.Empty request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<io.cinema.proto.GetAvailableSeatsResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(getSubmitGetAvailableSeatsRequestMethod(), getCallOptions()), request, CinemaServiceGrpc.toObserver(response));
    }
  }

  private static final int METHODID_SUBMIT_RESERVE_TICKET = 0;
  private static final int METHODID_SUBMIT_GET_AVAILABLE_SEATS_REQUEST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CinemaServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CinemaServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBMIT_RESERVE_TICKET:
          serviceImpl.submitReserveTicket((io.cinema.proto.SubmitReserveTicketRequest) request,
              (io.grpc.stub.StreamObserver<io.cinema.proto.ReserveTicketResponse>) responseObserver);
          break;
        case METHODID_SUBMIT_GET_AVAILABLE_SEATS_REQUEST:
          serviceImpl.submitGetAvailableSeatsRequest((io.cinema.proto.Empty) request,
              (io.grpc.stub.StreamObserver<io.cinema.proto.GetAvailableSeatsResponse>) responseObserver);
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

  private static final class VertxMethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CinemaServiceVertxImplBase serviceImpl;
    private final int methodId;

    VertxMethodHandlers(CinemaServiceVertxImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBMIT_RESERVE_TICKET:
          serviceImpl.submitReserveTicket((io.cinema.proto.SubmitReserveTicketRequest) request,
              (io.vertx.core.Promise<io.cinema.proto.ReserveTicketResponse>) io.vertx.core.Promise.<io.cinema.proto.ReserveTicketResponse>promise().future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<io.cinema.proto.ReserveTicketResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_SUBMIT_GET_AVAILABLE_SEATS_REQUEST:
          serviceImpl.submitGetAvailableSeatsRequest((io.cinema.proto.Empty) request,
              (io.vertx.core.Promise<io.cinema.proto.GetAvailableSeatsResponse>) io.vertx.core.Promise.<io.cinema.proto.GetAvailableSeatsResponse>promise().future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<io.cinema.proto.GetAvailableSeatsResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
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

  private static abstract class CinemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CinemaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.cinema.proto.Cinema.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CinemaService");
    }
  }

  private static final class CinemaServiceFileDescriptorSupplier
      extends CinemaServiceBaseDescriptorSupplier {
    CinemaServiceFileDescriptorSupplier() {}
  }

  private static final class CinemaServiceMethodDescriptorSupplier
      extends CinemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CinemaServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CinemaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CinemaServiceFileDescriptorSupplier())
              .addMethod(getSubmitReserveTicketMethod())
              .addMethod(getSubmitGetAvailableSeatsRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
