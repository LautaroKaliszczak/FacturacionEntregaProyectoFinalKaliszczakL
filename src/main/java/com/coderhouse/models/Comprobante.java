package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "comercio_id", nullable = false)
    private Comercio comercio;

    private LocalDateTime fecha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "comprobante_id")
    private List<LineaCompra> lineas;

    
	public Comprobante() {
		super();
		
	}
	

	public Comprobante(Long id, Cliente cliente, Comercio comercio, LocalDateTime fecha, List<LineaCompra> lineas) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.comercio = comercio;
		this.fecha = fecha;
		this.lineas = lineas;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Comercio getComercio() {
		return comercio;
	}

	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<LineaCompra> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaCompra> lineas) {
		this.lineas = lineas;
	}


	@Override
	public String toString() {
		return "Comprobante [id=" + id + ", cliente=" + cliente + ", comercio=" + comercio + ", fecha=" + fecha
				+ ", lineas=" + lineas + "]";
	}
	

   
}