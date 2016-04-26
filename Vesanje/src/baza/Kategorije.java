
package baza;

/*
 *   U ovoj klasi se nalaze kategorije pojmova koje mogu da se odaberu, kao i 20 pojmova po svakoj kategoriji.
 */
public class Kategorije {
	/*
	 * Atribut predstavlja niz od 20 pojmova za kategoriju knjge.
	 */
	private String[] knjige = new String[] { "Gone with the wind", "A thousand splendid suns", "The kite runner",
			"Harry Potter and the philosopher's stone", "The adventures of Huckleberry Finn", "The great Gatsby",
			"The brothers Karamazov", "One hundred years of solitude", "The catcher in the Rye", "Pride and prejudice",
			"To kill a mockingbird", "Wuthering heights", "Crime and punishment", "The old man and the sea",
			"The picture of Dorian Grey", "Chronicles of Narnia", "Twenty thousand leagues under the sea",
			"The three musketeers", "The count of Monte Cristo", "The adventures of Sherlock Holmes" };
	/*
	 * Atribut predstavlja niz od 20 pojmova za kategoriju drzave.
	 */
	private String[] drzave = new String[] { "Czech Republic", "Dominican republic", "Republic of Djibouti",
			"Republic of the Congo", "Equatorial Guinea", "Guadeloupe", "Kyrgyzstan", "Luxembourg", "Mozambique",
			"Netherlands", "Philippines", "Saudi Arabia", "Swaziland", "Trinidad and Tobago", "United Arab Emirates",
			"Antigua and Barbuda", "Bosnia and Herzegovina", "Burkina Faso", "Botswana", "El Salvador" };
	/*
	 * Atribut predstavlja niz od 20 pojmova za kategoriju filmovi.
	 */
	private String[] filmovi = new String[] { "The Pink Panther", "Minions", "Despicable Me", "Scream", "Hunger Games",
			"Interstellar", "Schindler's List", "Pirats Of The Carribian", "Madagascar", "Frozen", "Hobbit",
			"The Lord Of The Rings", "Adaptation", "Dead Poets Society", "Hook", "Spiderman", "The Avengers", "Avatar",
			"Titanic", "Finding Neverland" };
	/*
	 * Atribut predstavlja niz od 20 pojmova za kategoriju brendovi.
	 */
	private String[] brendovi = new String[] { "Coca Cola", "Orbit", "Bershka", "Converse", "Nike", "Rebook",
			"Celvin Klein", "Java", "Nokia", "Microsoft", "Pionir", "Marlboro", "Miflord", "Nivea", "Dove", "Gorenje",
			"Banini", "Bambi", "Toshiba", "Genius" };
	/*
	 * Atribut predstavlja niz od 20 pojmova za kategoriju poznate licnosti.
	 */
	private String[] poznateLicnosti = new String[] { "Rafael Nadal", "Rihanna", "Brad Pitt", "Leonardo DiCaprio",
			"Tom Cruise", "Barak Obama", "Emma Watson", "Johnny Depp", "Morgan Freeman", "Michael Jordan",
			"Kobe Bryant", "LeBron James", "Madonna", "Stephen King", "Michael Jackson", "Jennifer Lopez", "Bill Gates",
			"Paulo Coelho", "Joanne Kathleen Rowling", "George RR Martin" };
	/*
	 * Atribut predstavlja niz od 20 pojmova za kategoriju istorijske licnosti.
	 */
	private String[] istorijskeLicnosti = new String[] { "William Shakespeare", "Abraham Lincoln", "George Washington",
			"Adolf Hitler", "Aristotle", "Charles Darwin", "Karl Marx", "Julius Caesar", "Albert Einstein",
			"Christopher Columbus", "Isaac Newton", "Wolfgang Amadeus Mozart", "Leonardo da Vinci", "Charles Dickens",
			"Winston Churchill", "Friedrich Nietzsche", "Sigmund Freud", "Johann Sebastian Bach", "Galileo Galilei",
			"Adam Smith" };

	/*
	 * @return Metoda vraca niz pojmova za kategoriju knjige.
	 */

	public String[] getKnjige() {
		return knjige;
	}

	public void setKnjige(String[] knjige) {
		this.knjige = knjige;
	}

	/*
	 * @return Metoda vraca niz pojmova za kategoriju drzave.
	 */
	public String[] getDrzave() {
		return drzave;
	}

	public void setDrzave(String[] drzave) {
		this.drzave = drzave;
	}

	/*
	 * @return Metoda vraca niz pojmova za kategoriju filmovi.
	 */
	public String[] getFilmovi() {
		return filmovi;
	}

	public void setFilmovi(String[] filmovi) {
		this.filmovi = filmovi;
	}

	/*
	 * @return Metoda vraca niz pojmova za kategoriju brendovi.
	 */
	public String[] getBrendovi() {
		return brendovi;
	}

	public void setBrendovi(String[] brendovi) {
		this.brendovi = brendovi;
	}

	/*
	 * @return Metoda vraca niz pojmova za kategoriju poznate licnosti.
	 */
	public String[] getPoznateLicnosti() {
		return poznateLicnosti;
	}

	public void setPoznateLicnosti(String[] poznateLicnosti) {
		this.poznateLicnosti = poznateLicnosti;
	}

	/*
	 * @return Metoda vraca niz pojmova za kategoriju istorijske licnosti.
	 */
	public String[] getIstorijskeLicnosti() {
		return istorijskeLicnosti;
	}

	public void setIstorijskeLicnosti(String[] istorijskeLicnosti) {
		this.istorijskeLicnosti = istorijskeLicnosti;
	}

}
