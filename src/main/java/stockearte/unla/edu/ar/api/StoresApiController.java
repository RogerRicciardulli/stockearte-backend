package stockearte.unla.edu.ar.api;

import stockearte.unla.edu.ar.model.GetStoresResponse;
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
public class StoresApiController implements StoresApi {

    private static final Logger log = LoggerFactory.getLogger(StoresApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StoresApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<GetStoresResponse> storesGet(@ApiParam(value = "Filter stores by code") @Valid @RequestParam(value = "code", required = false) String code
,@ApiParam(value = "Filter stores by enabled status") @Valid @RequestParam(value = "enabled", required = false) String enabled
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetStoresResponse>(objectMapper.readValue("{\r\n  \"stores\" : [ {\r\n    \"code\" : \"ABC123\",\r\n    \"address\" : \"123 Main St\",\r\n    \"province\" : \"New York\",\r\n    \"city\" : \"Metropolis\",\r\n    \"storeId\" : 1,\r\n    \"enabled\" : true\r\n  }, {\r\n    \"code\" : \"ABC123\",\r\n    \"address\" : \"123 Main St\",\r\n    \"province\" : \"New York\",\r\n    \"city\" : \"Metropolis\",\r\n    \"storeId\" : 1,\r\n    \"enabled\" : true\r\n  } ]\r\n}", GetStoresResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetStoresResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetStoresResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
