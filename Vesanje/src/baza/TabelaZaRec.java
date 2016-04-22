package baza;

import javax.swing.table.AbstractTableModel;


public class TabelaZaRec extends AbstractTableModel {
	
	private char[] recZaPrikazNiz;
	
	public TabelaZaRec(char[] recZaPrikaz) {
		recZaPrikazNiz = new char[recZaPrikaz.length];
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
