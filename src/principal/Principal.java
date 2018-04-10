package principal;

public class Principal {

	int n;
	int[][] tabuleiro;
	
	public Principal(int n) {
		this.n = n;
		tabuleiro = new int[n][n];
		this.inicializaTabuleiro();
	}
	
	public Principal(int n, int[][] tabuleiro) {
		this.n = n;
		this.tabuleiro = tabuleiro;
	}

	private void inicializaTabuleiro() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				tabuleiro[i][j] = 0;
	}
	
	public int quantidadeDisponivel() {
		int quantidade = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) 
				if(verificaPosicaoValida(i, j))
					quantidade ++;
		return quantidade;
		
	}
	
	public int quantidadeRainhas() {
		int quantidade = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) 
				if(tabuleiro[i][j] == 1)
					quantidade ++;
		return quantidade;
		
	}
	
	public void imprimeTabuleiro() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) { 
				if(verificaPosicaoValida(i, j)) {
					System.out.print(tabuleiro[i][j]+"  ");
				}else {
					System.out.print(tabuleiro[i][j]+"* ");
			}}
			System.out.println();
		}
	}

	public boolean verificaPosicaoValida(int linha, int coluna) {
		boolean retorno = true;
		
		//verifica na posicao
		if(tabuleiro[linha][coluna] != 0)
			retorno = false;

		for(int i = 0; i < n; i++) {
			//verifica linha
			if(i != linha && tabuleiro[i][coluna] != 0)
				retorno = false;
			//verifica coluna
			if(i != coluna && tabuleiro[linha][i] != 0)
				retorno = false;
		}

		//diagonal principal superior
		int l = linha;
		int c = coluna;
		while(l < n-1 && c < n-1) {
			l++;c++;
			if(tabuleiro[l][c] != 0)
				retorno = false;
		}

		//diagonal principal inferior
		l = linha;
		c = coluna;
		while(l > 0 && c > 0) {
			l--;c--;
			if(tabuleiro[l][c] != 0)
				retorno = false;
		}

		//diagonal secundaria superior
		l = linha;
		c = coluna;
		while(l < n-1 && c > 0) {
			l++;c--;
			if(tabuleiro[l][c] != 0)
				retorno = false;
		}

		//diagonal secundaria inferior
		l = linha;
		c = coluna;
		while(l > 0 && c < n-1) {
			l--;c++;
			if(tabuleiro[l][c] != 0)
				retorno = false;
		}
		
		
		return retorno;

	}

}
