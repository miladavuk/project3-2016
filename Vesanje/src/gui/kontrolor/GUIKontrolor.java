package gui.kontrolor;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import baza.Igrac;
import baza.Igraci;
import baza.Kategorije;
import gui.GlavniProzor;
import gui.Intructions;
import gui.Pobeda;
import gui.PocetniProzor;
import gui.Poraz;
import gui.Score;

public class GUIKontrolor {

	public static String trazenaRec = "";
	public static int brojPromasaja = 0;
	public static LinkedList<Character> koriscenaSlova = new LinkedList<>();
	public static int brojKoriscenihSlova = 0;
	public static PocetniProzor pocetniProzor;
	public static Igraci igraci;
	public static int indexTrenutnogIgraca;

	public static void main(String[] args) {
		igraci = new Igraci();
		indexTrenutnogIgraca = -1;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pocetniProzor = new PocetniProzor();
					pocetniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziGlavniProzor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziPobedu() {
		try {
			Pobeda dialog = new Pobeda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void prikaziPoraz() {
		try {
			Poraz dialog = new Poraz();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void prozorZaScore() {
		if(indexTrenutnogIgraca == -1){
			upozoriDaNijeIzabranIgrac();
			return;
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score frame = new Score();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static void pozoviInstrukcije() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intructions frame = new Intructions();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		//Milada:promenjeno na engleski jer pravimo aplikaciju na engleskom! :)
		//Marina: Yeah, I forgot. xD
		int opcija = JOptionPane.showConfirmDialog(pocetniProzor.getContentPane(),
				"Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			igraci.serijalizujIgrace();
			System.exit(0);
		}
	}
	
	public static Igrac vratiTrenutnogIgraca(){
		return igraci.vratiIgraca(indexTrenutnogIgraca);
	}
	
	public static void upozoriDaNijeIzabranIgrac(){
		JOptionPane.showMessageDialog(pocetniProzor.getContentPane(), "You haven't chosen a player!");
	}
	
	public static boolean incijalizujIgraca(String ime){
		if(!igraci.daLiPostoji(ime)) {
			igraci.dodajIgraca(ime);
			indexTrenutnogIgraca = igraci.vratiIndexIgraca(ime);
			return true;
		}
		indexTrenutnogIgraca = igraci.vratiIndexIgraca(ime);
		return false;
	}
	
}
