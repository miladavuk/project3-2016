package baza;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Igraci {
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
	
	public boolean incijalizujIgraca(String ime){
		if(!daLiPostoji(ime)) {
			igraci.add(new Igrac(ime));
			return true;
		}
		return false;
	}
	
	public void serijalizujIgrace(){
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Igraci.ser"))){
			for (Igrac igrac : igraci) {
				out.writeObject(igrac);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void deserijalizujIgrace(){
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Igraci.ser"))){
			while(in.available() > 0){
				igraci.add((Igrac)in.readObject());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
