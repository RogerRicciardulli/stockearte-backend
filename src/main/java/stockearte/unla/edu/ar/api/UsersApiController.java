package stockearte.unla.edu.ar.api;

import stockearte.unla.edu.ar.model.GetUsersResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<GetUsersResponse> usersGet(@ApiParam(value = "Filter users by username") @Valid @RequestParam(value = "username", required = false) String username
,@ApiParam(value = "Filter users by store code") @Valid @RequestParam(value = "storeCode", required = false) String storeCode
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetUsersResponse>(objectMapper.readValue("{\r\n  \"users\" : [ {\r\n    \"firstName\" : \"John\",\r\n    \"lastName\" : \"Doe\",\r\n    \"password\" : \"password123\",\r\n    \"storeId\" : 1,\r\n    \"userId\" : \"1\",\r\n    \"enabled\" : true,\r\n    \"username\" : \"johndoe\",\r\n    \"storeCode\" : \"ABC123\"\r\n  }, {\r\n    \"firstName\" : \"John\",\r\n    \"lastName\" : \"Doe\",\r\n    \"password\" : \"password123\",\r\n    \"storeId\" : 1,\r\n    \"userId\" : \"1\",\r\n    \"enabled\" : true,\r\n    \"username\" : \"johndoe\",\r\n    \"storeCode\" : \"ABC123\"\r\n  } ]\r\n}", GetUsersResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetUsersResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetUsersResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
