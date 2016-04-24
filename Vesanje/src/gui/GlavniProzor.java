package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import baza.TabelaZaRec;
import gui.kontrolor.GUIKontrolor;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel panelZaRec;
	private JPanel panelZaDugmice;	
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
	private JTable table;
	private static char[] recZaPrikazNiz = "Default word".toCharArray();
	private JScrollPane scrollPane;
	private JButton btnTry;
	private JPanel panelZaSliku;
	private JLabel jlblSlika;
	private JButton btnGiveUp;
	

	public GlavniProzor() {
		GUIKontrolor.brojPromasaja=0;
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
			panelZaRec.add(getScrollPane());

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
			panelZaDugmice.add(getBtnTry());
			panelZaDugmice.add(getLabel_2());
			panelZaDugmice.add(getBtnExitGame());
			panelZaDugmice.add(getBtnGiveUp());
		}
		return panelZaDugmice;
	}


	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setPreferredSize(new Dimension(480, 18));
			table.setFillsViewportHeight(true);
			table.setShowHorizontalLines(false);
			table.setRowSelectionAllowed(false);
			table.setModel(new TabelaZaRec(recZaPrikazNiz));
			table.setTableHeader(null);
		}
		return table;
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
			comboBoxKategorije.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontrolor.brojPromasaja=0;
					
					String kategorija = comboBoxKategorije.getSelectedItem().toString();
					String recZaPrikaz = GUIKontrolor.vratiString(kategorija);
					recZaPrikazNiz = recZaPrikaz.toCharArray();
					table.setModel(new TabelaZaRec(recZaPrikazNiz));
					table.setTableHeader(null);

				}
			});
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
			comboBoxSlova.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String slovoString = comboBoxSlova.getSelectedItem().toString().trim();					
					char slovo = slovoString.charAt(0);
					//Milada: ako slovo postoji u reci, dodaj u GLOBALNU promenljivu					
					if(GUIKontrolor.trazenaRec.indexOf(slovo)!=-1){
						recZaPrikazNiz=GUIKontrolor.dodajSlovo(slovo,recZaPrikazNiz);
						table.setModel(new TabelaZaRec(recZaPrikazNiz));
						table.setTableHeader(null);						
					}else{ 
						GUIKontrolor.brojPromasaja++;
						promeniSliku();
					}
					if(GUIKontrolor.brojPromasaja==6){
						GUIKontrolor.brojPromasaja=0;
						GUIKontrolor.prikaziPoraz();
					}
					if(recZaPrikazNiz.toString().equals(GUIKontrolor.trazenaRec))
						GUIKontrolor.prikaziPobedu();					
					
				}

				
			});
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
			btnExitGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontrolor.ugasiAplikaciju();
				}
			});
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

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(480, 21));
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JButton getBtnTry() {
		if (btnTry == null) {
			btnTry = new JButton("Try!");
			btnTry.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontrolor.probajCeluRec(textField.getText().toString());
					if(GUIKontrolor.brojPromasaja>0)
						promeniSliku();					
					if(GUIKontrolor.brojPromasaja==6){
						GUIKontrolor.brojPromasaja=0;
						GUIKontrolor.prikaziPoraz();
					}
				}
				
			});
			btnTry.setPreferredSize(new Dimension(100, 25));
		}
		return btnTry;
	}
	
	
		private JLabel getJlblSlika() {
		if (jlblSlika == null) {
			jlblSlika = new JLabel("");			
			jlblSlika.setIcon(new ImageIcon(GlavniProzor.class.getResource("/resursi/vesala1.jpg")));
			
		}
		return jlblSlika;
	}
	private void promeniSliku() {		
			
			String putanja=null;
			
			switch(GUIKontrolor.brojPromasaja){
			
			case 0: putanja = "/resursi/vesala1.jpg";
					break;			
			case 1: putanja = "/resursi/vesala2.jpg";
					break;
			case 2: putanja = "/resursi/vesala3.jpg";
			        break;
			case 3: putanja = "/resursi/vesala4.jpg";
					break;
			case 4: putanja = "/resursi/vesala5.jpg";
					break;
			case 5: putanja = "/resursi/vesala6.jpg";
					break;
			case 6: putanja = "/resursi/vesala7.jpg";
					break;     
			
			}	
			jlblSlika.removeAll();
			jlblSlika.setIcon(new ImageIcon(GlavniProzor.class.getResource(putanja)));
			jlblSlika.revalidate();
			jlblSlika.repaint();
			
	}

		private JPanel getPanelZaSliku() {
			if (panelZaSliku == null) {
				panelZaSliku = new JPanel();
				panelZaSliku.add(getJlblSlika());
			}
			return panelZaSliku;
		}
	private JButton getBtnGiveUp() {
		if (btnGiveUp == null) {
			btnGiveUp = new JButton("Give up!");
			btnGiveUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnGiveUp.setPreferredSize(new Dimension(100, 25));
		}
		return btnGiveUp;
	}
	}

