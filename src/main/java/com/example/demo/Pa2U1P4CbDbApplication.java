package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cajero;
import com.example.demo.banco.repository.modelo.Presidente;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CargaSistemaService;
import com.example.demo.banco.service.TranferenciaServiceImpl;

@SpringBootApplication
public class Pa2U1P4CbDbApplication implements CommandLineRunner {

	@Autowired
	private Cajero cajero;
	
	@Autowired
	private Cajero cajero1;
	
	@Autowired
	private Presidente presidente;
	
	@Autowired
	private Presidente presidente1;
	
	@Autowired
	private CargaSistemaService cargaSistemaService;
	
	@Autowired
	private TranferenciaServiceImpl tranferencia;
	

	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4CbDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		this.cajero.setApellido("Boada");
		this.cajero.setNombre("David");
		this.cajero.setSalario(new BigDecimal(100));
		
		System.out.println(this.cajero);
		
		
		this.cajero.setApellido("Betancourt");
		this.cajero.setNombre("Christian");
		this.cajero.setSalario(new BigDecimal(100));
		System.out.println(this.cajero1);
		System.out.println(this.cajero1.getApellido());
		

		this.presidente.setApellido("Alban");
		this.presidente.setNombre("Andre");
		this.presidente.setCedula("1720030723");
		
		this.presidente1.setNombre("Alejandro");
		System.out.println(this.presidente);
		System.out.println(this.presidente1);
		
		System.out.println("**********\segunda Parte");
		
		this.cargaSistemaService.cargar();
		
		Transferencia trans = new Transferencia();
		trans.setCuentaDestino(null);
		trans.setCuentaOrigen(null);
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(new BigDecimal(100));
		trans.setNumero("123456");
		this.tranferencia.guardar(trans);

		
		
	
	}
}
