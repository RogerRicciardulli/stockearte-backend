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
 * FilterProductRequest
 */
@Validated
public class FilterProductRequest   {
  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("codigo_unico")
  private String codigoUnico = null;

  @JsonProperty("talle")
  private String talle = null;

  @JsonProperty("color")
  private String color = null;

  public FilterProductRequest nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  **/
  @ApiModelProperty(value = "")
  
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public FilterProductRequest codigoUnico(String codigoUnico) {
    this.codigoUnico = codigoUnico;
    return this;
  }

  /**
   * Get codigoUnico
   * @return codigoUnico
  **/
  @ApiModelProperty(value = "")
  
    public String getCodigoUnico() {
    return codigoUnico;
  }

  public void setCodigoUnico(String codigoUnico) {
    this.codigoUnico = codigoUnico;
  }

  public FilterProductRequest talle(String talle) {
    this.talle = talle;
    return this;
  }

  /**
   * Get talle
   * @return talle
  **/
  @ApiModelProperty(value = "")
  
    public String getTalle() {
    return talle;
  }

  public void setTalle(String talle) {
    this.talle = talle;
  }

  public FilterProductRequest color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
  **/
  @ApiModelProperty(value = "")
  
    public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterProductRequest filterProductRequest = (FilterProductRequest) o;
    return Objects.equals(this.nombre, filterProductRequest.nombre) &&
        Objects.equals(this.codigoUnico, filterProductRequest.codigoUnico) &&
        Objects.equals(this.talle, filterProductRequest.talle) &&
        Objects.equals(this.color, filterProductRequest.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, codigoUnico, talle, color);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterProductRequest {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    codigoUnico: ").append(toIndentedString(codigoUnico)).append("\n");
    sb.append("    talle: ").append(toIndentedString(talle)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
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
