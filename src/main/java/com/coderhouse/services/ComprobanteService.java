package com.coderhouse.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.dtos.CompraRequestDTO;
import com.coderhouse.dtos.LineaCompraRequestDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Comercio;
import com.coderhouse.models.Comprobante;
import com.coderhouse.models.LineaCompra;
import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.ComercioRepository;
import com.coderhouse.repositories.ComprobanteRepository;
import com.coderhouse.repositories.ProductoRepository;

@Service
public class ComprobanteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ComercioRepository comercioRepository;

    @Autowired
    private ComprobanteRepository comprobanteRepository;
    
    
    public List<Comprobante> getAllComprobantes() {
        return comprobanteRepository.findAll();
    }
    
    public Comprobante findById(Long id) {
		return comprobanteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Comprobante no encontrado"));
	}
    
    public void deleteComprobante(Long id) {
		if (!comprobanteRepository.existsById(id)) {
			throw new IllegalArgumentException("Comprobante no encontrado");
		}
		clienteRepository.deleteById(id);

	}

    public Comprobante realizarCompra(CompraRequestDTO request) {
    	
    	if (request.getCliente() == null || request.getCliente().getClienteid() == null) {
            throw new IllegalArgumentException("El cliente no puede ser null y debe tener un ID válido.");
        }

        Cliente cliente = clienteRepository.findById(request.getCliente().getClienteid())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));


        Comercio comercio = comercioRepository.findById(request.getComercioId())
                .orElseThrow(() -> new IllegalArgumentException("Comercio no encontrado"));


        Comprobante comprobante = new Comprobante();
        comprobante.setCliente(cliente);
        comprobante.setComercio(comercio);
        comprobante.setFecha(LocalDateTime.now());

        List<LineaCompra> lineas = new ArrayList<>();

        for (LineaCompraRequestDTO lineaRequest : request.getLineas()) {

            Producto producto = productoRepository.findById(lineaRequest.getProducto().getProductoid())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));


            if (!comercio.getProductos().contains(producto)) {
                throw new IllegalArgumentException("El producto " + producto.getNombre() + " no pertenece al comercio " + comercio.getNombre());
            }


            if (producto.getStock() < lineaRequest.getCantidad()) {
                throw new IllegalArgumentException("Stock insuficiente para el producto " + producto.getNombre());
            }

  
            producto.setStock(producto.getStock() - lineaRequest.getCantidad());
            productoRepository.save(producto);

       
            LineaCompra lineaCompra = new LineaCompra();
            lineaCompra.setProducto(producto);
            lineaCompra.setCantidad(lineaRequest.getCantidad());
            lineas.add(lineaCompra);
        }

        comprobante.setLineas(lineas);
        comprobanteRepository.save(comprobante);

        return comprobante;
    }



    private LocalDateTime obtenerFechaActual() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://worldclockapi.com/api/json/utc/now";
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            String fechaActual = (String) response.get("currentDateTime");
            return LocalDateTime.parse(fechaActual);
        } catch (Exception e) {
            return LocalDateTime.now(); 
        }
    }
}