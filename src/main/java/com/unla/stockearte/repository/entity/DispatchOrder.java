package com.unla.stockearte.repository.entity;


public class DispatchOrder {
	
	private long idOrden;
	private long idDespacho;
	private String estado;
	
	public DispatchOrder() {
		super();
	}
	public long getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}
	public long getIdDespacho() {
		return idDespacho;
	}
	public void setIdDespacho(long idDepsacho) {
		this.idDespacho = idDepsacho;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
