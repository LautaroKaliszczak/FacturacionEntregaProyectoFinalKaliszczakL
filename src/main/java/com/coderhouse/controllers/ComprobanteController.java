package com.coderhouse.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.CompraRequestDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Comprobante;
import com.coderhouse.models.LineaCompra;
import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.ComercioRepository;
import com.coderhouse.repositories.ComprobanteRepository;
import com.coderhouse.repositories.ProductoRepository;
import com.coderhouse.services.ClienteService;
import com.coderhouse.services.ComprobanteService;
import com.coderhouse.services.ProductoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private ComprobanteRepository comprobanteRepository;
    
    @GetMapping
	public ResponseEntity<List<Comprobante>> getAllComprobantes() {
		try {
			List<Comprobante> comprobante = comprobanteService.getAllComprobantes();
			return ResponseEntity.ok(comprobante);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comprobante> getComprobanteById(@PathVariable long id) {
		try {
			Comprobante comprobante = comprobanteService.findById(id);
			return ResponseEntity.ok(comprobante);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
		try {
			comprobanteService.deleteComprobante(id);
			return ResponseEntity.noContent().build();

		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
    
    
    
	@PostMapping("/comprar")
	public Comprobante realizarCompra(@Valid @RequestBody CompraRequestDTO request) {
		 System.out.println("Cliente recibido: " + request.getCliente());
	    return comprobanteService.realizarCompra(request);
	}
	
}
	
	