package com.unla.stockearte.servicesimpl;

import org.lognet.springboot.grpc.GRpcService;

import com.unla.stockearte.CreateUserRequest;
import com.unla.stockearte.CreateUserResponse;
import com.unla.stockearte.UserServiceGrpc.UserServiceImplBase;

import io.grpc.stub.StreamObserver;

@GRpcService
public class UserService extends UserServiceImplBase{
	
	@Override
	public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {
		System.out.println("Unico mensaje - Nuevo mensaje recibido: " +request);
		CreateUserResponse response = CreateUserResponse.newBuilder()
										.setSuccess(true)
										.build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
