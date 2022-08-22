package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="factura_electronica")
public class FacturaElectronica {
	
	@Id
	@Column(name = "fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_id_seq")
	@SequenceGenerator(name = "fact_id_seq", sequenceName = "fact_id_seq", allocationSize = 1) //allocationSice es para la secuencia
	private Integer id;
	@Column(name = "fact_numero")
	private String numero;
	@Column(name = "fact_fecha_creacion")
	private LocalDateTime fechaCreacion;
	@Column(name = "fact_monto")
	private BigDecimal monto;
	@Column(name = "fact_numero_detalles")
	private Integer numeroDetalles;
	
	@Override
	public String toString() {
		return "FacturaElectronica [id=" + id + ", numero=" + numero + ", fechaCreacion=" + fechaCreacion + ", monto="
				+ monto + ", numeroDetalles=" + numeroDetalles + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public Integer getNumeroDetalles() {
		return numeroDetalles;
	}
	public void setNumeroDetalles(Integer numeroDetalles) {
		this.numeroDetalles = numeroDetalles;
	}

	
}
