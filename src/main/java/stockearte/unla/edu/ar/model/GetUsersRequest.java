package stockearte.unla.edu.ar.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetUsersRequest
 */
@Validated
public class GetUsersRequest   {
  @JsonProperty("username")
  private String username = null;

  @JsonProperty("storeCode")
  private String storeCode = null;

  public GetUsersRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")
  
    public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public GetUsersRequest storeCode(String storeCode) {
    this.storeCode = storeCode;
    return this;
  }

  /**
   * Get storeCode
   * @return storeCode
  **/
  @ApiModelProperty(value = "")
  
    public String getStoreCode() {
    return storeCode;
  }

  public void setStoreCode(String storeCode) {
    this.storeCode = storeCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUsersRequest getUsersRequest = (GetUsersRequest) o;
    return Objects.equals(this.username, getUsersRequest.username) &&
        Objects.equals(this.storeCode, getUsersRequest.storeCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, storeCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUsersRequest {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    storeCode: ").append(toIndentedString(storeCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
