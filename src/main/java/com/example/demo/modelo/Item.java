package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
@NamedNativeQuery(name = "Item.buscarPorCodigo", query = "Select * from item where item_codigo_barras = :datoCodigo", resultClass = Item.class)
@NamedNativeQuery(name = "Item.actualizarPorCodigo", query = "Update item set item_stock = :datoStock where item_codigo_barras = :datoCodigo", resultClass = Item.class)

public class Item {

	@Id
	@GeneratedValue(generator = "seq_", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, name = "seq_", sequenceName = "seq_")
	@Column(name = "item_id")
	private Integer id;

	@Column(name = "item_codigo_barras")
	private String codigoBarras;

	@Column(name = "item_nombre")
	private String nombre;

	@Column(name = "item_tipo")
	private String tipo;

	@Column(name = "item_stock")
	private Integer stock;

	@Column(name = "item_precio")
	private BigDecimal precio;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<DetalleFactura> detalleFacturas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

}
