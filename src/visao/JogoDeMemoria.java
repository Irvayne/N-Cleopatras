package visao;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JogoDeMemoria  extends JFrame{
	int n = 5;
    private JButton[][] btosTab = new JButton[n][n]; //no caso de um tabuleiro de 5 por 5
    JPanel panelTab;
    JogoDeMemoria(){
        super("Jogo da Memoria");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setSize(1000,500); 
        confPanelTab();
        this.setVisible(true);
    }
    private void confPanelTab(){
        panelTab = new JPanel(new GridLayout(n,n)); // crio o JPanel que servira de tabuleiro; 
        criaBtosTab();
        this.add(panelTab); // adiciono ele na janela;
    }
    private void criaBtosTab(){
        for(int i=0; i<btosTab.length; i++){ // loop que percorre as linhas do tabuleiro
            for(int j=0;j<btosTab[i].length; j++){ //loop que percorre as colunas do tabuleiro
                btosTab[i][j] = new JButton("img da linha "+(i+1)+", coluna "+(j+1));
                int n = i;
                int m = j;
                btosTab[i][j].addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent arg0) {
        				System.out.println("irvsa"+n);
        				btosTab[n][m].setText("Cliquei");
        			}
        		});
                
                panelTab.add(btosTab[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        new JogoDeMemoria();
    }
}

