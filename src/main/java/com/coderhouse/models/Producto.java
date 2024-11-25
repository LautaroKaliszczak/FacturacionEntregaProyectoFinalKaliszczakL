package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "Productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 @Column(name = "Nombre",unique = true)
	 private String nombre;
	 @Min(value = 0, message = "El precio no puede ser negativo")
	 @Column(name = "Precio")
	 private double precio;
	 @Min(value = 0, message = "El stock no puede ser negativo")
	 @Column(name = "Stock")
	 private int stock;
	 
	 @ManyToMany(mappedBy = "productos" ,fetch = FetchType.EAGER)
	 
	 private List<Comercio> comercios = new ArrayList<>();

	 @OneToMany(mappedBy = "producto")
	    private List<LineaCompra> detallesComprobante;
	 
	public List<LineaCompra> getDetallesComprobante() {
		return detallesComprobante;
	}

	public void setDetallesComprobante(List<LineaCompra> detallesComprobante) {
		this.detallesComprobante = detallesComprobante;
	}

	public Producto() {
		super();
	
	}

	public Producto(Long id, String nombre, @Min(value = 0, message = "El precio no puede ser negativo") double precio,
			@Min(value = 0, message = "El stock no puede ser negativo") int stock, List<Comercio> comercios,
			List<LineaCompra> detallesComprobante) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.comercios = comercios;
		this.detallesComprobante = detallesComprobante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	  public void setPrecio(double precio) {
	        if (precio < 0) {
	            throw new IllegalArgumentException("El precio no puede ser negativo.");
	        }
	        this.precio = precio;
	    }

	public int getStock() {
		return stock;
	}

	   public void setStock(int stock) {
	        if (stock < 0) {
	            throw new IllegalArgumentException("El stock no puede ser negativo.");
	        }
	        this.stock = stock;
	   }

	public List<Comercio> getComercios() {
		return comercios;
	}

	public void setComercios(List<Comercio> comercios) {
		this.comercios = comercios;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", comercios="
				+ comercios + ", detallesComprobante=" + detallesComprobante + "]";
	}

	
	
	
}

