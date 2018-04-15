package principal;

import java.util.Random;
import java.util.Stack;

public class BuscaProfundidade {
	
	Node raiz;
	Stack<Node> pilha;
	
	public BuscaProfundidade(Node raiz) {
		this.raiz = raiz;
		pilha = new Stack<Node>();
		pilha.push(raiz);
	}
	
	public int realizaBusca() {
		int quantidadeNosExoandidos = 1;
		while(!pilha.isEmpty()) {
			Node node = pilha.pop();
			Principal principal = new Principal(node.n, node.tabuleiro);
			if(principal.quantidadeRainhas() == node.n) {
				//principal.imprimeTabuleiro();
				return quantidadeNosExoandidos;
			}
			if(principal.quantidadeDisponivel() > 0) {
				node.gerarFilhos();
				pilha.addAll(node.filhos);
				quantidadeNosExoandidos +=  node.filhos.size();
			}
		}
		return quantidadeNosExoandidos;
	}
	
	public static void main(String[] args) {
		System.out.println("Profundidade");
		
		int n = 8;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Primeira rainha na posicao " + i + " " + j);
				Principal principal = new Principal(n);
				principal.tabuleiro[i][j] = 1;
				Node raiz = new Node(principal.tabuleiro, n);
				
				BuscaProfundidade busca = new BuscaProfundidade(raiz);
				
				System.out.println(busca.realizaBusca());
				
				Principal principal2 = new Principal(n);
				principal2.tabuleiro[i][j] = 1;

				Node raiz2 = new Node(principal2.tabuleiro, n);
				
				BuscaGulosa busca2 = new BuscaGulosa(raiz2);
				
				System.out.println(busca2.realizaBusca());

				
//				principal.imprimeTabuleiro();


			}
		}
	}

}
