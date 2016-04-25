package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.kontrolor.GUIKontrolor;
import net.miginfocom.swing.MigLayout;

public class PocetniProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jpnlGameButtons;
	private JButton jbtnNewGame;
	private JButton jbtnInstructions;
	private JButton jbtnExit;
	private JPanel jpnlPlayerButtons;
	private JLabel lblPlayer;
	private JTextField jtxtPlayer;
	private JButton btnOk;
	private JButton btnSeeYourScore;
	private JPanel jpnlSlika;
	private JLabel jlblError;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PocetniProzor() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				GUIKontrolor.ugasiAplikaciju();
			}

		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(PocetniProzor.class.getResource("/resursi/ghosticon.png")));
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getJpnlGameButtons(), BorderLayout.EAST);
		contentPane.add(getJpnlPlayerButtons(), BorderLayout.CENTER);
		contentPane.add(getJpnlSlika(), BorderLayout.SOUTH);
	}

	private JPanel getJpnlGameButtons() {
		if (jpnlGameButtons == null) {
			jpnlGameButtons = new JPanel();
			jpnlGameButtons.setPreferredSize(new Dimension(140, 10));
			jpnlGameButtons.add(getJbtnNewGame());
			jpnlGameButtons.add(getJbtnInstructions());
			jpnlGameButtons.add(getJbtnExit());
		}
		return jpnlGameButtons;
	}
	private JButton getJbtnNewGame() {
		if (jbtnNewGame == null) {
			jbtnNewGame = new JButton("New Game");
			jbtnNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						if(GUIKontrolor.indexTrenutnogIgraca == -1) GUIKontrolor.upozoriDaNijeIzabranIgrac();
						else GUIKontrolor.prikaziGlavniProzor();	
					}
			});
			jbtnNewGame.setPreferredSize(new Dimension(130, 30));
		}
		return jbtnNewGame;
	}
	private JButton getJbtnInstructions() {
		if (jbtnInstructions == null) {
			jbtnInstructions = new JButton("Instructions");
			jbtnInstructions.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					GUIKontrolor.pozoviInstrukcije();
				}
			});
			jbtnInstructions.setPreferredSize(new Dimension(130, 30));
		}
		return jbtnInstructions;
	}
	private JButton getJbtnExit() {
		if (jbtnExit == null) {
			jbtnExit = new JButton("Exit");
			jbtnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontrolor.ugasiAplikaciju();
				}
			});
			
			jbtnExit.setPreferredSize(new Dimension(130, 30));
		}
		return jbtnExit;
	}
	private JPanel getJpnlPlayerButtons() {
		if (jpnlPlayerButtons == null) {
			jpnlPlayerButtons = new JPanel();
			jpnlPlayerButtons.setLayout(new MigLayout("", "[grow]", "[][][][]"));
			jpnlPlayerButtons.add(getLblPlayer(), "cell 0 0,growx");
			jpnlPlayerButtons.add(getJtxtPlayer(), "flowx,cell 0 1,growx");
			jpnlPlayerButtons.add(getBtnOk(), "cell 0 1");
			jpnlPlayerButtons.add(getBtnSeeYourScore(), "cell 0 2,growx");
			jpnlPlayerButtons.add(getJlblError(), "cell 0 3");
		}
		return jpnlPlayerButtons;
	}
	private JLabel getLblPlayer() {
		if (lblPlayer == null) {
			lblPlayer = new JLabel("Player:");
			lblPlayer.setPreferredSize(new Dimension(34, 30));
			lblPlayer.setForeground(Color.BLUE);
			lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblPlayer;
	}
	private JTextField getJtxtPlayer() {
		if (jtxtPlayer == null) {
			jtxtPlayer = new JTextField();
			jtxtPlayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jtxtPlayer.setPreferredSize(new Dimension(6, 30));
			jtxtPlayer.setColumns(10);
		}
		return jtxtPlayer;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String igrac = jtxtPlayer.getText();
					if(igrac.isEmpty())jlblError.setText("You didn't enter any name!");
					else if(GUIKontrolor.incijalizujIgraca(igrac)) jlblError.setText("New player is created!");
					else jlblError.setText("Welcome back " + igrac + "!");
				}
			});
			btnOk.setPreferredSize(new Dimension(50, 30));
		}
		return btnOk;
	}
	private JButton getBtnSeeYourScore() {
		if (btnSeeYourScore == null) {
			btnSeeYourScore = new JButton("See your score!");
			btnSeeYourScore.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(GUIKontrolor.indexTrenutnogIgraca == -1) jlblError.setText("You haven't chosen your player!");
					else GUIKontrolor.prozorZaScore();
				}
			});
			btnSeeYourScore.setForeground(Color.BLUE);
			btnSeeYourScore.setPreferredSize(new Dimension(109, 30));
			btnSeeYourScore.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return btnSeeYourScore;
	}
	private JPanel getJpnlSlika() {
		if (jpnlSlika == null) {
			jpnlSlika = new JPanel();
			jpnlSlika.setPreferredSize(new Dimension(10, 140));
		}
		
		BufferedImage slikaminiona;
		try {
			slikaminiona = ImageIO.read(this.getClass().getResource("/resursi/funminions.jpg"));
			JLabel ikonaminiona = new JLabel(new ImageIcon(slikaminiona));
			jpnlSlika.add(ikonaminiona);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jpnlSlika;
	}
	private JLabel getJlblError() {
		if (jlblError == null) {
			jlblError = new JLabel("");
			jlblError.setForeground(Color.RED);
			jlblError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return jlblError;
	}
}
