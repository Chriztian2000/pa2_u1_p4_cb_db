package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransfereenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service

public class TranferenciaServiceImpl implements TranferenciaService {

	@Autowired
	private CuentaRepository cuentaRepository;

	@Autowired
	private TransfereenciaRepository transferenciaRepository;

	@Override
	public void guardar(Transferencia transferencia) {
		this.transferenciaRepository.insertar(transferencia);

	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.transferenciaRepository.actualizar(transferencia);

	}

	@Override
	public void borrar(String numero) {
		this.transferenciaRepository.eliminar(numero);
	}

	@Override
	public Transferencia buscarPorNumero(String numero) {
		return this.transferenciaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		/// System.err.println();

		// 1. consultar la cuenta de origen por el numero de cuenta

		Cuenta ctaOrigen = this.cuentaRepository.seleccionar(numeroCtaOrigen);
		

		// 2. consultar el saldo de la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();

		// 3. validar si el saldo es suficiente
		if (monto.compareTo(saldoOrigen) <= 0) {

			// 5. si si es suficiente ir al paso 6
			// 6. realizar la resta del saldo origen menos monto
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto) ;
			
			// 7. actualizamos el nuevo saldo de la cuenta origen
			
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepository.actualizar(ctaOrigen);
			
			// 8. consultamos la cuenta de destino por el numero
			Cuenta ctaDestino = this.cuentaRepository.seleccionar(numeroCtaDestino);
			
			// 9. consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
						
			// 10. realizamos la suma del saldo destino mas monto
			BigDecimal nuevoSaldoDestino =saldoDestino.add(monto);
			// para la multiplicacion existe multipli , y division divide
			
			// 11. actualizamos el nuevo saldo de la cuenta destino
			ctaDestino.setSaldo(nuevoSaldoDestino); 
			this.cuentaRepository.actualizar(ctaDestino);
			
			// 12. creamos la transferencia
			Transferencia transfer=new Transferencia();
			transfer.setCuentaOrigen(ctaOrigen);
			transfer.setCuentaDestino(ctaDestino);
			transfer.setMonto(monto);
			Double numero=Math.random();
			transfer.setNumero(numero.toString());
			transfer.setFecha(LocalDateTime.now());
			this.transferenciaRepository.insertar(transfer);
			

		} else {

			// 4. si no es suficiente imprimir mensaje de no hay saldo

			System.err.println("SALDO NO DISPONIBLE, SU SALDO ES " + saldoOrigen);

		}

	}

}
