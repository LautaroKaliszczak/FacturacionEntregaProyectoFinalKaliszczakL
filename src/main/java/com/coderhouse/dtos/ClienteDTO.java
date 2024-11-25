package com.coderhouse.dtos;

import jakarta.validation.constraints.NotNull;

public class ClienteDTO {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;
    
    

	public ClienteDTO() {
		super();
		
	}

	public ClienteDTO(@NotNull(message = "El ID del cliente es obligatorio") Long clienteid) {
		super();
		this.clienteId = clienteid;
	}

	public Long getClienteid() {
		return clienteId;
	}

	public void setClienteid(Long clienteid) {
		this.clienteId = clienteid;
	}

	@Override
	public String toString() {
		return "ClienteDTO [clienteid=" + clienteId + "]";
	}

    
}
