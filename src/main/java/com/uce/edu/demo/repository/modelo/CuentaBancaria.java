package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {
	@Id
	@Column(name = "cuba_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuba_id_seq")
	@SequenceGenerator(name = "cuba_id_seq", sequenceName = "cuba_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "cuba_numero")
	private String numero;
	@Column(name = "cuba_monto")
	private BigDecimal monto;
	@Column(name = "cuba_tipo")
	private String tipo;
	@OneToMany(mappedBy = "cuentaOrigen")
	private List<Transferencia> transferenciasOrigen;
	
	@OneToMany(mappedBy = "cuentaDestino")
	private List<Transferencia> transferenciasDestino;

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", monto=" + monto + ", tipo=" + tipo
				+  "]";
	}

	// set y get
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

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Transferencia> getTransferenciasOrigen() {
		return transferenciasOrigen;
	}

	public void setTransferenciasOrigen(List<Transferencia> transferenciasOrigen) {
		this.transferenciasOrigen = transferenciasOrigen;
	}

	public List<Transferencia> getTransferenciasDestino() {
		return transferenciasDestino;
	}

	public void setTransferenciasDestino(List<Transferencia> transferenciasDestino) {
		this.transferenciasDestino = transferenciasDestino;
	}

	

}
