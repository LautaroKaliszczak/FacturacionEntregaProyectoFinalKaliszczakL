package com.coderhouse.dtos;

import jakarta.validation.constraints.NotNull;

public class ProductoDTO {

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productoId;

    
	public ProductoDTO() {
		super();
	
	}

	public ProductoDTO(@NotNull(message = "El ID del producto es obligatorio") Long productoid) {
		super();
		this.productoId = productoid;
	}

	public Long getProductoid() {
		return productoId;
	}

	public void setProductoid(Long productoid) {
		this.productoId = productoid;
	}

	@Override
	public String toString() {
		return "ProductoDTO [productoid=" + productoId + "]";
	}

	
    
}
