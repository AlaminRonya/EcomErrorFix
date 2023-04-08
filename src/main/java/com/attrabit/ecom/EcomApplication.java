package com.attrabit.ecom;

import com.attrabit.ecom.model.Roles;
import com.attrabit.ecom.repository.RolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}
//	@Bean
//	CommandLineRunner addRoles(RolesRepository repository){
//		return args -> {
//			Roles roles = new Roles();
//			roles.setPermissions("ROLE_USER");
//			Roles roles2 = new Roles();
//			roles2.setPermissions("ROLE_MEMBER");
//
//			repository.saveAll(List.of(
//					roles, roles2
//			));
//		};
//	}



}
