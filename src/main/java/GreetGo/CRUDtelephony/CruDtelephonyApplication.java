package GreetGo.CRUDtelephony;

import GreetGo.CRUDtelephony.entity.ClientDocument;
import GreetGo.CRUDtelephony.repository.mongodb.ClientMongoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruDtelephonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDtelephonyApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ClientMongoRepository clientMongoRepository) {
		return args -> {
			ClientDocument client1 = new ClientDocument(null, "John", "Doe", "1234567890", "0987654321", "2000-01-01");
			ClientDocument client2 = new ClientDocument(null, "Jane", "Doe", "2234567890", "1987654321", "1990-01-01");
			clientMongoRepository.save(client1);
			clientMongoRepository.save(client2);
		};
	}
}
