package com.coderhouse.dtos;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class CompraRequestDTO {

    @NotNull(message = "El cliente es obligatorio")
    private ClienteDTO cliente;

    @NotNull(message = "El ID del comercio es obligatorio")
    private Long comercioId;

    @NotEmpty(message = "Debe haber al menos un producto en la compra")
    private List<LineaCompraRequestDTO> lineas;
    
    
    

	public CompraRequestDTO() {
		super();
		
	}

	public CompraRequestDTO(@NotNull(message = "El cliente es obligatorio") ClienteDTO cliente,
			@NotNull(message = "El ID del comercio es obligatorio") Long comercioId,
			@NotEmpty(message = "Debe haber al menos un producto en la compra") List<LineaCompraRequestDTO> lineas) {
		super();
		this.cliente = cliente;
		this.comercioId = comercioId;
		this.lineas = lineas;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Long getComercioId() {
		return comercioId;
	}

	public void setComercioId(Long comercioId) {
		this.comercioId = comercioId;
	}

	public List<LineaCompraRequestDTO> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaCompraRequestDTO> lineas) {
		this.lineas = lineas;
	}

	@Override
	public String toString() {
		return "CompraRequestDTO [cliente=" + cliente + ", comercioId=" + comercioId + ", lineas=" + lineas + "]";
	}

   
}