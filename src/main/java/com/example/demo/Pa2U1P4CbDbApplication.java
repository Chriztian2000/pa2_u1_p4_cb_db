package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TranferenciaService;

@SpringBootApplication
public class Pa2U1P4CbDbApplication implements CommandLineRunner {

	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private TranferenciaService tranferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4CbDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cuenta cta1 = new Cuenta();
		cta1.setCedulaPropietario("1722781000");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("123456");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		this.cuentaService.guardar(cta1);
		
		
		Cuenta cta2 = new Cuenta();
		cta2.setCedulaPropietario("1709049561");
		cta2.setFechaApertura(LocalDate.now());
		cta2.setNumero("654321");
		cta2.setSaldo(new BigDecimal(100));
		cta2.setTipo("A");
		this.cuentaService.guardar(cta2);
		
		this.tranferenciaService.realizar("123456", "654321", new BigDecimal(10));
		
		System.out.println("Saldo origen: "+this.cuentaService.buscarPorNumero("123456").getSaldo());
		System.out.println("Saldo destino: "+this.cuentaService.buscarPorNumero("654321").getSaldo());
		
		List<Transferencia> a= this.tranferenciaService.estadoCuenta();
		for (Transferencia transferencia : a) {
			System.err.println("Registro de Cuentas");
			System.out.println("Registro1 " +transferencia.getCuentaOrigen());
			System.out.println("Registro2 " +transferencia.getCuentaDestino());
			
			//Reporte que tenga registro ctaO ctaD Fecha 
			System.err.println("Transferencia");
			System.out.println("Registro1 " +"CtaOrigen: "
					+ "\n"+transferencia.getCuentaOrigen()+" "
							+ "\nCtaDesti: "+transferencia.getCuentaDestino()+""
									+ "\n fecha: "+transferencia.getFecha()   );
		}

		
		
		
		
		
		
	}
}
