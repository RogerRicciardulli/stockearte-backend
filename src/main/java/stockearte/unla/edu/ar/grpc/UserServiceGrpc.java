package stockearte.unla.edu.ar.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * User Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.1)",
    comments = "Source: system.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest, stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse> getCreateUserMethod;
    if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
          UserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest, stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse> getAuthenticateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AuthenticateUser",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse> getAuthenticateUserMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest, stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse> getAuthenticateUserMethod;
    if ((getAuthenticateUserMethod = UserServiceGrpc.getAuthenticateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getAuthenticateUserMethod = UserServiceGrpc.getAuthenticateUserMethod) == null) {
          UserServiceGrpc.getAuthenticateUserMethod = getAuthenticateUserMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest, stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AuthenticateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("AuthenticateUser"))
              .build();
        }
      }
    }
    return getAuthenticateUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * User Service
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createUser(stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    default void authenticateUser(stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAuthenticateUserMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserService.
   * <pre>
   * User Service
   * </pre>
   */
  public static abstract class UserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserService.
   * <pre>
   * User Service
   * </pre>
   */
  public static final class UserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void authenticateUser(stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuthenticateUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserService.
   * <pre>
   * User Service
   * </pre>
   */
  public static final class UserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse createUser(stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse authenticateUser(stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuthenticateUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserService.
   * <pre>
   * User Service
   * </pre>
   */
  public static final class UserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse> createUser(
        stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse> authenticateUser(
        stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuthenticateUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_AUTHENTICATE_USER = 1;

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
        case METHODID_CREATE_USER:
          serviceImpl.createUser((stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse>) responseObserver);
          break;
        case METHODID_AUTHENTICATE_USER:
          serviceImpl.authenticateUser((stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse>) responseObserver);
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
          getCreateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.CreateUserRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.CreateUserResponse>(
                service, METHODID_CREATE_USER)))
        .addMethod(
          getAuthenticateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.AuthenticateUserResponse>(
                service, METHODID_AUTHENTICATE_USER)))
        .build();
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return stockearte.unla.edu.ar.grpc.SystemProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getAuthenticateUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
