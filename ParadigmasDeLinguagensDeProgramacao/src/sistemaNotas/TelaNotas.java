package sistemaNotas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaNotas {

	private JFrame frame;
	private JTable table;
	private JTextField fieldNotaUm;
	private JTextField fieldNotaDois;
	private JTextField fieldNotaTres;
	private JButton btnNewButton;
	private JTextField fieldName;
	private JRadioButton radioButtonRegular;
	private JRadioButton radioButtonEspecial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNotas window = new TelaNotas();
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
	public TelaNotas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel iconeUsuario = new JLabel("");
		iconeUsuario.setIcon(new ImageIcon(TelaNotas.class.getResource("/sistemaNotas/IconeUsuario.png")));
		iconeUsuario.setBounds(0, 0, 50, 50);
		frame.getContentPane().add(iconeUsuario);
		
		JLabel labelTitulo = new JLabel("Sistema de Notas");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(0, 0, 434, 50);
		frame.getContentPane().add(labelTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 414, 85);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Aluno", "Tipo", "Nota 1", "Nota 2", "Nota 3", "Media"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNome.setBounds(10, 154, 80, 20);
		frame.getContentPane().add(labelNome);
		
		fieldName = new JTextField();
		fieldName.setBounds(10, 179, 213, 20);
		frame.getContentPane().add(fieldName);
		fieldName.setColumns(10);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTipo.setBounds(247, 157, 46, 14);
		frame.getContentPane().add(labelTipo);
		
		radioButtonRegular = new JRadioButton("Regular");
		radioButtonRegular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonRegular.isSelected()) {
					radioButtonEspecial.setSelected(false);
				}
			}
		});
		radioButtonRegular.setBounds(247, 178, 80, 23);
		frame.getContentPane().add(radioButtonRegular);
		
		radioButtonEspecial = new JRadioButton("Especial");
		radioButtonEspecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButtonEspecial.isSelected()) {
					radioButtonRegular.setSelected(false);
				}
			}
		});
		radioButtonEspecial.setBounds(330, 178, 80, 23);
		frame.getContentPane().add(radioButtonEspecial);
		
		JLabel labelNotaUm = new JLabel("N1:");
		labelNotaUm.setHorizontalAlignment(SwingConstants.CENTER);
		labelNotaUm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNotaUm.setBounds(10, 210, 40, 14);
		frame.getContentPane().add(labelNotaUm);
		
		fieldNotaUm = new JTextField();
		fieldNotaUm.setBounds(10, 235, 40, 20);
		frame.getContentPane().add(fieldNotaUm);
		fieldNotaUm.setColumns(10);
		
		JLabel labelNotaDois = new JLabel("N2:");
		labelNotaDois.setHorizontalAlignment(SwingConstants.CENTER);
		labelNotaDois.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNotaDois.setBounds(68, 210, 40, 14);
		frame.getContentPane().add(labelNotaDois);
		
		fieldNotaDois = new JTextField();
		fieldNotaDois.setColumns(10);
		fieldNotaDois.setBounds(68, 235, 40, 20);
		frame.getContentPane().add(fieldNotaDois);
		
		JLabel labelNotaTres = new JLabel("N3:");
		labelNotaTres.setHorizontalAlignment(SwingConstants.CENTER);
		labelNotaTres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNotaTres.setBounds(125, 210, 40, 14);
		frame.getContentPane().add(labelNotaTres);
		
		fieldNotaTres = new JTextField();
		fieldNotaTres.setColumns(10);
		fieldNotaTres.setBounds(125, 235, 40, 20);
		frame.getContentPane().add(fieldNotaTres);
		
		btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Definindo todas as classes
				Aluno aluno = new Aluno();
				Aluno alunoEspecial = new AlunoEspecial();
				Aluno alunoRegular = new AlunoRegular();
				
				// Definindo parâmetro com o nome do aluno
				String nome = fieldName.getText();
				aluno.setNome(nome);
				
				// Calculando a média de acordo com o tipo do aluno
				float media = 0.0f;
				float nota1 = Float.parseFloat(fieldNotaUm.getText());
				float nota2 = Float.parseFloat(fieldNotaDois.getText());
				float nota3 = Float.parseFloat(fieldNotaTres.getText());
				if (radioButtonEspecial.isSelected()) {
					media = alunoEspecial.calcularNota(nota1, nota2, nota3);
					aluno.setTipoAluno("Especial");
				}
				if (radioButtonRegular.isSelected()) {
					media = alunoRegular.calcularNota(nota1, nota2, nota3);
					aluno.setTipoAluno("Regular");
				}
				
				String tipoAluno = aluno.getTipoAluno();
				
				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				tabela.addRow(new String[] {nome, tipoAluno, 
						String.valueOf(nota1), String.valueOf(nota2), String.valueOf(nota3), 
						String.valueOf(media)}
				);
				
			}
		});
		btnNewButton.setBounds(335, 234, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
