package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import estacionamento.src.model.VeiculoCliente;


public class ClienteDao {

	private VeiculoCliente cliente;

	private static final String LOCAL_ARQUIVO = "C:/Users/21192911/movimentacao.ds1";

	public VeiculoCliente getCliente() {
		return cliente;
	}

	public ClienteDao(VeiculoCliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDao() {

	}
	
	public void salvar() {
		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"), StandardOpenOption.WRITE,
					StandardOpenOption.APPEND);

			writer.write(cliente.toString());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			System.out.println("Ocorreu um erro(");
			e.printStackTrace();
		}
	}
	
	public void salvar2(VeiculoCliente cliente) {
		Path path = Paths.get(LOCAL_ARQUIVO);
		
		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"), StandardOpenOption.WRITE,
					StandardOpenOption.APPEND);
			
			
			writer.newLine();
			writer.write(cliente.toString());
			writer.close();

		} catch (Exception e) {
			System.out.println("Ocorreu um erro(");
			e.printStackTrace();
		}
	}
	
	public ArrayList<VeiculoCliente> listarClientes() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			ArrayList<VeiculoCliente> clientes = new ArrayList<>();

			while (linha != null) {
				String[] vetorCliente = linha.split(";");

				VeiculoCliente cliente = new VeiculoCliente();
				cliente.setCodigo(vetorCliente[0]);
				cliente.setPlaca(vetorCliente[1]);
				cliente.setModelo(vetorCliente[2]);
				cliente.setDataEntrada(vetorCliente[3]);
				cliente.setHoraEntrada(vetorCliente[4]);
				cliente.setDataSaida(vetorCliente[5]);
				cliente.setHoraSaida(vetorCliente[6]);


				clientes.add(cliente);

				linha = reader.readLine();
			}


			reader.close();

			return clientes;

		}

		catch (Exception e) {
			System.out.println("Ocorreu um erro(");
			e.printStackTrace();
			return null;
		}
	}
	public VeiculoCliente buscarCliente(String codigo) {

		
		Path path = Paths.get(LOCAL_ARQUIVO);

	
		try {

			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			VeiculoCliente cliente = new VeiculoCliente();

			while (linha != null) {
				String[] vetorCliente = linha.split(";");

				if (vetorCliente[0].equals(codigo)) {
					cliente.setCodigo(vetorCliente[0]);
					cliente.setPlaca(vetorCliente[1]);
					cliente.setModelo(vetorCliente[2]);
					cliente.setDataEntrada(vetorCliente[3]);
					cliente.setHoraEntrada(vetorCliente[4]);
					cliente.setDataSaida(vetorCliente[5]);
					cliente.setHoraSaida(vetorCliente[6]);

					break;
				}
				linha = reader.readLine();
			}

			reader.close();

			return cliente;

		}

		catch (Exception e) {
			System.out.println("Ocorreu um erro(");
			e.printStackTrace();
			return null;
		}
	}
	
	public VeiculoCliente buscarClientePlaca(String placa) {

		
		Path path = Paths.get(LOCAL_ARQUIVO);

		
		try {

			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			VeiculoCliente cliente = new VeiculoCliente();

			while (linha != null) {
				String[] vetorCliente = linha.split(";");

				if (vetorCliente[1].equals(placa) && vetorCliente[5].equals("null")) {
					cliente.setCodigo(vetorCliente[0]);
					cliente.setPlaca(vetorCliente[1]);
					cliente.setModelo(vetorCliente[2]);
					cliente.setDataEntrada(vetorCliente[3]);
					cliente.setHoraEntrada(vetorCliente[4]);
					cliente.setDataSaida(vetorCliente[5]);
					cliente.setHoraSaida(vetorCliente[6]);

					break;
				}
				linha = reader.readLine();
			}

			reader.close();

			return cliente;

		}

		catch (Exception e) {
			System.out.println("Ocorreu um erro(");
			e.printStackTrace();
			return null;
		}
	}

}

