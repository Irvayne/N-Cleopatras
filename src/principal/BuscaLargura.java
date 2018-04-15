package principal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BuscaLargura {

	Node raiz;
	Queue<Node> fila;

	public BuscaLargura(Node raiz) {
		this.raiz = raiz;
		fila = new LinkedList<>();
		fila.add(raiz);
	}

	public int realizaBusca() {
		int quantidadeNosExoandidos = 1;
		while(!fila.isEmpty()) {
			Node node = fila.poll();
			Principal principal = new Principal(node.n, node.tabuleiro);
			if(principal.quantidadeRainhas() == node.n) {
				//principal.imprimeTabuleiro();
				return quantidadeNosExoandidos;
			}
			if(principal.quantidadeDisponivel() > 0) {
				node.gerarFilhos();
				fila.addAll(node.filhos);
				quantidadeNosExoandidos +=  node.filhos.size();
			}
		}
		return quantidadeNosExoandidos;
	}

	public static void main(String[] args) {
		System.out.println("Largura");
		
		int n = 8;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Primeira rainha na posicao " + i + " " + j);
				Principal principal = new Principal(n);
				principal.tabuleiro[i][j] = 1;
//				principal.imprimeTabuleiro();


				Node raiz = new Node(principal.tabuleiro, n);

				BuscaLargura busca = new BuscaLargura(raiz);

				System.out.println(busca.realizaBusca());
			}
		}
	}



}
