package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController{

	@Override
	public Stack<String> empilhaBrasileiros(String path, String name) throws IOException {

		Stack<String> pilha = new Stack<String>(); 
		
		File arq = new File(path, name);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
					if (linha.contains("Brazil")){
						pilha.push(linha);
				}
					linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		
	}else {
		throw new IOException("Inválido");
	}
		return pilha;
	}

	@Override
	public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		
		int sizePilha = pilha.size();
		
		System.out.println("Nome\tOverall");
		
		for (int i = 0; i < sizePilha; i++){
			String separa = pilha.pop();
			String separaTxt[] = separa.split(",");
			int overall = Integer.parseInt(separaTxt[7]);
			
			if (overall > 80){
				System.out.println(separaTxt[2] + "\t" + separaTxt[7]);
			}
			
		}
				
	}

	@Override
	public List<String> listaRevelacoes(String path, String name) throws IOException {
		
		File arq = new File(path, name);
		List<String> lista = new LinkedList<String>();
			
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			
			while(linha != null) {
				String separaTxt[] = linha.split(",");
				int idade = Integer.parseInt(separaTxt[3]);
				if (idade <= 20) {
					lista.add(linha);
				}
				linha = buffer.readLine();
							
			}
			
			fluxo.close();
			leitor.close();
			buffer.close();			
			
		}
				
		return lista;
	}

	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		
		int sizeLista = lista.size();
		
		System.out.println("Nome\tIdade\tOverall");
		for(int i = sizeLista - 1; i >= 0; i--){
			String separa = lista.get(i);
			String[] separaTxt = separa.split(",");
			int overall = Integer.parseInt(separaTxt[7]);
			
			if (overall > 80) {
				System.out.println(separaTxt[2] + "\t" + separaTxt[3] + "\t" + separaTxt[7]);
			
			}			
		}			
	}	
}
