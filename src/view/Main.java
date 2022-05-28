package view;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import controller.FifaController;
import controller.IFifaController;

public class Main {
	
	public static void main(String[] args) {
		
		IFifaController arqCont = new FifaController();
		Stack<String> pilha = new Stack<String>();
		List<String> lista = new LinkedList<String>();
		
		String path = "C:\\Temp";
		String name = "data.csv";
	
		try {
//			pilha = arqCont.empilhaBrasileiros(path, name);
//			arqCont.desmpilhaBonsBrasileiros(pilha);
			lista = arqCont.listaRevelacoes(path, name);
			arqCont.buscaListaBonsJovens(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
