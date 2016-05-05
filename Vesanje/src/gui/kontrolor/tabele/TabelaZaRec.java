package gui.kontrolor.tabele;

import javax.swing.table.AbstractTableModel;
/**
 * Klasa predtsavlja tabelu u kojoj ce se ispisivati pojam za kojim igrac traga. 
 */

public class TabelaZaRec extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Atribut oznacava niz karaktera koji predstavljaju pojam koji igrac treba
	 * da pogodi.
	 */
	private char[] recZaPrikazNiz;

	/** Metoda vraca rec kao niz karaktera.
	 * @return recZaPrikazNiz
	 */
	public char[] getRecZaPrikazNiz() {
		return recZaPrikazNiz;
	}

	/**
	 * @param recZaPrikaz 
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
	/**
	 *  Metoda vraca broj kolona, koji je jednak velicini niza u kom se cuva rec koja treba da se pogodi.
	 *  @return recZaPrikazNiz.length
	 */
	public int getColumnCount() {

		return recZaPrikazNiz.length;
	}

	@Override
	/**
	 * Metoda vraca broj redova koji je uvek 1
	 */
	public int getRowCount() {

		return 1;
	}

	@Override
	/**
	 * Metoda vraca vrednost elemnta niza na poziciji u odredjenoj koloni, koja je prosledjena kao parametar.
	 * @param rowIndex, columnIndex
	 * @returnrecZaPrikazNiz[columnIndex]
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {

		return recZaPrikazNiz[columnIndex];
	}

}
