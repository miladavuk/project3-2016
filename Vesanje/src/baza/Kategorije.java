
package baza;

/**
 *   U ovoj klasi se nalaze kategorije pojmova koje mogu da se odaberu, kao i 20 pojmova po svakoj kategoriji.
 */
public class Kategorije {
	/**
	 * Atribut predstavlja niz od 20 pojmova za kategoriju knjge.
	 */
	private static String[] knjige = new String[] { "Gone with the wind", "A thousand splendid suns", "The kite runner",
			"Harry Potter and the philosopher's stone", "The adventures of Huckleberry Finn", "The great Gatsby",
			"The brothers Karamazov", "One hundred years of solitude", "The catcher in the Rye", "Pride and prejudice",
			"To kill a mockingbird", "Wuthering heights", "Crime and punishment", "The old man and the sea",
			"The picture of Dorian Grey", "Chronicles of Narnia", "Twenty thousand leagues under the sea",
			"The three musketeers", "The count of Monte Cristo", "The adventures of Sherlock Holmes" };
	/**
	 * Atribut predstavlja niz od 20 pojmova za kategoriju drzave.
	 */
	private static String[] drzave = new String[] { "Czech Republic", "Dominican republic", "Republic of Djibouti",
			"Republic of the Congo", "Equatorial Guinea", "Guadeloupe", "Kyrgyzstan", "Luxembourg", "Mozambique",
			"Netherlands", "Philippines", "Saudi Arabia", "Swaziland", "Trinidad and Tobago", "United Arab Emirates",
			"Antigua and Barbuda", "Bosnia and Herzegovina", "Burkina Faso", "Botswana", "El Salvador" };
	/**
	 * Atribut predstavlja niz od 20 pojmova za kategoriju filmovi.
	 */
	private static String[] filmovi = new String[] { "The Pink Panther", "Minions", "Despicable Me", "Scream", "Hunger Games",
			"Interstellar", "Schindler's List", "Pirats Of The Carribian", "Madagascar", "Frozen", "Hobbit",
			"The Lord Of The Rings", "Adaptation", "Dead Poets Society", "Hook", "Spiderman", "The Avengers", "Avatar",
			"Titanic", "Finding Neverland" };
	/**
	 * Atribut predstavlja niz od 20 pojmova za kategoriju brendovi.
	 */
	private static String[] brendovi = new String[] { "Coca Cola", "Orbit", "Bershka", "Converse", "Nike", "Rebook",
			"Celvin Klein", "Java", "Nokia", "Microsoft", "Pionir", "Marlboro", "Miflord", "Nivea", "Dove", "Gorenje",
			"Banini", "Bambi", "Toshiba", "Genius" };
	/**
	 * Atribut predstavlja niz od 20 pojmova za kategoriju poznate licnosti.
	 */
	private static String[] poznateLicnosti = new String[] { "Rafael Nadal", "Rihanna", "Brad Pitt", "Leonardo DiCaprio",
			"Tom Cruise", "Barak Obama", "Emma Watson", "Johnny Depp", "Morgan Freeman", "Michael Jordan",
			"Kobe Bryant", "LeBron James", "Madonna", "Stephen King", "Michael Jackson", "Jennifer Lopez", "Bill Gates",
			"Paulo Coelho", "Joanne Kathleen Rowling", "George RR Martin" };
	/**
	 * Atribut predstavlja niz od 20 pojmova za kategoriju istorijske licnosti.
	 */
	private static String[] istorijskeLicnosti = new String[] { "William Shakespeare", "Abraham Lincoln", "George Washington",
			"Adolf Hitler", "Aristotle", "Charles Darwin", "Karl Marx", "Julius Caesar", "Albert Einstein",
			"Christopher Columbus", "Isaac Newton", "Wolfgang Amadeus Mozart", "Leonardo da Vinci", "Charles Dickens",
			"Winston Churchill", "Friedrich Nietzsche", "Sigmund Freud", "Johann Sebastian Bach", "Galileo Galilei",
			"Adam Smith" };

	/**
	 * @return knjige
	 * Metoda vraca niz pojmova za kategoriju knjige.
	 */

	public static String[] getKnjige() {
		return knjige;
	}

	/**
	 * @return drzave
	 * Metoda vraca niz pojmova za kategoriju drzave.
	 */
	public static String[] getDrzave() {
		return drzave;
	}

	/**
	 * @return filmovi
	 * Metoda vraca niz pojmova za kategoriju filmovi.
	 */
	public static String[] getFilmovi() {
		return filmovi;
	}

	/**
	 * @return brendovi
	 * Metoda vraca niz pojmova za kategoriju brendovi.
	 */
	public static String[] getBrendovi() {
		return brendovi;
	}


	/**
	 * @return poznateLicnosti
	 * Metoda vraca niz pojmova za kategoriju poznate licnosti.
	 */
	public static String[] getPoznateLicnosti() {
		return poznateLicnosti;
	}

	/**
	 * @return istorijskeLicnosti
	 * Metoda vraca niz pojmova za kategoriju istorijske licnosti.
	 */
	public static String[] getIstorijskeLicnosti() {
		return istorijskeLicnosti;
	}


}
