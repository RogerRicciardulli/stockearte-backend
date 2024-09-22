package stockearte.unla.edu.ar.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EditStoreRequest
 */
@Validated
public class EditStoreRequest   {
  @JsonProperty("storeId")
  private Integer storeId = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("province")
  private String province = null;

  @JsonProperty("enabled")
  private String enabled = null;

  @JsonProperty("usersId")
  @Valid
  private List<Integer> usersId = null;

  @JsonProperty("productsId")
  @Valid
  private List<Integer> productsId = null;

  public EditStoreRequest storeId(Integer storeId) {
    this.storeId = storeId;
    return this;
  }

  /**
   * Get storeId
   * @return storeId
  **/
  @ApiModelProperty(example = "1", value = "")
  
    public Integer getStoreId() {
    return storeId;
  }

  public void setStoreId(Integer storeId) {
    this.storeId = storeId;
  }

  public EditStoreRequest code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(example = "XYZ789", value = "")
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public EditStoreRequest address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(example = "456 Elm St", value = "")
  
    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public EditStoreRequest city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(example = "Gotham", value = "")
  
    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public EditStoreRequest province(String province) {
    this.province = province;
    return this;
  }

  /**
   * Get province
   * @return province
  **/
  @ApiModelProperty(example = "New Jersey", value = "")
  
    public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public EditStoreRequest enabled(String enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
  **/
  @ApiModelProperty(example = "true", value = "")
  
    public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }

  public EditStoreRequest usersId(List<Integer> usersId) {
    this.usersId = usersId;
    return this;
  }

  public EditStoreRequest addUsersIdItem(Integer usersIdItem) {
    if (this.usersId == null) {
      this.usersId = new ArrayList<Integer>();
    }
    this.usersId.add(usersIdItem);
    return this;
  }

  /**
   * Get usersId
   * @return usersId
  **/
  @ApiModelProperty(example = "[1,2]", value = "")
  
    public List<Integer> getUsersId() {
    return usersId;
  }

  public void setUsersId(List<Integer> usersId) {
    this.usersId = usersId;
  }

  public EditStoreRequest productsId(List<Integer> productsId) {
    this.productsId = productsId;
    return this;
  }

  public EditStoreRequest addProductsIdItem(Integer productsIdItem) {
    if (this.productsId == null) {
      this.productsId = new ArrayList<Integer>();
    }
    this.productsId.add(productsIdItem);
    return this;
  }

  /**
   * Get productsId
   * @return productsId
  **/
  @ApiModelProperty(example = "[101,102]", value = "")
  
    public List<Integer> getProductsId() {
    return productsId;
  }

  public void setProductsId(List<Integer> productsId) {
    this.productsId = productsId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EditStoreRequest editStoreRequest = (EditStoreRequest) o;
    return Objects.equals(this.storeId, editStoreRequest.storeId) &&
        Objects.equals(this.code, editStoreRequest.code) &&
        Objects.equals(this.address, editStoreRequest.address) &&
        Objects.equals(this.city, editStoreRequest.city) &&
        Objects.equals(this.province, editStoreRequest.province) &&
        Objects.equals(this.enabled, editStoreRequest.enabled) &&
        Objects.equals(this.usersId, editStoreRequest.usersId) &&
        Objects.equals(this.productsId, editStoreRequest.productsId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storeId, code, address, city, province, enabled, usersId, productsId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EditStoreRequest {\n");
    
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    usersId: ").append(toIndentedString(usersId)).append("\n");
    sb.append("    productsId: ").append(toIndentedString(productsId)).append("\n");
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
