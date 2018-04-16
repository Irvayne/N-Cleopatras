package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Tela {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 199, 233);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProblemaDasNrainhas = new JLabel("Problema das N-Rainhas");
		lblProblemaDasNrainhas.setBackground(Color.WHITE);
		lblProblemaDasNrainhas.setBounds(12, 0, 467, 25);
		frame.getContentPane().add(lblProblemaDasNrainhas);
		
		JLabel lblQuantidadeDeRainhas = new JLabel("Quantidade de rainhas:");
		lblQuantidadeDeRainhas.setBounds(12, 63, 216, 15);
		frame.getContentPane().add(lblQuantidadeDeRainhas);
		
		SpinnerModel modeltau = new SpinnerNumberModel(1, 1, 10, 1);
		JSpinner spinner = new JSpinner(modeltau);
		spinner.setBounds(54, 102, 42, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnPrximo = new JButton("Próximo >");
		btnPrximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tabuleiro tabuleiro = new Tabuleiro((int) spinner.getValue());
				frame.setVisible(false);
			}
		});
		btnPrximo.setBounds(42, 177, 117, 25);
		frame.getContentPane().add(btnPrximo);
	}
}
