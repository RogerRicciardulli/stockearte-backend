package com.unla.stockearte.repository.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "filters")
public class FiltersModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, length = 20)
    private String productCode;
    @Column(nullable = false, length = 20)
    private String filtersName;
    @Column(nullable = true, length = 20)
    private String state;
    @Column(nullable = true, length = 20)
    private Long idTienda;
    @Column(nullable = true)
    private LocalDate desde;
    @Column(nullable = true)
    private LocalDate hasta;
    @Column(nullable = false)
    private boolean habilitado;
    
    public FiltersModel() {
		super();
	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getFiltersName() {
		return filtersName;
	}
	public void setFiltersName(String filtersName) {
		this.filtersName = filtersName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}
	public LocalDate getDesde() {
		return desde;
	}
	public void setDesde(LocalDate desde) {
		this.desde = desde;
	}
	public LocalDate getHasta() {
		return hasta;
	}
	public void setHasta(LocalDate hasta) {
		this.hasta = hasta;
	}

	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

}
