package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuscaGulosa {
	
	Node raiz;
	List<Node> estados;

	public BuscaGulosa(Node raiz) {
		this.raiz = raiz;
		estados = new ArrayList<>();
		estados.add(raiz);
	}
	
	public int realizaBusca() {
		int quantidadeNosExoandidos = 1;
		while(!estados.isEmpty()) {
			Node node = buscaHeuristica();
			estados.remove(node);
			Principal principal = new Principal(node.n, node.tabuleiro);
			
			if(principal.quantidadeRainhas() == node.n) {
				principal.imprimeTabuleiro();
				return quantidadeNosExoandidos;
			}
			
			if(principal.quantidadeDisponivel() > 0) {
				node.gerarFilhos();
				estados.addAll(node.filhos);
				quantidadeNosExoandidos +=  node.filhos.size();
			}
			
		}
		return quantidadeNosExoandidos;
	}
	
	private Node buscaHeuristica() {
		Node retorno = null;
		int maior = Integer.MIN_VALUE;
		
		for (Node node : estados) {
			Principal principal = new Principal(node.n, node.tabuleiro);
			
			if(principal.quantidadeRainhas() == node.n) {
				return node;
			}
			
			if(principal.quantidadeDisponivel() == 0) {
				continue;
			}
			
			int valor = principal.quantidadeRainhas()/principal.quantidadeDisponivel();
			if(valor > maior) {
				retorno = node;
				valor = maior;
			}
		}
		
		return retorno;
	}
	
	public static void main(String[] args) {
		System.out.println("Guloso");
		
		int n = 8;

		Principal principal = new Principal(n);

		Random gerador = new Random();

		principal.tabuleiro[gerador.nextInt(n)][gerador.nextInt(n)] = 1;

		principal.imprimeTabuleiro();

		System.out.println();

		Node raiz = new Node(principal.tabuleiro, n);

		BuscaGulosa busca = new BuscaGulosa(raiz);

		System.out.println(busca.realizaBusca());
	}
}
