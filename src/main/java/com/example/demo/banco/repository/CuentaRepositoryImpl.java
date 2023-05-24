package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Repository

public class CuentaRepositoryImpl implements CuentaRepository {
	

	private List<Cuenta> baseDatos = new ArrayList<>();

	@Override
	public void insertar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		baseDatos.add(cuenta);
		
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.eliminar(cuenta.getNumero());
		this.insertar(cuenta);
		
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Cuenta cuenta = this.seleccionar(numero);
		baseDatos.remove(cuenta);
		
	}

	@Override
	public Cuenta seleccionar(String numero) {
		Cuenta cuentaEcnontrada = new Cuenta();
		for (Cuenta cuenta : baseDatos) {
			if (numero.equals(cuenta.getNumero())) {
				cuentaEcnontrada = cuenta;
			}
		}
		return cuentaEcnontrada;
	}

	
	
}
