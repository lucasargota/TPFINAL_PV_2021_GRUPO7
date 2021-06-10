package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.service.ITuristaService;

@SpringBootApplication
public class TpfinalPv2021Grupo7Application implements CommandLineRunner{

	@Autowired
	Turista turista;
	
	@Autowired
	@Qualifier("implementacion2mysql")	
	ITuristaService turistaService;
	
	public static void main(String[] args) {
		SpringApplication.run(TpfinalPv2021Grupo7Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//inicializo un cliente para pruebas
		//turista.setApellido("user");
				
			//turista.setNombre("user");
			 
			//turista.setPais("Argentina");
			
		//	turista.setEmail("correo@gmail.com");
			
		//	turista.setPassword("123456");				
				
		//		turistaService.guardarTurista(turista);
		
	}

}
