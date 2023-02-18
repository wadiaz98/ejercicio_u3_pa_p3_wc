package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

	@Id
	@GeneratedValue(generator = "seq_deta", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, name = "seq_deta", sequenceName = "seq_deta")
	@Column(name = "deta_id")
	private Integer id;

	@Column(name = "deta_cantidad")
	private Integer canitdad;

	@Column(name = "deta_precio_unitario")
	private BigDecimal precioUnitario;

	@Column(name = "deta_subtotal")
	private BigDecimal subtotal;

	@ManyToOne
	@JoinColumn(name = "deta_id_item")
	private Item item;

	@ManyToOne
	@JoinColumn(name = "deta_id_factura")
	private Factura factura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCanitdad() {
		return canitdad;
	}

	public void setCanitdad(Integer canitdad) {
		this.canitdad = canitdad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}
