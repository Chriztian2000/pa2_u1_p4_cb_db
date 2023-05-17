package com.example.demo;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4CbDbApplication implements CommandLineRunner{
		
	@Autowired  //inyeccion de dependencias
	private Profesor profe2;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4CbDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola mi primer proyecto");
		
		Profesor profe=new Profesor ();
		profe.setApellido("Betancourt");
		profe.setCedula("1722781000");
		profe.setFechaNacimienti(LocalDateTime.now());
		profe.setNombre("Christian");
		
		System.out.println(profe);
		profe.setApellido("Velez");
		System.out.println(profe.getApellido());
		
		//profe2 = new Profesor();
		
						
		System.out.println(profe2);
		profe2.setApellido("Boada");
		System.out.println(profe2.getApellido());
		
		
		
		Profesor profe3 = new Profesor();
		profe3=profe;
		System.out.println(profe3);
		profe.setApellido("Aguinaga");
		System.out.println(profe3);
		
		MatriculaCalculo mat=new MatriculaCalculo();
		mat.realizarMatricula("1");
		
		/* Spring frameword}k: Framework que permite la construccion/desarrollo 
		 de aplicaciones empresariales bsasadas en Spring
		 */
	}

}
