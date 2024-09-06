package stockearte.unla.edu.ar.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Product Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.1)",
    comments = "Source: system.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final String SERVICE_NAME = "ProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse> getCreateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProduct",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse> getCreateProductMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest, stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse> getCreateProductMethod;
    if ((getCreateProductMethod = ProductServiceGrpc.getCreateProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getCreateProductMethod = ProductServiceGrpc.getCreateProductMethod) == null) {
          ProductServiceGrpc.getCreateProductMethod = getCreateProductMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest, stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("CreateProduct"))
              .build();
        }
      }
    }
    return getCreateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse> getUpdateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProduct",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse> getUpdateProductMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest, stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse> getUpdateProductMethod;
    if ((getUpdateProductMethod = ProductServiceGrpc.getUpdateProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getUpdateProductMethod = ProductServiceGrpc.getUpdateProductMethod) == null) {
          ProductServiceGrpc.getUpdateProductMethod = getUpdateProductMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest, stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("UpdateProduct"))
              .build();
        }
      }
    }
    return getUpdateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse> getDeleteProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProduct",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse> getDeleteProductMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest, stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse> getDeleteProductMethod;
    if ((getDeleteProductMethod = ProductServiceGrpc.getDeleteProductMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getDeleteProductMethod = ProductServiceGrpc.getDeleteProductMethod) == null) {
          ProductServiceGrpc.getDeleteProductMethod = getDeleteProductMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest, stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("DeleteProduct"))
              .build();
        }
      }
    }
    return getDeleteProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse> getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse> getListProductsMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest, stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse> getListProductsMethod;
    if ((getListProductsMethod = ProductServiceGrpc.getListProductsMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getListProductsMethod = ProductServiceGrpc.getListProductsMethod) == null) {
          ProductServiceGrpc.getListProductsMethod = getListProductsMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest, stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("ListProducts"))
              .build();
        }
      }
    }
    return getListProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse> getGetProductDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductDetail",
      requestType = stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest.class,
      responseType = stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest,
      stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse> getGetProductDetailMethod() {
    io.grpc.MethodDescriptor<stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest, stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse> getGetProductDetailMethod;
    if ((getGetProductDetailMethod = ProductServiceGrpc.getGetProductDetailMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getGetProductDetailMethod = ProductServiceGrpc.getGetProductDetailMethod) == null) {
          ProductServiceGrpc.getGetProductDetailMethod = getGetProductDetailMethod =
              io.grpc.MethodDescriptor.<stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest, stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProductDetail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("GetProductDetail"))
              .build();
        }
      }
    }
    return getGetProductDetailMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub>() {
        @java.lang.Override
        public ProductServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceStub(channel, callOptions);
        }
      };
    return ProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub>() {
        @java.lang.Override
        public ProductServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub>() {
        @java.lang.Override
        public ProductServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceFutureStub(channel, callOptions);
        }
      };
    return ProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Product Service
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createProduct(stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateProductMethod(), responseObserver);
    }

    /**
     */
    default void updateProduct(stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateProductMethod(), responseObserver);
    }

    /**
     */
    default void deleteProduct(stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteProductMethod(), responseObserver);
    }

    /**
     */
    default void listProducts(stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListProductsMethod(), responseObserver);
    }

    /**
     */
    default void getProductDetail(stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductDetailMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductService.
   * <pre>
   * Product Service
   * </pre>
   */
  public static abstract class ProductServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductService.
   * <pre>
   * Product Service
   * </pre>
   */
  public static final class ProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductServiceStub> {
    private ProductServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceStub(channel, callOptions);
    }

    /**
     */
    public void createProduct(stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateProduct(stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteProduct(stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listProducts(stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProductDetail(stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest request,
        io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductDetailMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductService.
   * <pre>
   * Product Service
   * </pre>
   */
  public static final class ProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductServiceBlockingStub> {
    private ProductServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse createProduct(stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse updateProduct(stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse deleteProduct(stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse listProducts(stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }

    /**
     */
    public stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse getProductDetail(stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductDetailMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductService.
   * <pre>
   * Product Service
   * </pre>
   */
  public static final class ProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductServiceFutureStub> {
    private ProductServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse> createProduct(
        stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse> updateProduct(
        stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse> deleteProduct(
        stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse> listProducts(
        stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse> getProductDetail(
        stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductDetailMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PRODUCT = 0;
  private static final int METHODID_UPDATE_PRODUCT = 1;
  private static final int METHODID_DELETE_PRODUCT = 2;
  private static final int METHODID_LIST_PRODUCTS = 3;
  private static final int METHODID_GET_PRODUCT_DETAIL = 4;

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
        case METHODID_CREATE_PRODUCT:
          serviceImpl.createProduct((stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PRODUCT:
          serviceImpl.updateProduct((stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse>) responseObserver);
          break;
        case METHODID_DELETE_PRODUCT:
          serviceImpl.deleteProduct((stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse>) responseObserver);
          break;
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts((stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse>) responseObserver);
          break;
        case METHODID_GET_PRODUCT_DETAIL:
          serviceImpl.getProductDetail((stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest) request,
              (io.grpc.stub.StreamObserver<stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse>) responseObserver);
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
          getCreateProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.CreateProductRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.CreateProductResponse>(
                service, METHODID_CREATE_PRODUCT)))
        .addMethod(
          getUpdateProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.UpdateProductResponse>(
                service, METHODID_UPDATE_PRODUCT)))
        .addMethod(
          getDeleteProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.DeleteProductResponse>(
                service, METHODID_DELETE_PRODUCT)))
        .addMethod(
          getListProductsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.ListProductsRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.ListProductsResponse>(
                service, METHODID_LIST_PRODUCTS)))
        .addMethod(
          getGetProductDetailMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailRequest,
              stockearte.unla.edu.ar.grpc.SystemProto.ProductDetailResponse>(
                service, METHODID_GET_PRODUCT_DETAIL)))
        .build();
  }

  private static abstract class ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return stockearte.unla.edu.ar.grpc.SystemProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductService");
    }
  }

  private static final class ProductServiceFileDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier {
    ProductServiceFileDescriptorSupplier() {}
  }

  private static final class ProductServiceMethodDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductServiceFileDescriptorSupplier())
              .addMethod(getCreateProductMethod())
              .addMethod(getUpdateProductMethod())
              .addMethod(getDeleteProductMethod())
              .addMethod(getListProductsMethod())
              .addMethod(getGetProductDetailMethod())
              .build();
        }
      }
    }
    return result;
  }
}
