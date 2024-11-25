package com.coderhouse.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class LineaCompraRequestDTO {

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;

    @NotNull(message = "El producto es obligatorio")
    private ProductoDTO producto;
    
    
    

	public LineaCompraRequestDTO() {
		super();
	
	}

	public LineaCompraRequestDTO(
			@NotNull(message = "La cantidad es obligatoria") @Min(value = 1, message = "La cantidad debe ser al menos 1") Integer cantidad,
			@NotNull(message = "El producto es obligatorio") ProductoDTO producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "LineaCompraRequestDTO [cantidad=" + cantidad + ", producto=" + producto + "]";
	}

   
}