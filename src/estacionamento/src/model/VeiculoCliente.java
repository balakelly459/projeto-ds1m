package estacionamento.src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class VeiculoCliente {
	
	private String codigo;
	private String placa;
	private String modelo;
	private String dataEntrada;
	private String horaEntrada;
	private String dataSaida;
	private String horaSaida;
	private String tempo;
	private double valorPagar;
	
	private long tempoGasto;

	public long getTempoGasto() {
		LocalDateTime dataHoraEntrada = 
				LocalDateTime.parse(
						this.dataEntrada + " " + horaEntrada,
						DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		LocalDateTime dataHoraSaida = LocalDateTime.parse(
				this.dataSaida + " " + horaSaida,
				DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		long tempoGasto = ChronoUnit.MINUTES.between(dataHoraEntrada, dataHoraSaida);
		
		this.tempoGasto = tempoGasto;
		
		return tempoGasto;	
	}

	public void setTempoGasto(long tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}

	@Override
	public String toString() {
		return codigo + ";" + placa + ";" + modelo + ";" + dataEntrada + ";" + horaEntrada + ";" + dataSaida + ";"
				+ horaSaida + ";" + tempoGasto + ";" + valorPagar;
	}

	public boolean next() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void setRowFilter(Object object) {
		// TODO Auto-generated method stub

	}

}


