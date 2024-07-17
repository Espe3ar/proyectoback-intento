package com.ucema.proga3.clase;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Model.User;
import com.ucema.proga3.clase.Servicios.IAvisoService;
import com.ucema.proga3.clase.Servicios.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.*;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaseApplication.class, args);
	}
	@Bean
	CommandLineRunner run(@Autowired IAvisoService avisoService, @Autowired IUsuarioService userService){

		return args -> {
			User userAdmin = userService.createUsuario(new User("useradmin", "pass123"));
			User user1 = userService.createUsuario(new User("user1", "pass123"));
			User user2 = userService.createUsuario(new User("user2", "pass123"));
			User user3 = userService.createUsuario(new User("user3", "pass123"));

		};

	}

}
