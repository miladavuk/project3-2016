package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel panelZaRec;
	private JPanel panelZaDugmice;
	private JPanel panelZaSliku;
	private JLabel lblKategorija;
	private JComboBox comboBoxKategorije;
	private JLabel lblIzaberiSlovo;
	private JComboBox comboBoxSlova;
	private JLabel lblTryTheWhole;
	private JTextField textField;
	private JLabel lblPrazanProstor1;
	private JLabel lblPrazanProstor2;
	private JLabel lblPrazanProstor3;
	private JButton btnExitGame;
	private JLabel lblPrazanProstor4;

	
	public GlavniProzor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/resursi/ghosticon.png")));
		setResizable(false);
		setPreferredSize(new Dimension(1000, 2000));
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelZaRec(), BorderLayout.SOUTH);
		contentPane.add(getPanelZaDugmice(), BorderLayout.EAST);
		contentPane.add(getPanelZaSliku(), BorderLayout.CENTER);
	}

	private JPanel getPanelZaRec() {
		if (panelZaRec == null) {
			panelZaRec = new JPanel();
			panelZaRec.setPreferredSize(new Dimension(10, 50));
		}
		return panelZaRec;
	}
	private JPanel getPanelZaDugmice() {
		if (panelZaDugmice == null) {
			panelZaDugmice = new JPanel();
			panelZaDugmice.setPreferredSize(new Dimension(200, 10));
			panelZaDugmice.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelZaDugmice.add(getLblPrazanProstor1());
			panelZaDugmice.add(getLblKategorija());
			panelZaDugmice.add(getComboBoxKategorije());
			panelZaDugmice.add(getLblPrazanProstor2());
			panelZaDugmice.add(getLblIzaberiSlovo());
			panelZaDugmice.add(getComboBoxSlova());
			panelZaDugmice.add(getLabel_1());
			panelZaDugmice.add(getLblTryTheWhole());
			panelZaDugmice.add(getTextField());
			panelZaDugmice.add(getLabel_2());
			panelZaDugmice.add(getBtnExitGame());
		}
		return panelZaDugmice;
	}
	private JPanel getPanelZaSliku() {
		if (panelZaSliku == null) 
			panelZaSliku = new JPanel();		
		
		BufferedImage slika;
		try {
			slika = ImageIO.read(this.getClass().getResource("/resursi/vesala1.jpg"));
			JLabel ikona = new JLabel(new ImageIcon(slika));
			panelZaSliku.add(ikona);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return panelZaSliku;
	}
	private JLabel getLblKategorija() {
		if (lblKategorija == null) {
			lblKategorija = new JLabel("Category:");
			lblKategorija.setHorizontalAlignment(SwingConstants.CENTER);
			lblKategorija.setPreferredSize(new Dimension(70, 25));
		}
		return lblKategorija;
	}
	private JComboBox getComboBoxKategorije() {
		if (comboBoxKategorije == null) {
			comboBoxKategorije = new JComboBox();
			comboBoxKategorije.setPreferredSize(new Dimension(100, 25));
			comboBoxKategorije.addItem("Movies");
			comboBoxKategorije.addItem("Countries");
			comboBoxKategorije.addItem("Classical books");
			comboBoxKategorije.addItem("Hystoric people");
			comboBoxKategorije.addItem("Famous people");
			comboBoxKategorije.addItem("Famous brands");	
		}
			
		return comboBoxKategorije;
	}
	private JLabel getLblIzaberiSlovo() {
		if (lblIzaberiSlovo == null) {
			lblIzaberiSlovo = new JLabel("Pick a letter:");
			lblIzaberiSlovo.setHorizontalAlignment(SwingConstants.CENTER);
			lblIzaberiSlovo.setPreferredSize(new Dimension(100, 25));
		}
		return lblIzaberiSlovo;
	}
	private JComboBox getComboBoxSlova() {
		if (comboBoxSlova == null) {
			comboBoxSlova = new JComboBox();
			comboBoxSlova.addItem('A');
			comboBoxSlova.addItem('B');
			comboBoxSlova.addItem('C');
			comboBoxSlova.addItem('D');
			comboBoxSlova.addItem('E');
			comboBoxSlova.addItem('F');
			comboBoxSlova.addItem('G');
			comboBoxSlova.addItem('H');
			comboBoxSlova.addItem('I');
			comboBoxSlova.addItem('J');
			comboBoxSlova.addItem('K');
			comboBoxSlova.addItem('L');
			comboBoxSlova.addItem('M');
			comboBoxSlova.addItem('N');
			comboBoxSlova.addItem('O');
			comboBoxSlova.addItem('P');
			comboBoxSlova.addItem('Q');
			comboBoxSlova.addItem('R');
			comboBoxSlova.addItem('S');
			comboBoxSlova.addItem('T');
			comboBoxSlova.addItem('U');
			comboBoxSlova.addItem('V');
			comboBoxSlova.addItem('W');
			comboBoxSlova.addItem('X');
			comboBoxSlova.addItem('Y');
			comboBoxSlova.addItem('Z');
		}
		return comboBoxSlova;
	}
	private JLabel getLblTryTheWhole() {
		if (lblTryTheWhole == null) {
			lblTryTheWhole = new JLabel("Try the whole word:");
			lblTryTheWhole.setHorizontalAlignment(SwingConstants.CENTER);
			lblTryTheWhole.setPreferredSize(new Dimension(170, 25));
		}
		return lblTryTheWhole;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setPreferredSize(new Dimension(190, 25));
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblPrazanProstor1() {
		if (lblPrazanProstor1 == null) {
			lblPrazanProstor1 = new JLabel("");
			lblPrazanProstor1.setPreferredSize(new Dimension(200, 50));
		}
		return lblPrazanProstor1;
	}
	private JLabel getLblPrazanProstor2() {
		if (lblPrazanProstor2 == null) {
			lblPrazanProstor2 = new JLabel("");
			lblPrazanProstor2.setPreferredSize(new Dimension(170, 25));
		}
		return lblPrazanProstor2;
	}
	private JLabel getLabel_1() {
		if (lblPrazanProstor3 == null) {
			lblPrazanProstor3 = new JLabel("");
			lblPrazanProstor3.setPreferredSize(new Dimension(170, 25));
		}
		return lblPrazanProstor3;
	}
	private JButton getBtnExitGame() {
		if (btnExitGame == null) {
			btnExitGame = new JButton("Exit game");
			btnExitGame.setPreferredSize(new Dimension(100, 25));
		}
		return btnExitGame;
	}
	private JLabel getLabel_2() {
		if (lblPrazanProstor4 == null) {
			lblPrazanProstor4 = new JLabel("");
			lblPrazanProstor4.setPreferredSize(new Dimension(170, 140));
		}
		return lblPrazanProstor4;
	}
}

