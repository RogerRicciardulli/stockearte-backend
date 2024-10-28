package com.unla.stockearte.repository.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "catalogo")
public class CatalogoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 20)
	private String titulo;
	@Column(nullable = true, length = 20)
	private Long tiendaID;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "catalogo_id")
	private List<ProductModel> productos;
	
	public CatalogoModel() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getTiendaID() {
		return tiendaID;
	}

	public void setTiendaID(Long tiendaID) {
		this.tiendaID = tiendaID;
	}

	public List<ProductModel> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductModel> productos) {
		this.productos = productos;
	}
	
	}
