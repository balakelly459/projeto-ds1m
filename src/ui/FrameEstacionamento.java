package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDao;
import estacionamento.src.model.VeiculoCliente;
import util.Util;

public class FrameEstacionamento {

	Font titulo = new Font("Arial", Font.BOLD, 25);
	Color um = new Color(126, 185, 88);
	Color dois = new Color(69, 152, 241);
	Color tres = new Color(270, 14, 5);

	private JLabel labelEntrada;
	private JLabel labelPlaca;
	private JTextField textPlaca;
	private JLabel labelModelo;
	private JTextField textModelo;
	private JButton buttonEntrar;

	private JTable tabelaClientes;
	private DefaultTableModel tabelaClientesModelo;
	private JScrollPane scrollTable;

	private JLabel labelSaida;
	private JLabel labelPlaca2;
	private JTextField textPlaca2;
	private JButton buttonBuscar;

	private JLabel labelModelo2;
	private JTextField textModelo2;
	private JLabel labelDataEntrada;
	private JTextField textDataEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelDataSaida;
	private JTextField textDataSaida;
	private JLabel labelHoraSaida;
	private JTextField textHoraSaida;
	private JLabel labelTempo;
	private JTextField textTempo;

	private JLabel labelValorPagar;
	private JTextField textValorPagar;
	private JButton buttonEfetuarSaida;
	private JButton buttonFecharSistema;

	public void criarTela() {
		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Estacionamento");
		tela.setSize(705, 555);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);

		labelEntrada = new JLabel("Entrada");
		labelEntrada.setBounds(20, 20, 130, 30);
		labelEntrada.setFont(titulo);
		labelEntrada.setForeground(um);

		labelPlaca = new JLabel("Placa:");
		labelPlaca.setBounds(20, 50, 130, 30);

		textPlaca = new JTextField();
		textPlaca.setBounds(20, 80, 200, 30);

		labelModelo = new JLabel("Modelo:");
		labelModelo.setBounds(250, 50, 130, 30);

		textModelo = new JTextField();
		textModelo.setBounds(250, 80, 200, 30);

		buttonEntrar = new JButton("Entrar");
		buttonEntrar.setBounds(530, 80, 100, 30);
		buttonEntrar.setForeground(Color.WHITE);
		buttonEntrar.setBackground(dois);

		criarTabela();

		scrollTable = new JScrollPane(tabelaClientes);
		scrollTable.setBounds(20, 110, 650, 160);

		labelSaida = new JLabel("Saída");
		labelSaida.setBounds(20, 270, 130, 30);
		labelSaida.setFont(titulo);
		labelSaida.setForeground(um);

		labelPlaca2 = new JLabel("Placa:");
		labelPlaca2.setBounds(20, 300, 130, 30);

		textPlaca2 = new JTextField();
		textPlaca2.setBounds(20, 330, 200, 30);

		buttonBuscar = new JButton("Buscar");
		buttonBuscar.setBounds(270, 330, 130, 30);
		buttonBuscar.setBackground(dois);
		buttonBuscar.setForeground(Color.WHITE);

		labelModelo2 = new JLabel("Modelo: ");
		labelModelo2.setBounds(20, 360, 130, 30);

		textModelo2 = new JTextField();
		textModelo2.setBounds(20, 390, 100, 30);

		labelDataEntrada = new JLabel("Data de Entrada:");
		labelDataEntrada.setBounds(130, 360, 130, 30);

		textDataEntrada = new JTextField();
		textDataEntrada.setBounds(130, 390, 100, 30);

		labelHoraEntrada = new JLabel("Hora de Entrada:");
		labelHoraEntrada.setBounds(240, 360, 130, 30);

		textHoraEntrada = new JTextField();
		textHoraEntrada.setBounds(240, 390, 100, 30);

		labelDataSaida = new JLabel("Data de Saída:");
		labelDataSaida.setBounds(350, 360, 130, 30);

		textDataSaida = new JTextField();
		textDataSaida.setBounds(350, 390, 100, 30);

		labelHoraSaida = new JLabel("Hora de Saída: ");
		labelHoraSaida.setBounds(460, 360, 130, 30);

		textHoraSaida = new JTextField();
		textHoraSaida.setBounds(460, 390, 100, 30);

		labelTempo = new JLabel("Tempo:");
		labelTempo.setBounds(570, 360, 130, 30);

		textTempo = new JTextField();
		textTempo.setBounds(570, 390, 100, 30);

		labelValorPagar = new JLabel("Valor a Pagar:");
		labelValorPagar.setBounds(20, 450, 130, 30);

		textValorPagar = new JTextField();
		textValorPagar.setBounds(130, 450, 130, 30);

		buttonEfetuarSaida = new JButton("Efetuar Saída");
		buttonEfetuarSaida.setBounds(320, 450, 130, 30);
		buttonEfetuarSaida.setBackground(dois);
		buttonEfetuarSaida.setForeground(Color.WHITE);

		buttonFecharSistema = new JButton("Fechar Sistema");
		buttonFecharSistema.setBounds(460, 450, 130, 30);
		buttonFecharSistema.setBackground(tres);
		buttonFecharSistema.setForeground(Color.WHITE);

		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(labelPlaca);
		tela.getContentPane().add(textPlaca);
		tela.getContentPane().add(labelModelo);
		tela.getContentPane().add(textModelo);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelPlaca2);
		tela.getContentPane().add(textPlaca2);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(labelModelo2);
		tela.getContentPane().add(textModelo2);
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textDataEntrada);
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textHoraEntrada);
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textDataSaida);
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textHoraSaida);
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textTempo);
		tela.getContentPane().add(labelValorPagar);
		tela.getContentPane().add(textValorPagar);
		tela.getContentPane().add(buttonEfetuarSaida);
		tela.getContentPane().add(buttonFecharSistema);
		tela.getContentPane().add(scrollTable);

		tela.setVisible(true);

		buttonEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validarFormulario()) {

					VeiculoCliente cliente = new VeiculoCliente();
					cliente.setCodigo(Util.gerarCodigo());
					cliente.setPlaca(textPlaca.getText().trim().toUpperCase());
					cliente.setModelo(textModelo.getText().toUpperCase());
					cliente.setDataEntrada(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					cliente.setHoraEntrada(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));

					ClienteDao dao = new ClienteDao(cliente);
					dao.salvar();

					JOptionPane.showMessageDialog(null, "Cliente entrou");
					
					limparFormulario();
										
				} 
				else {
					JOptionPane.showMessageDialog(null, "Preencher todos os campos", "erro",
							JOptionPane.WARNING_MESSAGE);
				}

			}

		});
				
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String placa = textPlaca2.getText().toUpperCase();
				
				ClienteDao dao = new ClienteDao();
				VeiculoCliente cliente = dao.buscarClientePlaca(placa);

				textPlaca2.setText(cliente.getPlaca());
				textModelo2.setText(cliente.getModelo());
				textDataEntrada.setText(cliente.getDataEntrada());
				textHoraEntrada.setText(cliente.getHoraEntrada());
				textDataSaida.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				textHoraSaida.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString());
				
				cliente.setDataSaida(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				cliente.setHoraSaida(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString());
				cliente.setTempoGasto(cliente.getTempoGasto());
				
				JOptionPane.showMessageDialog(null, "Tempo: " + cliente.getTempoGasto()/60 + " horas e " + (cliente.getTempoGasto() - (cliente.getTempoGasto()/60)*60) + " minutos", "total", JOptionPane.PLAIN_MESSAGE);
				
				dao.salvar2(cliente);
				

												
			}
		});;

	}

	private void criarTabela() {

		tabelaClientesModelo = new DefaultTableModel();

		tabelaClientesModelo.addColumn("Código");
		tabelaClientesModelo.addColumn("Placa");
		tabelaClientesModelo.addColumn("Modelo");
		tabelaClientesModelo.addColumn("Data de Entrada");

		ClienteDao clienteDao = new ClienteDao();
		ArrayList<VeiculoCliente> clientes = clienteDao.listarClientes();

		for (VeiculoCliente cliente : clientes) {
			String[] vetorCliente = { cliente.getCodigo(), cliente.getPlaca(), cliente.getModelo(),
					cliente.getDataEntrada() };
			tabelaClientesModelo.addRow(vetorCliente);
			
		}

		tabelaClientes = new JTable(tabelaClientesModelo);
		
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(200);

		tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
		tabelaClientes.getColumnModel().getColumn(1).setResizable(false);
		tabelaClientes.getColumnModel().getColumn(2).setResizable(false);
		tabelaClientes.getColumnModel().getColumn(3).setResizable(false);

		tabelaClientes.getTableHeader().setReorderingAllowed(false);
		
	}

	private boolean validarFormulario() {

		boolean valido = true;

		if (textPlaca.getText().trim().length() == 0) {
			labelPlaca.setForeground(Color.RED);
			valido = false;
		} else if (textModelo.getText().trim().length() == 0) {
			labelModelo.setForeground(Color.RED);
			valido = false;
		}

		return valido;

	}

	private void limparFormulario() {

		textPlaca.setText("");
		textModelo.setText("");

	}
	

}

