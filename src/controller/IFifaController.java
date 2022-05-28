package controller;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public interface IFifaController {

	public Stack<String> empilhaBrasileiros(String path, String name) throws IOException;
	public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException;
	public List<String> listaRevelacoes(String path, String name) throws IOException;
	public void buscaListaBonsJovens(List<String> lista) throws IOException;

}
