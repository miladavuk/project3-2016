package baza;

import javax.swing.table.AbstractTableModel;
/*
 * Klasa predtsavlja tabelu u kojoj ce se ispisivati pojam za kojim igrac traga. 
 */

public class TabelaZaRec extends AbstractTableModel {
	/*
	 * Atribut oznacava niz karaktera koji predstavljaju pojam koji igrac treba
	 * da pogodi.
	 */
	private char[] recZaPrikazNiz;

	/*
	 * @return Metoda vraca pomenuti niz karaktera.
	 */
	public char[] getRecZaPrikazNiz() {
		return recZaPrikazNiz;
	}

	/*
	 * @param recZaPrikaz Metodi se prosledjuje vrednost reci.
	 * 
	 * Konstruktor postavlja vrednost atributa za rec na unetu vrednost. Potom
	 * se inicijalizuje tabela.
	 */
	public TabelaZaRec(char[] recZaPrikaz) {
		// recZaPrikazNiz = new char[recZaPrikaz.length];
		recZaPrikazNiz = recZaPrikaz;
		fireTableDataChanged();
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount() Metoda vraca broj
	 * kolona, koji je jednak velicini niza u kom se cuva rec koja treba da se
	 * pogodi.
	 */
	public int getColumnCount() {

		return recZaPrikazNiz.length;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount() Metoda vraca broj redova,
	 * u tom slucaju to je 1.
	 */
	public int getRowCount() {

		return 1;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int) Metoda vraca
	 * vrednost vrednost elemnta niza na poziciji u odredjenoj koloni, koja je
	 * prosledjena kao parametar.
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {

		return recZaPrikazNiz[columnIndex];
	}

}
