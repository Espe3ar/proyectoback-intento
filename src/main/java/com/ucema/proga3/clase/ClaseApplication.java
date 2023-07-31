package com.ucema.proga3.clase;

import com.ucema.proga3.clase.Model.Aviso;
import com.ucema.proga3.clase.Model.Role;
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
			Role admin = new Role("ADMIN");
			Role user = new Role("USER");
			userService.createRole(admin);
			userService.createRole(user);
			User userAdmin = userService.createUsuario(new User("useradmin", "pass123", admin));
			User user1 = userService.createUsuario(new User("user1", "pass123", user));
			User user2 = userService.createUsuario(new User("user2", "pass123", user));
			User user3 = userService.createUsuario(new User("user3", "pass123", user));

			Aviso aviso1= avisoService.createAviso("Este es el aviso numero 1 ", user1);
			Aviso aviso2= avisoService.createAviso("Este es el aviso numero 2 ", user2);
			Aviso aviso3= avisoService.createAviso("Este es el aviso numero 3 ", user3);
			Aviso aviso4= avisoService.createAviso("Este es el aviso numero 4 ", user1);
			Aviso aviso5= avisoService.createAviso("Este es el aviso numero 5 ", user2);



		};

	}

}
