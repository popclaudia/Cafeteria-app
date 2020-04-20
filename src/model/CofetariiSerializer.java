package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CofetariiSerializer<T> {


	String filename;
	private final Class<T> type;

	public CofetariiSerializer(Class<T> clas) {
		this.type = clas;
		if(type.getSimpleName().equals("Prajitura"))
			this.filename="prajituri.txt";
		else if(type.getSimpleName().equals("ContUtilizator"))
			this.filename="utilizatori.txt";
		else if(type.getSimpleName().equals("Cofetarie"))
			this.filename="cofetarii.txt";
	}

	public void serialize(List<T> prajituri) {
		try { 


			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(prajituri);
			out.close();
			file.close();

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

	}

	public ArrayList<T> deserialize() {
		ArrayList<T> items =new ArrayList<T>();
		try {

			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			items =  (ArrayList<T>) in.readObject();
			in.close();
			file.close();

		}catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return items;
	}

}
