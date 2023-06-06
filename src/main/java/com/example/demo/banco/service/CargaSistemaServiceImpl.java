package com.example.demo.banco.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.ImpuestoRepo;
import com.example.demo.banco.repository.modelo.Impuesto;

@Service
public class CargaSistemaServiceImpl implements CargaSistemaService {

	@Autowired
	private Impuesto impuesto;
	
	@Autowired
	private ImpuestoRepo impuestoRepo;

	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		
		System.out.println("Inicia carga de impuesto");
		BigDecimal valorIva = this.impuestoRepo.seleccionar("IVA");
		this.impuesto.setIva(valorIva);
		System.out.println("Fin carga de impuesto");

		
	}

}
