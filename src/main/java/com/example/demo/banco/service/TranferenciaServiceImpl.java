package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.TransfereenciaRepository;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service

public class TranferenciaServiceImpl implements TranferenciaService {
	
	@Autowired
	private TransfereenciaRepository transferenciaRepository;
	
	
	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		
		this.transferenciaRepository.insertar(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		
		this.transferenciaRepository.actualizar(transferencia);
		
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.eliminar(numero);
	}

	@Override
	public Transferencia buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.seleccionarPorNumero(numero);
	}

}
