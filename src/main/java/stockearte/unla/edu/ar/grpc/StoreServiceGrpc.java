package stockearte.unla.edu.ar.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Store Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.1)",
    comments = "Source: system.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StoreServiceGrpc {

  private StoreServiceGrpc() {}

  public static final String SERVICE_NAME = "StoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse> getCreateStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStore",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse> getCreateStoreMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest, stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse> getCreateStoreMethod;
    if ((getCreateStoreMethod = StoreServiceGrpc.getCreateStoreMethod) == null) {
      synchronized (StoreServiceGrpc.class) {
        if ((getCreateStoreMethod = StoreServiceGrpc.getCreateStoreMethod) == null) {
          StoreServiceGrpc.getCreateStoreMethod = getCreateStoreMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest, stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StoreServiceMethodDescriptorSupplier("CreateStore"))
              .build();
        }
      }
    }
    return getCreateStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse> getDisableStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableStore",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse> getDisableStoreMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest, stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse> getDisableStoreMethod;
    if ((getDisableStoreMethod = StoreServiceGrpc.getDisableStoreMethod) == null) {
      synchronized (StoreServiceGrpc.class) {
        if ((getDisableStoreMethod = StoreServiceGrpc.getDisableStoreMethod) == null) {
          StoreServiceGrpc.getDisableStoreMethod = getDisableStoreMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest, stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StoreServiceMethodDescriptorSupplier("DisableStore"))
              .build();
        }
      }
    }
    return getDisableStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse> getAssignProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignProduct",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse> getAssignProductMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest, stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse> getAssignProductMethod;
    if ((getAssignProductMethod = StoreServiceGrpc.getAssignProductMethod) == null) {
      synchronized (StoreServiceGrpc.class) {
        if ((getAssignProductMethod = StoreServiceGrpc.getAssignProductMethod) == null) {
          StoreServiceGrpc.getAssignProductMethod = getAssignProductMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest, stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AssignProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StoreServiceMethodDescriptorSupplier("AssignProduct"))
              .build();
        }
      }
    }
    return getAssignProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse> getAssignUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignUser",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse> getAssignUserMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest, stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse> getAssignUserMethod;
    if ((getAssignUserMethod = StoreServiceGrpc.getAssignUserMethod) == null) {
      synchronized (StoreServiceGrpc.class) {
        if ((getAssignUserMethod = StoreServiceGrpc.getAssignUserMethod) == null) {
          StoreServiceGrpc.getAssignUserMethod = getAssignUserMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest, stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AssignUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StoreServiceMethodDescriptorSupplier("AssignUser"))
              .build();
        }
      }
    }
    return getAssignUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StoreServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StoreServiceStub>() {
        @java.lang.Override
        public StoreServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StoreServiceStub(channel, callOptions);
        }
      };
    return StoreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StoreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StoreServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StoreServiceBlockingStub>() {
        @java.lang.Override
        public StoreServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StoreServiceBlockingStub(channel, callOptions);
        }
      };
    return StoreServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StoreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StoreServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StoreServiceFutureStub>() {
        @java.lang.Override
        public StoreServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StoreServiceFutureStub(channel, callOptions);
        }
      };
    return StoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Store Service
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createStore(stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateStoreMethod(), responseObserver);
    }

    /**
     */
    default void disableStore(stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableStoreMethod(), responseObserver);
    }

    /**
     */
    default void assignProduct(stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssignProductMethod(), responseObserver);
    }

    /**
     */
    default void assignUser(stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssignUserMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StoreService.
   * <pre>
   * Store Service
   * </pre>
   */
  public static abstract class StoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StoreService.
   * <pre>
   * Store Service
   * </pre>
   */
  public static final class StoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StoreServiceStub> {
    private StoreServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StoreServiceStub(channel, callOptions);
    }

    /**
     */
    public void createStore(stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void disableStore(stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assignProduct(stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assignUser(stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StoreService.
   * <pre>
   * Store Service
   * </pre>
   */
  public static final class StoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StoreServiceBlockingStub> {
    private StoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StoreServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse createStore(stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse disableStore(stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse assignProduct(stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse assignUser(stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StoreService.
   * <pre>
   * Store Service
   * </pre>
   */
  public static final class StoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StoreServiceFutureStub> {
    private StoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StoreServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse> createStore(
        stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse> disableStore(
        stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse> assignProduct(
        stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse> assignUser(
        stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_STORE = 0;
  private static final int METHODID_DISABLE_STORE = 1;
  private static final int METHODID_ASSIGN_PRODUCT = 2;
  private static final int METHODID_ASSIGN_USER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_STORE:
          serviceImpl.createStore((stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse>) responseObserver);
          break;
        case METHODID_DISABLE_STORE:
          serviceImpl.disableStore((stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse>) responseObserver);
          break;
        case METHODID_ASSIGN_PRODUCT:
          serviceImpl.assignProduct((stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse>) responseObserver);
          break;
        case METHODID_ASSIGN_USER:
          serviceImpl.assignUser((stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.CreateStoreResponse>(
                service, METHODID_CREATE_STORE)))
        .addMethod(
          getDisableStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.DisableStoreResponse>(
                service, METHODID_DISABLE_STORE)))
        .addMethod(
          getAssignProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.AssignProductRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.AssignProductResponse>(
                service, METHODID_ASSIGN_PRODUCT)))
        .addMethod(
          getAssignUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.AssignUserRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.AssignUserResponse>(
                service, METHODID_ASSIGN_USER)))
        .build();
  }

  private static abstract class StoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return stockearte.unla.edu.ar.grpc.SystemProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StoreService");
    }
  }

  private static final class StoreServiceFileDescriptorSupplier
      extends StoreServiceBaseDescriptorSupplier {
    StoreServiceFileDescriptorSupplier() {}
  }

  private static final class StoreServiceMethodDescriptorSupplier
      extends StoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StoreServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StoreServiceFileDescriptorSupplier())
              .addMethod(getCreateStoreMethod())
              .addMethod(getDisableStoreMethod())
              .addMethod(getAssignProductMethod())
              .addMethod(getAssignUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
