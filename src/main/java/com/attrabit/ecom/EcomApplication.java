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
	@Bean
	CommandLineRunner addRoles(RolesRepository repository){
		return args -> {
			Roles roles = new Roles();
			roles.setPermissions("ROLE_USER");
			Roles roles2 = new Roles();
			roles2.setPermissions("ROLE_MEMBER");

			repository.saveAll(List.of(
					roles, roles2
			));
		};
	}

//	@Bean
//	CommandLineRunner addNID(NIDStorageService service){
//		return args -> {
//
//			NIDStorage nidStorage = new NIDStorage();
//			nidStorage.setNid("1234567890");
//
//			NIDStorage nidStorage1 = new NIDStorage();
//			nidStorage1.setNid("1234567891");
//
//			NIDStorage nidStorage2 = new NIDStorage();
//			nidStorage2.setNid("1234567892");
//
//			NIDStorage nidStorage3 = new NIDStorage();
//			nidStorage3.setNid("1234567893");
//
//			NIDStorage nidStorage4 = new NIDStorage();
//			nidStorage4.setNid("1234567894");
//
//			NIDStorage nidStorage5 = new NIDStorage();
//			nidStorage5.setNid("1234567895");
//
//			NIDStorage nidStorage6 = new NIDStorage();
//			nidStorage6.setNid("1234567896");
//
//			NIDStorage nidStorage7 = new NIDStorage();
//			nidStorage7.setNid("1234567897");
//
//
//
//			service.addNIDStorage(List.of(nidStorage, nidStorage1, nidStorage2, nidStorage3, nidStorage4, nidStorage5,
//					nidStorage6, nidStorage7));
//
//		};
//	}

}
