package baza;

import javax.swing.table.AbstractTableModel;

public class TabelaZaScore extends AbstractTableModel {
	
	private Igrac igrac;
	
	public TabelaZaScore(Igrac igrac){
		this.igrac = igrac;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getValueAt(int rowCount, int columnCount) {
		switch(columnCount){
			case 0: return igrac.getBrendovi().size() + " / 20";
			case 1: return igrac.getDrzave().size() + " / 20";
			case 2: return igrac.getFilmovi().size() + " / 20";
			case 3: return igrac.getKnjige().size() + " / 20";
			case 4: return igrac.getIstorijskeLicnosti() + " / 20";
			case 5: return igrac.getPoznateLicnosti().size() + " / 20";
			default: return "N/A";
		}
	}
	
	@Override
	public String getColumnName(int column) {
		switch(column){
		case 0: return "Brands";
		case 1: return "Countries";
		case 2: return "Movies";
		case 3: return "Books";
		case 4: return "Hystorical people";
		case 5: return "Famous people";
		default: return "N/A";
		}
	}

}
