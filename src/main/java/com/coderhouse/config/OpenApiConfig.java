package com.coderhouse.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	//http://localhost:8080/swagger-ui.html#
	//http://localhost:8080/swagger-ui/

	@Bean
	OpenAPI customOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("API REST Full | Java | CoderHouse")
						.version("3.0.0")
						.description("La API REST proporciona endpoints para administrar comercios, productos y "
                        		+ "clientes en una plataforma que simula las ventas y compras de los mismos. Permite realizar operaciones "
                        		+ "CRUD (Crear, Leer, Actualizar, Eliminar) tanto para clientes como "
                        		+ "para comercios y productos. Los endpoints permiten listar, agregar, mostrar, "
                        		+ "editar y eliminar comercios, productos y clientes. La API está documentada utilizando "
                        		+ "Swagger, lo que facilita la comprensión de los endpoints y su uso.")
						.contact(new Contact()
								.name("Lautaro Kaliszczak Benitez")
								.email("lautarokaliszczakb@gmail.com")
								.url("https://coderhouse.com.ar"))
						.license(new License()
								.name("Licencia")
								.url("https://github.com/LautaroKaliszczak/FacturacionEntregaProyectoFinalKaliszczakL"))
						)
						.servers(List.of(new Server()
								.url("http://localhost:8080")
								.description("Servidor Local")));
				
	}
	
}
