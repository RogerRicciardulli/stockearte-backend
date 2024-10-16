package com.unla.stockearte.repository.entity;

import java.time.LocalDateTime;

public class DispatchOrder {
	
	private long idOrden;
	private long idDespacho;
	
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

}
