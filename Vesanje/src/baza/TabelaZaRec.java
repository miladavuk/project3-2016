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
	public int getColumnCount() {

		return recZaPrikazNiz.length;
	}

	@Override
	public int getRowCount() {

		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return recZaPrikazNiz[columnIndex];
	}

}
