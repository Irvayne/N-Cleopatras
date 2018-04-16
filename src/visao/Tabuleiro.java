package visao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tabuleiro {

	private JFrame frame;
	private int qntN = 5;
	private JButton[][] btosTab; 
	JPanel panelTab;

	public Tabuleiro(int qntN) {
		this.qntN = qntN;
		btosTab = new JButton[qntN][qntN];
		initialize();
		confPanelTab();
		frame.setVisible(true);
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 private void confPanelTab(){
	        panelTab = new JPanel(); // crio o JPanel que servira de tabuleiro; 
	        criaBtosTab();
	        frame.getContentPane().add(panelTab); // adiciono ele na janela;
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

}
