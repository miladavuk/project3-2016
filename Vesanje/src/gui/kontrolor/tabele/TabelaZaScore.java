package gui.kontrolor.tabele;

import javax.swing.table.AbstractTableModel;
/*
 *		Klasa predstavlja tabelu u kojoj ce biti prikazan broj pogodjenih pojmova, 
 *		po svakoj kategoriji, za odredjenog igraca. 
 */

import baza.Igrac;

public class TabelaZaScore extends AbstractTableModel {
	/*
	 * Atribut predstavlja igraca.
	 */
	private Igrac igrac;

	/*
	 * @param igrac Metodi se prosledjuje igrac. Konstruktor postavlja vrednost
	 * promenljive igrac na vrednost unetu kao parametar.
	 */
	public TabelaZaScore(Igrac igrac) {
		this.igrac = igrac;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 * 
	 * Metoda vraca broj kolona, u ovom slucaju to je 6.
	 */
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount() Metoda vraca broj redova,
	 * u ovom slucaju postoji jedan red.
	 */
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 * 
	 * Metoda vraca, u zavisnosti od unetog parametra za broj redova, broj
	 * pogodjenih pojmova za datog igraca po svakoj kategoriji.
	 */
	public Object getValueAt(int rowCount, int columnCount) {
		if (igrac == null)
			return "";
		switch (columnCount) {
		case 0:
			return igrac.getBrendovi().size() + " / 20";
		case 1:
			return igrac.getDrzave().size() + " / 20";
		case 2:
			return igrac.getFilmovi().size() + " / 20";
		case 3:
			return igrac.getKnjige().size() + " / 20";
		case 4:
			return igrac.getIstorijskeLicnosti().size() + " / 20";
		case 5:
			return igrac.getPoznateLicnosti().size() + " / 20";
		default:
			return "N/A";
		}
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 * 
	 * Metoda u zavisnosti od vrednosti unetog parametra vraca vrednost
	 * odgovarajuce kategorije pojmova.
	 * 
	 */
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Brands";
		case 1:
			return "Countries";
		case 2:
			return "Movies";
		case 3:
			return "Books";
		case 4:
			return "Historical people";
		case 5:
			return "Famous people";
		default:
			return "N/A";
		}
	}

}
