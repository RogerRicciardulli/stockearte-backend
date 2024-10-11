package com.unla.stockearte.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.stockearte.GetUserResponse;
import com.unla.stockearte.GetUsersResponse;
import com.unla.stockearte.UserResponse;
import com.unla.stockearte.UserSummary;
import com.unla.stockearte.repository.StoresRepository;
import com.unla.stockearte.repository.UsersRepository;
import com.unla.stockearte.repository.entity.StoreModel;
import com.unla.stockearte.repository.entity.UserModel;

@Service
public class UsersServiceLogic {

	private static final Logger log = LoggerFactory.getLogger(UsersServiceLogic.class);
    @Autowired
    private UsersRepository repository;
    @Autowired
    private StoresRepository storesRepository;
    
	public UserResponse saveUser(String username, String password, String firstName, 
			String lastName, boolean enabled, int storeId) {
		UserResponse.Builder response = UserResponse.newBuilder();
		try {
			Optional<StoreModel> storeModel = storesRepository.findById((long)storeId);
			UserModel userModel = new UserModel(username, password, firstName, lastName, enabled, storeModel.orElse(null));
			repository.save(userModel);
			response.setSuccess(true);
		} catch (Exception e) {
			log.error("[UsersServiceLogic.saveUser] Unexpected error.", e);
			response.setSuccess(false);
		}
		return response.build();
	}
	public UserResponse authenticateUser(String username, String password) {
		UserResponse.Builder response = UserResponse.newBuilder();
		try {
			UserModel userModel = repository.findByUsername(username);
			response.setSuccess(userModel.getUsername().equals(username) && userModel.getPassword().equals(password));
			if(userModel.getStore() != null)
				response.setStoreId((int)userModel.getStore().getId());
			else
				response.setStoreId(0);
		} catch (Exception e) {
			log.error("[UsersServiceLogic.authenticateUser] Unexpected error.", e);
			response.setSuccess(false);
		}
		return response.build(); 
	}
	public UserResponse asignUserToStore(int userId, int storeId) {
		UserResponse.Builder response = UserResponse.newBuilder();
		try {
			boolean result = false;
			Optional<UserModel> userModel = repository.findById((long)userId);
			Optional<StoreModel> storeModel = storesRepository.findById((long)storeId);
			if(userModel.isPresent() && storeModel.isPresent()) {
				userModel.get().setStore(storeModel.get());
				repository.save(userModel.get());
				result = true;
			}
			response.setSuccess(result);
		} catch (Exception e) {
			log.error("[UsersServiceLogic.asignUserToStore] Unexpected error.", e);
			response.setSuccess(false);
		}
		return response.build();
	}
	public UserResponse editUser(String username, String password, String firstName, 
			String lastName, boolean enabled, int storeId, int userId) {
		UserResponse.Builder response = UserResponse.newBuilder();
		try {
			boolean result = false;
			Optional<UserModel> userModel = repository.findById((long)userId);
			Optional<StoreModel> storeModel = storesRepository.findById((long)storeId);
			if(userModel.isPresent() && storeModel.isPresent()) {
				UserModel userModelModified = userModel.get();
				userModelModified.setPassword(!password.isEmpty() ? password : userModelModified.getPassword());
				userModelModified.setFirstName(!firstName.isEmpty() ? firstName : userModelModified.getFirstName());
				userModelModified.setLastName(!lastName.isEmpty() ? lastName : userModelModified.getLastName());
				if(!username.equals("CambioInterno"))
					userModelModified.setUsername(!username.isEmpty() ? username : userModelModified.getUsername());
					userModelModified.setEnabled(userModelModified.isEnabled() != enabled ? enabled : userModelModified.isEnabled());
				userModelModified.setStore(storeModel.get() != null ? storeModel.get() : userModelModified.getStore());
				repository.save(userModel.get());
				result = true;
			}
			response.setSuccess(result);
		} catch (Exception e) {
			log.error("[UsersServiceLogic.editUser] Unexpected error.", e);
			response.setSuccess(false);
		}
		return response.build(); 
	}
	public GetUsersResponse getUsers(String username, String storeCode) {
		GetUsersResponse.Builder response = GetUsersResponse.newBuilder();
		try {
			List<UserModel> users = new ArrayList<UserModel>();
			StoreModel storeModel = storesRepository.findByCode(storeCode);
			if(!username.isEmpty() && !storeCode.isEmpty()) {
				UserModel user = repository.findByUsernameAndStore(username, storeModel);
				if(user != null)
					users.add(user);
			}
			else if(!username.isEmpty()) {
				UserModel user = repository.findByUsername(username);
				if(user != null)
					users.add(user);
			}
			else if(!storeCode.isEmpty()){
				users = repository.findByStore(storeModel);
			} 
			else {
				users = repository.findAll();
			}
			for(UserModel user : users) {
			    UserSummary userSummary = UserSummary.newBuilder()
			            .setUserId(user.getId().toString())
			            .setUsername(user.getUsername())
			            .setPassword(user.getPassword())
			            .setFirstName(user.getFirstName())
			            .setLastName(user.getLastName())
			            .setEnabled(user.isEnabled())
			            .setStoreId(user.getStore() != null ? (int)user.getStore().getId() : 0)
			            .setStoreCode(user.getStore() != null ? user.getStore().getCode() : "")
			            .build();
			    response.addUsers(userSummary);
			}
		} catch (Exception e) {
			log.error("[UsersServiceLogic.getUsers] Unexpected error.", e);
		}
		return response.build(); 
	}
	public GetUserResponse getUser(int userId, String username) {
		GetUserResponse.Builder response = GetUserResponse.newBuilder();
		try {
			Optional<UserModel> userModel = Optional.of(new UserModel());
			if(!username.isEmpty())
				userModel = Optional.of(repository.findByUsername(username));
			else
				userModel = repository.findById((long)userId);
			if(userModel.isPresent()) {
				UserModel user = userModel.get();
			    UserSummary userSummary = UserSummary.newBuilder()
			            .setUserId(user.getId().toString())
			            .setUsername(user.getUsername())
			            .setPassword(user.getPassword())
			            .setFirstName(user.getFirstName())
			            .setLastName(user.getLastName())
			            .setEnabled(user.isEnabled())
			            .setStoreId(user.getStore() != null ? (int)user.getStore().getId() : 0)
			            .setStoreCode(user.getStore() != null ? user.getStore().getCode() : null)
			            .build();			
				response.setUser(userSummary);
			}
		} catch (Exception e) {
			log.error("[UsersServiceLogic.getUsers] Unexpected error.", e);
		}
		return response.build(); 
	}
	
}