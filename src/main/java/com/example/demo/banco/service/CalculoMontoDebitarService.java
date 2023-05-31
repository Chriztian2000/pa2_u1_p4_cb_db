package com.example.demo.banco.service;

import java.math.BigDecimal;

public interface CalculoMontoDebitarService {

	// Lo unico que debo crear es la parte que va a ser distitnta
	// Crear en una sola interfaz y en las clases que lo implementan
	public BigDecimal calcular(BigDecimal monto);

}
