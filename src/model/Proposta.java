package model;

public class Proposta {
	public String tema;
	public String tipo;
	public String integrantes;
	public String orientador;
	public String resumo;
	
	public String toString() {
		return " Proposta de TCC \n Tema = " +tema+ ",  Tipo = " +tipo + ",  Integrantes = " +integrantes+ ",  Orientador = " +orientador+ ", Resumo = " +resumo;
	//	return tema+";"+tipo+";"+integrantes+";"+orientador+";"+resumo;
	}

	
}
