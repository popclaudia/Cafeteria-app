package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RaportJSON extends Raport{

	ArrayList<Prajitura> prajituri= new ArrayList<Prajitura>();

	public void adaugaPrajitura(Prajitura prajitura) {
		prajituri.add(prajitura);
	}
	public void genereazaFisier(String n) {
		FileWriter file;
		JSONObject jsonObject = new JSONObject();
		JSONArray pr = new JSONArray();
		JSONObject js;
		for(Prajitura p:prajituri) {
			js=new JSONObject();
			js.put("Denumire",p.getDenumire());
			js.put("Pret",p.getPret());
			js.put("Stoc",p.getStoc());
			js.put("Valabilitate",p.getValabilitate().getDate() +"-"+p.getValabilitate().getMonth() +"-"+p.getValabilitate().getYear());
			pr.add(js);
		}

		jsonObject.put("Prajituri",pr);
		try {
			file = new FileWriter(n+".json");
			file.write(jsonObject.toJSONString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

}
