package br.com.resource.santander.gestaodegastosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe de inicializacao do SpringBoot!.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class GestaodegastosapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaodegastosapiApplication.class, args);
	}
}
