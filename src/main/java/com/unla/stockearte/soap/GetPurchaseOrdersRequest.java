package com.unla.stockearte.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "GetPurchaseOrdersRequest", namespace = "http://stockearte-backend.com/")
public class GetPurchaseOrdersRequest {

    private Integer id;
    private String codigoProducto;
    private Date fechaDesde;
    private Date fechaHasta;
    private String estado;
    private Integer tienda;

    @XmlElement(name = "id", namespace = "http://stockearte-backend.com/")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement(name = "codigoProducto", namespace = "http://stockearte-backend.com/")
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @XmlElement(name = "fechaDesde", namespace = "http://stockearte-backend.com/")
    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    @XmlElement(name = "fechaHasta", namespace = "http://stockearte-backend.com/")
    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @XmlElement(name = "estado", namespace = "http://stockearte-backend.com/")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlElement(name = "tienda", namespace = "http://stockearte-backend.com/")
    public Integer getTienda() {
        return tienda;
    }

    public void setTienda(Integer tienda) {
        this.tienda = tienda;
    }
}
