package com.unla.stockearte.repository.model;

import java.time.LocalDateTime;
import java.util.List;

import com.unla.stockearte.repository.entity.OrderDetailsModel;

public class PurchaseOrderKafka {
	
	private long idTienda;
	private long idOrden;
	private LocalDateTime fechaSolicitud;
	List<OrderDetailsModel> list;
	
	public long getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(long idTienda) {
		this.idTienda = idTienda;
	}
	public long getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}
	public LocalDateTime getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public List<OrderDetailsModel> getList() {
		return list;
	}
	public void setList(List<OrderDetailsModel> list) {
		this.list = list;
	}
}
