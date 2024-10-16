package com.unla.stockearte.soap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Clase Java para PurchaseOrder complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PurchaseOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orden_despacho" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaSolicitud" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaRecepcion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idTienda" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orders" type="{http://stockearte-backend.com/}OrderDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseOrder", propOrder = {
    "id",
    "estado",
    "observaciones",
    "ordenDespacho",
    "fechaSolicitud",
    "fechaRecepcion",
    "idTienda",
    "orders"
})
public class PurchaseOrder {

    protected int id;
    @XmlElement(required = true)
    protected String estado;
    protected String observaciones;
    @XmlElement(name = "orden_despacho")
    protected String ordenDespacho;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaSolicitud;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRecepcion;
    protected int idTienda;
    @XmlElement(required = true)
    protected List<OrderDetail> orders;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value valor para establecer en id
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value valor para establecer en estado
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value valor para establecer en observaciones
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad ordenDespacho.
     * 
     * @return ordenDespacho
     */
    public String getOrdenDespacho() {
        return ordenDespacho;
    }

    /**
     * Define el valor de la propiedad ordenDespacho.
     * 
     * @param value valor para establecer en ordenDespacho
     */
    public void setOrdenDespacho(String value) {
        this.ordenDespacho = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSolicitud.
     * 
     * @return fechaSolicitud
     */
    public XMLGregorianCalendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Define el valor de la propiedad fechaSolicitud.
     * 
     * @param value valor para establecer en fechaSolicitud
     */
    public void setFechaSolicitud(XMLGregorianCalendar value) {
        this.fechaSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRecepcion.
     * 
     * @return fechaRecepcion
     */
    public XMLGregorianCalendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Define el valor de la propiedad fechaRecepcion.
     * 
     * @param value valor para establecer en fechaRecepcion
     */
    public void setFechaRecepcion(XMLGregorianCalendar value) {
        this.fechaRecepcion = value;
    }

    /**
     * Obtiene el valor de la propiedad idTienda.
     * 
     * @return idTienda
     */
    public int getIdTienda() {
        return idTienda;
    }

    /**
     * Define el valor de la propiedad idTienda.
     * 
     * @param value valor para establecer en idTienda
     */
    public void setIdTienda(int value) {
        this.idTienda = value;
    }

    /**
     * Obtiene la lista de detalles de órdenes.
     * 
     * <p>
     * Este método de acceso devuelve una referencia a la lista en vivo,
     * no a una instantánea. Por lo tanto, cualquier modificación que realice
     * en la lista devuelta se reflejará dentro del objeto JAXB.
     * 
     * <p>
     * Para agregar un nuevo elemento, haga lo siguiente:
     * <pre>
     *    getOrders().add(newItem);
     * </pre>
     * 
     * <p>
     * Objetos del siguiente tipo están permitidos en la lista
     * {@link OrderDetail }
     * 
     * @return lista de órdenes
     */
    public List<OrderDetail> getOrders() {
        if (orders == null) {
            orders = new ArrayList<OrderDetail>();
        }
        return this.orders;
    }

    /**
     * Define el valor de la lista de detalles de órdenes.
     * 
     * @param orders lista de detalles de órdenes para establecer
     */
    public void setOrders(List<OrderDetail> orders) {
        this.orders = orders;
    }

    /**
     * Elimina un detalle de orden de la lista de órdenes.
     * 
     * @param order el detalle de orden a eliminar
     * @return verdadero si el detalle de orden fue eliminado, falso si no estaba en la lista
     */
    public boolean removeOrder(OrderDetail order) {
        return getOrders().remove(order);
    }
}
