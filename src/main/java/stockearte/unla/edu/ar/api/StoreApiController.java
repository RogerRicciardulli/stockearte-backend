package stockearte.unla.edu.ar.api;

import stockearte.unla.edu.ar.model.CreateStoreRequest;
import stockearte.unla.edu.ar.model.EditStoreRequest;
import stockearte.unla.edu.ar.model.GetStoreResponse;
import stockearte.unla.edu.ar.model.StoreResponse;
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
public class StoreApiController implements StoreApi {

    private static final Logger log = LoggerFactory.getLogger(StoreApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StoreApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<StoreResponse> storeCreatePost(@ApiParam(value = "Store creation request" ,required=true )  @Valid @RequestBody CreateStoreRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StoreResponse>(objectMapper.readValue("{\r\n  \"success\" : true\r\n}", StoreResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StoreResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StoreResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StoreResponse> storeEditPut(@ApiParam(value = "Store editing request" ,required=true )  @Valid @RequestBody EditStoreRequest body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StoreResponse>(objectMapper.readValue("{\r\n  \"success\" : true\r\n}", StoreResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StoreResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StoreResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetStoreResponse> storeStoreIdGet(@ApiParam(value = "The unique ID of the store",required=true) @PathVariable("storeId") Integer storeId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetStoreResponse>(objectMapper.readValue("{\r\n  \"store\" : {\r\n    \"code\" : \"ABC123\",\r\n    \"address\" : \"123 Main St\",\r\n    \"province\" : \"New York\",\r\n    \"city\" : \"Metropolis\",\r\n    \"storeId\" : 1,\r\n    \"enabled\" : true\r\n  }\r\n}", GetStoreResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetStoreResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetStoreResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
