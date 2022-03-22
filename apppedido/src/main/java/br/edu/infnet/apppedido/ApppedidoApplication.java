package br.edu.infnet.apppedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApppedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApppedidoApplication.class, args);
	}

}
