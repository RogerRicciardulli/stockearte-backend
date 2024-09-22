package stockearte.unla.edu.ar.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import stockearte.unla.edu.ar.model.StoreSummary;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetStoresResponse
 */
@Validated
public class GetStoresResponse   {
  @JsonProperty("stores")
  @Valid
  private List<StoreSummary> stores = null;

  public GetStoresResponse stores(List<StoreSummary> stores) {
    this.stores = stores;
    return this;
  }

  public GetStoresResponse addStoresItem(StoreSummary storesItem) {
    if (this.stores == null) {
      this.stores = new ArrayList<StoreSummary>();
    }
    this.stores.add(storesItem);
    return this;
  }

  /**
   * Get stores
   * @return stores
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<StoreSummary> getStores() {
    return stores;
  }

  public void setStores(List<StoreSummary> stores) {
    this.stores = stores;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetStoresResponse getStoresResponse = (GetStoresResponse) o;
    return Objects.equals(this.stores, getStoresResponse.stores);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stores);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetStoresResponse {\n");
    
    sb.append("    stores: ").append(toIndentedString(stores)).append("\n");
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
