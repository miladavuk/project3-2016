package baza;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class Igraci implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Igrac> igraci;
	
	public Igraci(){
		igraci = new LinkedList<>();
		deserijalizujIgrace();
	}
	
	public boolean daLiPostoji(String ime){
		for (Igrac igrac : igraci) {
			if(igrac.getIme().equals(ime))return true;
		}
		return false;
	}
	
	public void dodajIgraca(String ime){
		igraci.add(new Igrac(ime));
	}

	
	public void serijalizujIgrace(){
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Igraci.ser"))){
			out.writeObject(igraci);
		} catch (Exception e) {
			System.out.println("Nije uspelo serijalizovanje!");
		}

	}
	
	public void deserijalizujIgrace(){
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Igraci.ser"))){
			igraci.addAll((LinkedList<Igrac>)in.readObject());			
		} catch (Exception e) {
			System.out.println("Nije uspelo ocitavanje!");
		}
	}
	
	public int vratiIndexIgraca(String ime){
		for (int i = 0; i < igraci.size(); i++) {
			if(igraci.get(i).getIme().equals(ime)) return i;
		}
		return -1;
	}
	
	public Igrac vratiIgraca(int index){
		return igraci.get(index);
	}
	
	public void ispisiIgrace(){
		for (Igrac igrac : igraci) {
			System.out.println(igrac.getIme());
		}
	}
}
