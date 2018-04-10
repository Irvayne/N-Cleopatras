package principal;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	List<Node> filhos;
	int[][] tabuleiro;
	int n;
	boolean visitado;

	public Node(int[][] tabuleiro, int n) {
		filhos = new ArrayList<>();
		this.tabuleiro = tabuleiro;
		this.n = n;
	}
	
	public void imprimeTabuleiro() {
		Principal principal = new Principal(n, tabuleiro);
		principal.imprimeTabuleiro();
	}
	
	public void gerarFilhos() {
		Principal principal = new Principal(n, tabuleiro);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(principal.verificaPosicaoValida(i, j)) {
					int[][] clone = clonarTabuleiro();
					clone[i][j] = 1;
					Node filho = new Node(clone, n);
					filhos.add(filho);
				}
					
			}
		}
		
	}
	
	private int[][] clonarTabuleiro() {
		int[][] clone = new int[n][n];
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < n; j++) 
				clone[i][j] = tabuleiro[i][j];
		return clone;
	}

	public void imprimeFilhos() {
		for (Node node : filhos) {
			Principal principal = new Principal(node.n, node.tabuleiro);
			principal.imprimeTabuleiro();
			System.out.println();
		}
	}
}
