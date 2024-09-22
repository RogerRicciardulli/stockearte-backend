package stockearte.unla.edu.ar.api;

import stockearte.unla.edu.ar.model.AsignUserToStoreRequest;
import stockearte.unla.edu.ar.model.AuthenticateUserRequest;
import stockearte.unla.edu.ar.model.CreateUserRequest;
import stockearte.unla.edu.ar.model.EditUserRequest;
import stockearte.unla.edu.ar.model.GetUserResponse;
import stockearte.unla.edu.ar.model.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unla.stockearte.services.UsersServiceLogic;

import io.swagger.annotations.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);	
    @Autowired
    private UsersServiceLogic usersService;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<UserResponse> userAssignStorePost(@ApiParam(value = "Assign user to store request" ,required=true )  @Valid @RequestBody AsignUserToStoreRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserResponse>(objectMapper.readValue("{\r\n  \"success\" : true\r\n}", UserResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserResponse> userAuthenticatePost(@ApiParam(value = "User authentication request" ,required=true )  @Valid @RequestBody AuthenticateUserRequest body
) {
    	UserResponse response = new UserResponse();
    	HttpStatus httpStatus = HttpStatus.OK;
    	log.info("[UserApiController.authenticateUser] username = {}, password = {}", body.getUsername(), body.getPassword());
    	try {
			response.setSuccess(usersService.authenticateUser(body.getUsername(), body.getPassword()).getSuccess());
		} catch (Exception e) {
			log.error("[UserApiController.userGetter] Unexpected error.", e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		log.debug("[UserApiController.userGetter] response = {}", response);
		return new ResponseEntity<>(response, httpStatus);
    }

    public ResponseEntity<UserResponse> userCreatePost(@ApiParam(value = "User creation request" ,required=true )  @Valid @RequestBody CreateUserRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserResponse>(objectMapper.readValue("{\r\n  \"success\" : true\r\n}", UserResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserResponse> userEditPut(@ApiParam(value = "User editing request" ,required=true )  @Valid @RequestBody EditUserRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserResponse>(objectMapper.readValue("{\r\n  \"success\" : true\r\n}", UserResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetUserResponse> userUserIdGet(@ApiParam(value = "The unique ID of the user",required=true) @PathVariable("userId") Integer userId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetUserResponse>(objectMapper.readValue("{\r\n  \"user\" : {\r\n    \"firstName\" : \"John\",\r\n    \"lastName\" : \"Doe\",\r\n    \"password\" : \"password123\",\r\n    \"storeId\" : 1,\r\n    \"userId\" : \"1\",\r\n    \"enabled\" : true,\r\n    \"username\" : \"johndoe\",\r\n    \"storeCode\" : \"ABC123\"\r\n  }\r\n}", GetUserResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetUserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetUserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
