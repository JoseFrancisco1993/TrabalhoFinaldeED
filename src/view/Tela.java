package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoProposta;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Tela extends JFrame {

	
	private static final long serialVersionUID = -8533024649811972087L;
	private JPanel contentPane;
	private JTextField tfAlunoTema;
	private JTextField tfAlunoTipo;
	private JTextField tfAlunoIntegrantes;
	private JTextField tfAlunoOrientador;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Tela() {
		setTitle("Proposta de TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 604, 419);
		contentPane.add(tabbedPane);
		
		JPanel tabAluno = new JPanel();
		tabbedPane.addTab("Aluno", null, tabAluno, "Cadastro da Proposta de TCC");
		tabAluno.setLayout(null);
		
		JLabel lblTema = new JLabel("Tema:");
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTema.setBounds(10, 24, 80, 25);
		tabAluno.add(lblTema);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(10, 60, 80, 25);
		tabAluno.add(lblTipo);
		
		JLabel lblIntegrantes = new JLabel("Integrantes:  ");
		lblIntegrantes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIntegrantes.setBounds(10, 103, 96, 25);
		tabAluno.add(lblIntegrantes);
		
		JLabel lblOrientador = new JLabel("Orientador:");
		lblOrientador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrientador.setBounds(10, 152, 96, 20);
		tabAluno.add(lblOrientador);
		
		JLabel lblResumo = new JLabel("Resumo:");
		lblResumo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResumo.setBounds(10, 193, 80, 25);
		tabAluno.add(lblResumo);
		
		tfAlunoTema = new JTextField();
		tfAlunoTema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfAlunoTema.setBounds(59, 24, 500, 24);
		tabAluno.add(tfAlunoTema);
		tfAlunoTema.setColumns(10);
		
		tfAlunoTipo = new JTextField();
		tfAlunoTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfAlunoTipo.setBounds(51, 60, 508, 25);
		tabAluno.add(tfAlunoTipo);
		tfAlunoTipo.setColumns(10);
		
		tfAlunoIntegrantes = new JTextField();
		tfAlunoIntegrantes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfAlunoIntegrantes.setBounds(100, 102, 459, 25);
		tabAluno.add(tfAlunoIntegrantes);
		tfAlunoIntegrantes.setColumns(10);
		
		tfAlunoOrientador = new JTextField();
		tfAlunoOrientador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfAlunoOrientador.setBounds(94, 152, 465, 25);
		tabAluno.add(tfAlunoOrientador);
		tfAlunoOrientador.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnviar.setBounds(238, 323, 108, 42);
		tabAluno.add(btnEnviar);
		
		JTextArea taResumo = new JTextArea();
		taResumo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		taResumo.setBounds(10, 213, 551, 94);
		tabAluno.add(taResumo);
		
	AlunoProposta prop = new AlunoProposta(tfAlunoTema, tfAlunoTipo, tfAlunoIntegrantes, tfAlunoOrientador, null, taResumo);
	
	btnEnviar.addActionListener(prop);
	}
}
