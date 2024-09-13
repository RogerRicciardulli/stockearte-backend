package com.unla.stockearte.servicesimpl;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.unla.stockearte.AsignUserToStoreRequest;
import com.unla.stockearte.AuthenticateUserRequest;
import com.unla.stockearte.CreateUserRequest;
import com.unla.stockearte.EditUserRequest;
import com.unla.stockearte.GetUsersRequest;
import com.unla.stockearte.GetUsersResponse;
import com.unla.stockearte.UserResponse;
import com.unla.stockearte.UserServiceGrpc.UserServiceImplBase;
import com.unla.stockearte.services.UsersServiceLogic;

import io.grpc.stub.StreamObserver;

@GRpcService
public class UserService extends UserServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UsersServiceLogic usersServiceLogic;
    
	@Override
	public void createUser(CreateUserRequest request, StreamObserver<UserResponse> responseObserver) {
    	log.info("[UserService.createUser] username = {}, password = {}, firstName = {}, lastName = {},"
    			+ "enabled = {}, storeId = {}", request.getUsername(), request.getPassword(), request.getFirstName(), 
				request.getLastName(), request.getEnabled(), request.getStoreId());
    	UserResponse UserResponse = usersServiceLogic.saveUser(request.getUsername(), request.getPassword(), request.getFirstName(), 
				request.getLastName(), request.getEnabled(), request.getStoreId());
    	log.info("[UserService.createUser] response = {}", UserResponse);
		responseObserver.onNext(UserResponse);
		responseObserver.onCompleted();
	}
	@Override
	public void authenticateUser(AuthenticateUserRequest request, StreamObserver<UserResponse> responseObserver) {
    	log.info("[UserService.authenticateUser] username = {}, password = {}", request.getUsername(), request.getPassword());
    	UserResponse UserResponse = usersServiceLogic.authenticateUser(request.getUsername(), request.getPassword());
    	log.info("[UserService.authenticateUser] response = {}", UserResponse);
		responseObserver.onNext(UserResponse);
		responseObserver.onCompleted();
	}
	@Override
	public void asignUserToStore(AsignUserToStoreRequest request, StreamObserver<UserResponse> responseObserver) {
    	log.info("[UserService.asignUserToStore] userId = {}, storeId = {}", request.getUserId(), request.getStoreId());
    	UserResponse UserResponse = usersServiceLogic.asignUserToStore(request.getUserId(), request.getStoreId());
    	log.info("[UserService.asignUserToStore] response = {}", UserResponse);
		responseObserver.onNext(UserResponse);
		responseObserver.onCompleted();
	}
	@Override
	public void editUser(EditUserRequest request, StreamObserver<UserResponse> responseObserver) {
    	log.info("[UserService.editUser] username = {}, password = {}, firstName = {}, lastName = {},"
    			+ "enabled = {}, storeId = {}, userId = {}", request.getUsername(), request.getPassword(), request.getFirstName(), 
				request.getLastName(), request.getEnabled(), request.getStoreId(), request.getUserId());
    	UserResponse UserResponse = usersServiceLogic.editUser(request.getUsername(), request.getPassword(), request.getFirstName(), 
				request.getLastName(), request.getEnabled(), request.getStoreId(), request.getUserId());
    	log.info("[UserService.editUser] response = {}", UserResponse);
		responseObserver.onNext(UserResponse);
		responseObserver.onCompleted();
	}
	@Override
	public void getUsers(GetUsersRequest request, StreamObserver<GetUsersResponse> responseObserver) {
    	log.info("[UserService.getUsers] username = {}, storeCode = {}", request.getUsername(), request.getStoreCode());
    	GetUsersResponse UserResponse = usersServiceLogic.getUsers(request.getUsername(), request.getStoreCode());
    	log.info("[UserService.getUsers] response = {}", UserResponse);
		responseObserver.onNext(UserResponse);
		responseObserver.onCompleted();
	}

}