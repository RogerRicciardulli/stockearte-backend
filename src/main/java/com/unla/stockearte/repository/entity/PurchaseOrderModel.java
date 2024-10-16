package com.unla.stockearte.repository.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "purchase_order")
public class PurchaseOrderModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long idTienda;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "purchase_details",
            joinColumns = @JoinColumn(name = "purchase_order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_details_id")
        )
	private List<OrderDetailsModel> orderDetails;
	
	@Column(nullable = false, length = 50)
	private String state;
	
	@Column()
	private boolean isHabilitado;
	
	@Column(nullable = false, length = 200)
	private String observations;
	
	@Column(nullable = false, length = 200)
	private String orderDispatch;
	
	@Column()
	private LocalDateTime request;
	
	@Column()
	private LocalDateTime reception;
	
	public PurchaseOrderModel() {
		super();
	}
	
	
	public Long getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderDetailsModel> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailsModel> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public String getOrderDispatch() {
		return orderDispatch;
	}
	public void setOrderDispatch(String orderDispatch) {
		this.orderDispatch = orderDispatch;
	}
	
	public Long getId() {
		return id;
	}
	public boolean isHabilitado() {
		return isHabilitado;
	}

	public void setHabilitado(boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}


	public LocalDateTime getRequest() {
		return request;
	}


	public void setRequest(LocalDateTime request) {
		this.request = request;
	}


	public LocalDateTime getReception() {
		return reception;
	}


	public void setReception(LocalDateTime reception) {
		this.reception = reception;
	}

	
	
}
