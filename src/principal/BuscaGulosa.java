package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.lang.model.element.QualifiedNameable;

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
		while (!estados.isEmpty()) {
			Node node = buscaHeuristica();
			estados.remove(node);
			Principal principal = new Principal(node.n, node.tabuleiro);

			if (principal.quantidadeRainhas() == node.n) {
//				principal.imprimeTabuleiro();
				return quantidadeNosExoandidos;
			}

			if (principal.quantidadeDisponivel() > 0) {
				node.gerarFilhos();
				estados.addAll(node.filhos);
				quantidadeNosExoandidos += node.filhos.size();
			}

		}
		return quantidadeNosExoandidos;
	}

	private Node buscaHeuristica() {
		Node retorno = null;
		int maior = Integer.MIN_VALUE;

		for (Node node : estados) {
			Principal principal = new Principal(node.n, node.tabuleiro);

			if (principal.quantidadeRainhas() == node.n) {
				return node;
			}

			if (principal.quantidadeDisponivel() == 0) {
				continue;
			}

			int valor = principal.quantidadeDisponivel() + 8 * principal.quantidadeRainhas();

			if (valor > maior) {
				retorno = node;
				maior = valor;
			}
		}
		return retorno;
	}

	public static void main(String[] args) {
		System.out.println("Guloso");

		int n = 8;

		Random gerador = new Random();

		// principal.tabuleiro[gerador.nextInt(n)][gerador.nextInt(n)] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Primeira rainha na posicao " + i + " " + j);
				Principal principal = new Principal(n);
				principal.tabuleiro[i][j] = 1;
//				principal.imprimeTabuleiro();


				Node raiz = new Node(principal.tabuleiro, n);

				BuscaGulosa busca = new BuscaGulosa(raiz);

				System.out.println(busca.realizaBusca());
			}
		}

	}
}
