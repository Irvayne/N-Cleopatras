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
				principal.imprimeTabuleiro();
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

		Principal principal = new Principal(n);

		Random gerador = new Random();

		principal.tabuleiro[gerador.nextInt(n)][gerador.nextInt(n)] = 1;

		principal.imprimeTabuleiro();

		System.out.println();

		Node raiz = new Node(principal.tabuleiro, n);

		BuscaProfundidade buscaProfundidade = new BuscaProfundidade(raiz);

		System.out.println(buscaProfundidade.realizaBusca());
	}

}
