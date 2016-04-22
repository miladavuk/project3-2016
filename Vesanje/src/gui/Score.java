package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import baza.TabelaZaScore;
import gui.kontrolor.GUIKontrolor;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Score extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel jlblPlayer;
	private JLabel jlblImeIgraca;
	private JTable jtblScore;
	private JButton jbtnOk;


	/**
	 * Create the frame.
	 */
	public Score() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Score.class.getResource("/resursi/ghosticon.png")));
		setTitle("Score");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getJlblPlayer());
		contentPane.add(getJlblImeIgraca());
		contentPane.add(getJtblScore());
		contentPane.add(getJbtnOk());
	}
	private JLabel getJlblPlayer() {
		if (jlblPlayer == null) {
			jlblPlayer = new JLabel("Player:");
			jlblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jlblPlayer.setBounds(44, 18, 65, 23);
		}
		return jlblPlayer;
	}
	private JLabel getJlblImeIgraca() {
		if (jlblImeIgraca == null) {
			jlblImeIgraca = new JLabel(GUIKontrolor.igraci.vratiIgraca(GUIKontrolor.indexTrenutnogIgraca).getIme());
			jlblImeIgraca.setForeground(Color.RED);
			jlblImeIgraca.setFont(new Font("Tahoma", Font.BOLD, 18));
			jlblImeIgraca.setBounds(148, 13, 286, 30);
		}
		return jlblImeIgraca;
	}
	private JTable getJtblScore() {
		if (jtblScore == null) {
			jtblScore = new JTable(new TabelaZaScore(GUIKontrolor.igraci.vratiIgraca(GUIKontrolor.indexTrenutnogIgraca)));
			jtblScore.setBounds(44, 169, 357, -105);
		}
		return jtblScore;
	}
	private JButton getJbtnOk() {
		if (jbtnOk == null) {
			jbtnOk = new JButton("OK");
			jbtnOk.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			jbtnOk.setPreferredSize(new Dimension(30, 30));
			jbtnOk.setBounds(379, 231, 55, 30);
		}
		return jbtnOk;
	}
}
