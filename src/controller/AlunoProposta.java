package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.leandrocolevati.Lista.Lista;
import model.Proposta;

public class AlunoProposta implements ActionListener {
	
	private JTextField tfAlunoTema;
	private JTextField tfAlunoTipo;
	private JTextField tfAlunoIntegrantes;
	private JTextField tfAlunoOrientador;
	private JTextField tfAlunoResumo;
	private JTextArea taAlunoResumo;
	
	public AlunoProposta(JTextField tfAlunoTema, JTextField tfAlunoTipo, JTextField tfAlunoIntegrantes,
			JTextField tfAlunoOrientador, JTextField tfAlunoResumo, JTextArea taAlunoResumo) {
		super();
		this.tfAlunoTema = tfAlunoTema;
		this.tfAlunoTipo = tfAlunoTipo;
		this.tfAlunoIntegrantes = tfAlunoIntegrantes;
		this.tfAlunoOrientador = tfAlunoOrientador;
		this.tfAlunoResumo = tfAlunoResumo;
		this.taAlunoResumo = taAlunoResumo;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("ENVIAR")) {
			try {
				enviar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,  "Proposta Enviada com Sucesso!");
		}
		
	}

	private void enviar() throws IOException {
		Proposta proposta = new Proposta();
		
		proposta.tema = tfAlunoTema.getText();
		proposta.tipo = tfAlunoTipo.getText();
		proposta.integrantes = tfAlunoIntegrantes.getText();
		proposta.orientador = tfAlunoOrientador.getText();
		proposta.resumo = taAlunoResumo.getText();
		
		System.out.println(proposta);
		tfAlunoTema.setText("");
		tfAlunoTipo.setText("");
		tfAlunoIntegrantes.setText("");
		tfAlunoOrientador.setText("");
		taAlunoResumo.setText("");
		cadastraProposta(proposta.toString());
		
	}

	private Lista cadastraProposta(String csvProposta) throws IOException {
		var proposta = new Proposta();
		Lista propostas = new Lista();
		String path = System.getProperty("user.home") + File.separator +"Proposta de Aluno";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "proposta.csv");
		boolean existe = false;
		if (arq.exists() && arq.isFile()) {
			existe = true; 
		}
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			
			
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(proposta)) {
					proposta.tema = vetLinha[0];
					proposta.tipo = vetLinha[1];
					proposta.integrantes = vetLinha[2];
					proposta.orientador = vetLinha[3];
					proposta.resumo = vetLinha[4];
					break;
				}
				
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		
			
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvProposta+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
		
		return propostas;
	}

}
