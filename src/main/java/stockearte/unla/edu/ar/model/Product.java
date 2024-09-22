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
 * Product
 */
@Validated
public class Product   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("talle")
  private String talle = null;

  @JsonProperty("foto")
  private String foto = null;

  @JsonProperty("color")
  private String color = null;

  @JsonProperty("stock")
  private Integer stock = null;

  @JsonProperty("idTienda")
  @Valid
  private List<Integer> idTienda = null;

  public Product id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Product nombre(String nombre) {
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

  public Product talle(String talle) {
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

  public Product foto(String foto) {
    this.foto = foto;
    return this;
  }

  /**
   * Get foto
   * @return foto
  **/
  @ApiModelProperty(value = "")
  
    public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Product color(String color) {
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

  public Product stock(Integer stock) {
    this.stock = stock;
    return this;
  }

  /**
   * Get stock
   * @return stock
  **/
  @ApiModelProperty(value = "")
  
    public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Product idTienda(List<Integer> idTienda) {
    this.idTienda = idTienda;
    return this;
  }

  public Product addIdTiendaItem(Integer idTiendaItem) {
    if (this.idTienda == null) {
      this.idTienda = new ArrayList<Integer>();
    }
    this.idTienda.add(idTiendaItem);
    return this;
  }

  /**
   * Get idTienda
   * @return idTienda
  **/
  @ApiModelProperty(value = "")
  
    public List<Integer> getIdTienda() {
    return idTienda;
  }

  public void setIdTienda(List<Integer> idTienda) {
    this.idTienda = idTienda;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.nombre, product.nombre) &&
        Objects.equals(this.talle, product.talle) &&
        Objects.equals(this.foto, product.foto) &&
        Objects.equals(this.color, product.color) &&
        Objects.equals(this.stock, product.stock) &&
        Objects.equals(this.idTienda, product.idTienda);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, talle, foto, color, stock, idTienda);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    talle: ").append(toIndentedString(talle)).append("\n");
    sb.append("    foto: ").append(toIndentedString(foto)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    stock: ").append(toIndentedString(stock)).append("\n");
    sb.append("    idTienda: ").append(toIndentedString(idTienda)).append("\n");
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
