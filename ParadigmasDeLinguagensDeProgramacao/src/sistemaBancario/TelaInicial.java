package sistemaBancario;

import java.util.Random;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaInicial {

	private JFrame frame;
	private JTextField txtFieldNome;
	private JTextField txtFieldValor;
	private JTable table;
	private JRadioButton rdbtnPessoaFisica;
	private JRadioButton rdbtnPessoaJuridica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/sistemaBancario/iconeApp.png")));
		frame.setBounds(100, 100, 666, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nomeDoAplicativo = new JLabel("VanGuardian Bank");
		nomeDoAplicativo.setBounds(0, 0, 652, 50);
		nomeDoAplicativo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		nomeDoAplicativo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(nomeDoAplicativo);
		
		JLabel iconeDoAplicativo = new JLabel("");
		iconeDoAplicativo.setBounds(0, 0, 50, 50);
		iconeDoAplicativo.setHorizontalAlignment(SwingConstants.CENTER);
		iconeDoAplicativo.setIcon(new ImageIcon(TelaInicial.class.getResource("/sistemaBancario/IconeBanco.png")));
		frame.getContentPane().add(iconeDoAplicativo);
		
		JLabel nomeSaldoAtual = new JLabel("Criar Conta");
		nomeSaldoAtual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomeSaldoAtual.setBounds(553, 111, 78, 32);
		frame.getContentPane().add(nomeSaldoAtual);
		
		JLabel nomeNovaEntrada = new JLabel("Nova Entrada");
		nomeNovaEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomeNovaEntrada.setBounds(553, 71, 99, 32);
		frame.getContentPane().add(nomeNovaEntrada);
		
		JLabel nomeNovaSaida = new JLabel("Nova Saída");
		nomeNovaSaida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomeNovaSaida.setBounds(553, 151, 78, 32);
		frame.getContentPane().add(nomeNovaSaida);
		
		JLabel nomeNome = new JLabel("Nome:");
		nomeNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomeNome.setBounds(43, 71, 78, 30);
		frame.getContentPane().add(nomeNome);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(43, 111, 250, 24);
		frame.getContentPane().add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		JLabel nomeValor = new JLabel("Valor:");
		nomeValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomeValor.setBounds(316, 71, 78, 30);
		frame.getContentPane().add(nomeValor);
		
		txtFieldValor = new JTextField();
		txtFieldValor.setColumns(10);
		txtFieldValor.setBounds(306, 111, 128, 24);
		frame.getContentPane().add(txtFieldValor);
		
		JLabel nomeTipo = new JLabel("Tipo:");
		nomeTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomeTipo.setBounds(43, 148, 78, 30);
		frame.getContentPane().add(nomeTipo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 213, 556, 140);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Agencia", "Conta", "Tipo", "Nome", "Saldo"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaInicial.class.getResource("/sistemaBancario/IconeEntrada.png")));
		btnNewButton.setBounds(513, 71, 32, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Gerando variáveis
				String tipo = "none";
				Conta conta = new Conta();
				Random random = new Random();
				// Definindo nome do portador da nova conta
				String nome = txtFieldNome.getText();
				conta.setNomePortador(nome);
				// Gerando agência e conta
				int numeroAleatorio = random.nextInt(99999);
				String numero = String.valueOf(numeroAleatorio);
				int agenciaAleatoria = random.nextInt(99999);
				String agencia = String.valueOf(agenciaAleatoria);
				// Definindo o tipo da nova conta
				if (rdbtnPessoaFisica.isSelected()) {
					tipo = "PF";
				}
				if (rdbtnPessoaJuridica.isSelected()) {
					tipo = "PJ";
				}
				// Definindo o valor inicial da nova conta
				String valor = txtFieldValor.getText();
				// Adicionando a nova conta na tabela
				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				tabela.addRow(new String[] {agencia, numero, tipo, nome, valor}
				);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/sistemaBancario/IconeSaldo.png")));
		btnNewButton_1.setBounds(513, 111, 32, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/sistemaBancario/IconeSaida.png")));
		btnNewButton_1_1.setBounds(513, 151, 32, 32);
		frame.getContentPane().add(btnNewButton_1_1);
		
		rdbtnPessoaFisica = new JRadioButton("Pessoa Física");
		rdbtnPessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPessoaJuridica.isSelected()) {
					rdbtnPessoaJuridica.setSelected(false);
				}
			}
		});
		rdbtnPessoaFisica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnPessoaFisica.setBounds(148, 156, 145, 21);
		frame.getContentPane().add(rdbtnPessoaFisica);
		
		rdbtnPessoaJuridica = new JRadioButton("Pessoa Jurídica");
		rdbtnPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPessoaFisica.isSelected()) {
					rdbtnPessoaFisica.setSelected(false);
				}
			}
		});
		rdbtnPessoaJuridica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnPessoaJuridica.setBounds(295, 158, 145, 21);
		frame.getContentPane().add(rdbtnPessoaJuridica);
	}
}
