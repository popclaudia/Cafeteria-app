package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CofetariiSerializer;
import model.Prajitura;
import javafx.scene.chart.*;
import javafx.scene.Group;

public class Charts extends Application {
	ObservableList<PieChart.Data> pieChartData;
	ArrayList<Prajitura> p=new ArrayList<Prajitura>();
	CofetariiSerializer<Prajitura> pdata= new CofetariiSerializer<Prajitura>(Prajitura.class);

	@Override 
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Prajituri");
		stage.setWidth(500);
		stage.setHeight(500);
		p=pdata.deserialize();
		int i=0;
		PieChart.Data[] a =new PieChart.Data[p.size()];
		for(Prajitura ppp: p) {
			a[i]=new PieChart.Data(ppp.getDenumire(),ppp.getPret());
			
			//System.out.println(a[i].toString());
			i++;
		}	
       pieChartData = FXCollections.observableArrayList(a );
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Prajituri");
		((Group) scene.getRoot()).getChildren().add(chart);
		stage.setScene(scene);
		stage.show();
	} 
 

}