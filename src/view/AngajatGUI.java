package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import javafx.application.Application;

public class AngajatGUI extends JFrame implements ActionListener {

	JPanel content=new JPanel();
	JLabel selectC, message,im, format,datePraji;
	JLabel denumire,pret, stoc, valabilitate, cofetarie;
	JTextField denumiret,prett, stoct;
	String  denumirett,prettt, stoctt, cofetariett,valabilitatett;
	JTextField vMin, vMax, numeFisier;
	JButton view, viu, filter1,  filter, find, cauta, statistics, crud, salveaza,  save1, save2, adauga,pretz,disponibi,valabi;
	ImageIcon image= new ImageIcon("download.png");
	JLabel hello;
	String c[]= {"Sweet Crown, Zorilor, 2","Sweet Crown, Marasti, 103","Sweet Crown, Eroilor, 24","Sweet Crown, Ghiorgheni, 72","Sweet Crown, Grigorescu, 3"};
	JComboBox<String>  cofetariec=new JComboBox<String>(c);
	JComboBox<String>  cofetariecc=new JComboBox<String>(c);
	JTable cl;
	int action=0;
	int row=9999;
	String cr[]= {"Pret","Disponibilitate","Valabilitate" };
	JComboBox<String>  criteriu=new JComboBox<String>(cr);
	String d[]= {"04.04.2020","05.04.2020","06.04.2020","07.04.2020","08.04.2020","09.04.2020","10.04.2020","11.04.2020","12.04.2020","13.04.2020","14.04.2020","15.04.2020","16.04.2020","17.04.2020","18.04.2020","19.04.2020","20.04.2020","21.04.2020","22.04.2020","23.04.2020","24.04.2020","25.04.2020","26.04.2020","27.04.2020","28.04.2020","29.04.2020","30.04.2020" };
	JComboBox<String>  valabilitatet=new JComboBox<String>(d);
	JComboBox<String>  prajituri;
	JButton viewP, ad, del, change;
	JRadioButton r1=new JRadioButton(".csv");    
	JRadioButton r2=new JRadioButton(".xml");    
	JRadioButton r3=new JRadioButton(".json");    
	String f;
	ButtonGroup bg=new ButtonGroup();    
	JFrame contentt =new JFrame();
	public AngajatGUI() {
		selectC = new JLabel();
		format = new JLabel("Format fisier:");

		im=new JLabel(image);
		view = new JButton("Vizualizare prajituri");
		filter = new JButton("Filtrare prajituri");
		filter1 = new JButton("Filtreaza");
		find = new JButton("Cautare prajitura");
		cauta = new JButton("Cauta");
		statistics = new JButton("Statistici prajituri");
		crud = new JButton("Administrare prajituri");
		viu = new JButton("Afiseaza");
		save1 = new JButton("Salvati datele obtinute");
		save2 = new JButton("Save");
		hello = new JLabel();
		vMin=new JTextField("Valoare minima");
		vMax=new JTextField("Valoare maxima");
		numeFisier=new JTextField("Nume fisier");
		datePraji=new JLabel("");
		viewP = new JButton("Vezi prajituri");
		ad = new JButton("Adauga prajitura");
		del = new JButton("Sterge prajitura");
		change = new JButton("Modifica prajitura");
		pretz = new JButton("Statistica pret");
		valabi = new JButton("Statistica valabilitate");
		disponibi = new JButton("Statistica disponibilitate");
		denumire=new JLabel("Denumire");
		cofetarie=new JLabel("Cofetarie");
		valabilitate=new JLabel("Valabilitate");
		pret=new JLabel("Pret");
		stoc=new JLabel("Stoc");
		adauga=new JButton("Adauga prajitura");
		denumiret=new JTextField();
		prett=new JTextField();
		stoct=new JTextField();
		salveaza=new JButton("Savati modificarile");

		this.setLayout(null);
		contentt.setLayout(null);
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		this.add(im);
		this.add(view);
		this.add(filter);
		this.add(find);
		this.add(statistics);
		this.add(crud);

		content.setLayout(null);
		this.add(content);
		content.add(hello);
		content.setBackground(new Color(  254, 251, 245));
		content.setBounds(10,140,700,520);

		hello.setBounds(50,40,300,40);
		hello.setFont(hello.getFont().deriveFont (26.0f));
		hello.setForeground(new Color(71, 39, 24));

		view.setBackground(new Color(85, 27, 20));
		view.setForeground(new Color(255, 255, 255));
		filter.setBackground(new Color(85, 27, 20));
		filter.setForeground(new Color(255, 255, 255));
		find.setBackground(new Color(85, 27, 20));
		find.setForeground(new Color(255, 255, 255));
		statistics.setBackground(new Color(85, 27, 20));
		statistics.setForeground(new Color(255, 255, 255));
		crud.setBackground(new Color(85, 27, 20));
		crud.setForeground(new Color(255, 255, 255));
		hello.setText("Hello Employee!");
		im.setBounds(290,5,120,80);
		view.setBounds(0,100,150,30);
		filter.setBounds(150,100,130,30);
		find.setBounds(280,100,130,30);
		statistics.setBounds(410,100,150,30);
		crud.setBounds(560,100,160,30);

		view.addActionListener(this);
		filter.addActionListener(this);
		save1.addActionListener(this);
		find.addActionListener(this);
		statistics.addActionListener(this);
		crud.addActionListener(this);
		ad.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		pretz.addActionListener(this);

		paint();
	}


	public void viewListener(ActionListener m) {
		viu.addActionListener(m);
	}
	public void filterListener(ActionListener m) {
		filter1.addActionListener(m);
	}

	public void searchListener(ActionListener m) {
		cauta.addActionListener(m);
	}

	public void viewPListener(ActionListener m) {
		viewP.addActionListener(m);
	}
	public void addListener(ActionListener m) {
		adauga.addActionListener(m);
	}
	public void deleteListener(ActionListener m) {
		del.addActionListener(m);
	}
	public void updateListener(ActionListener m) {
		change.addActionListener(m);
	}
	public void saveListener(ActionListener m) {
		salveaza.addActionListener(m);
	}
	public void saveFileListener(ActionListener m) {
		save2.addActionListener(m);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton button;
		JRadioButton rbutton;
		if(ae.getSource().getClass()==JRadioButton.class)
		{rbutton=(JRadioButton) ae.getSource();
		button=new JButton() ;
		}
		else
		{button=(JButton) ae.getSource();
		rbutton=new JRadioButton();
		}
		if(button.equals(view)) {
			prajiCofetarie();
		}
		if(button.equals(filter)) {
			filtrarePraji();
		}
		if(button.equals(save1)) {
			optiuniSalvare();
		}
		if(button.equals(find)) {
			datePrajitura();
		}
		if(button.equals(statistics)) {
			statisticiPrajitura();
		}

		if(button.equals(crud)) {
			crudPrajituri();
		}

		if(button.equals(ad)) {
			adaugare();
		}
		if(button.equals(change)) {
			updatePrajitura();
		}

		if(button.equals(pretz)) {
	        Application.launch(Charts.class,null);
	        pretz.setEnabled(false);
		}
		if(rbutton.equals(r1)||rbutton.equals(r2)||rbutton.equals(r3)) {
			f=new String(rbutton.getText());
		}

	}

	public Object getCof(){
		return cofetariec.getSelectedItem();
	}
	public Object getCriteriu(){
		return criteriu.getSelectedItem();
	}
	public Object getPrajitura(){
		return prajituri.getSelectedItem();
	}
	public String getMin(){
		return vMin.getText();
	}
	public String getMax(){
		return vMax.getText();
	}
	public String getD(){
		return denumiret.getText();
	}
	public String getP(){
		return prett.getText();
	}
	public String getS(){
		return stoct.getText();
	}
	public Object getV(){
		return valabilitatet.getSelectedItem();
	}
	public Object getC(){
		return cofetariecc.getSelectedItem();
	}
	public String getFormat(){
		return f;
	}
	public String getNumeFisier(){
		return numeFisier.getText();
	}

	public void setPrajituri(String s[]) {
		prajituri=new JComboBox(s);
	}
	public void setdatePrajitura(String s) {
		datePraji.setText("<html>" + s.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		repaint();
	}

	public void afisareLista(DefaultTableModel a) {

		content.removeAll();

		cl = new JTable(a);
		cl.setPreferredScrollableViewportSize(new Dimension(500,50));
		JScrollPane s1=new JScrollPane(cl);
		cl.setAutoResizeMode(WIDTH);
		cl.getCellSelectionEnabled();
		cl.getTableHeader().setBackground(new Color(52, 34, 21));
		cl.getTableHeader().setForeground(Color.WHITE);
		cl.getTableHeader().setFont(cl.getTableHeader().getFont().deriveFont(Font.BOLD));
		s1.setBounds(20, 60, 660, 300);
		content.add(s1);
		row=cl.getSelectedRow();
		row=9999;
		if(action==0) {
			content.add(selectC);
			content.add(cofetariec);
			content.add(viu);
		}
		if(action==1) {
			content.add(selectC);
			content.add(criteriu);
			content.add(filter1);
			content.add(vMin);
			content.add(vMax);
			content.add(save1);
			save1.setVisible(true);
			s1.setBounds(20, 90, 660, 250);
		}
		if(action==3) {
			content.add(viewP);
			content.add(ad);
			content.add(del);
			content.add(change);
			del.setEnabled(false);
			change.setEnabled(false);

		}
		if(action==4) {
			content.add(viewP);
			content.add(pretz);
			content.add(valabi);
			content.add(disponibi);

		}
		cl.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {   
				row=(int) cl.getValueAt(cl.getSelectedRow(), 0);
				if (action==3 && row !=9999) {
					del.setEnabled(true);
					change.setEnabled(true);}				
				denumirett=(String) cl.getValueAt(cl.getSelectedRow(), 1);
				prettt=cl.getValueAt(cl.getSelectedRow(), 2).toString();
				stoctt=cl.getValueAt(cl.getSelectedRow(), 3).toString();
				valabilitatett=(String) cl.getValueAt(cl.getSelectedRow(), 4);

			}
		});
		repaint();
	}





	public void prajiCofetarie() {
		content.removeAll();
		action=0;
		content.add(selectC);
		content.add(cofetariec);
		content.add(viu);
		selectC.setText("Selectati cofetaria dorita:");
		selectC.setBounds(20,20,180,30);
		selectC.setForeground(new Color(71, 39, 24));
		cofetariec.setBackground(Color.WHITE);
		cofetariec.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		cofetariec.setBounds(180,20,200,30);
		viu.setBackground(new Color(  242, 235, 230));
		viu.setBounds(400,20,100,30);

		repaint();

	}
	public void  filtrarePraji() {
		content.removeAll();
		action=1;
		content.add(selectC);
		content.add(criteriu);
		content.add(filter1);
		content.add(vMin);
		content.add(vMax);
		selectC.setText("Selectati criteriul de filtrare:");
		selectC.setBounds(20,20,180,27);
		selectC.setForeground(new Color(71, 39, 24));
		criteriu.setBackground(Color.WHITE);
		criteriu.setBounds(190,20,130,27);
		filter1.setBackground(new Color(  242, 235, 230));
		vMin.setBounds(345,20,110,27);
		vMax.setBounds(345,54,110,27);
		filter1.setBounds(490,20,150,28);
		save1.setBounds(20,400,200,28);
		save1.setBackground(new Color(  242, 235, 230));
		vMin.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				JTextField source = (JTextField)e.getComponent();
				source.setText("");
				source.removeFocusListener(this);
			}
		});
		vMax.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				JTextField source = (JTextField)e.getComponent();
				source.setText("");
				source.removeFocusListener(this);
			}
		});

		repaint();

	}

	public void datePrajitura() {

		content.removeAll();
		action=2;
		content.add(selectC);
		content.add(prajituri);
		content.add(cauta);
		content.add(datePraji);
		selectC.setText("Selectati prajitura dorita:");
		selectC.setBounds(20,20,180,30);
		datePraji.setBounds(100,40,500,200);
		selectC.setForeground(new Color(71, 39, 24));
		prajituri.setBackground(Color.WHITE);
		prajituri.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		prajituri.setBounds(180,20,200,30);
		cauta.setBackground(new Color(  242, 235, 230));
		cauta.setBounds(400,20,100,30);
		datePraji.setFont(datePraji.getFont().deriveFont (16.0f));
		datePraji.setFont(datePraji.getFont().deriveFont(Font.BOLD));
		datePraji.setForeground(new Color(71, 39, 24));

		repaint();

	}
	public void crudPrajituri() {

		content.removeAll();
		action=3;
		content.add(viewP);
		content.add(ad);
		content.add(del);
		content.add(change);
		viewP.setBackground(new Color(  82, 26, 15));
		viewP.setForeground(new Color(255, 255, 255));
		ad.setBackground(new Color(  82, 26, 15));
		ad.setForeground(new Color(255, 255, 255));
		del.setBackground(new Color( 82, 26, 15));
		del.setForeground(new Color(255, 255, 255));
		change.setBackground(new Color( 82, 26, 15));
		change.setForeground(new Color(255, 255, 255));

		viewP.setBounds(15,15,130,30);
		ad.setBounds(15,450,140,30);
		del.setBounds(165,450,140,30);
		change.setBounds(315,450,140,30);
		del.setEnabled(false);
		change.setEnabled(false);

		repaint();
	}

	public void statisticiPrajitura() {

		content.removeAll();
		action=4;
		content.add(viewP);
		content.add(pretz);
		content.add(valabi);
		content.add(disponibi);
		viewP.setBackground(new Color(  82, 26, 15));
		viewP.setForeground(new Color(255, 255, 255));
		pretz.setBackground(new Color(  82, 26, 15));
		pretz.setForeground(new Color(255, 255, 255));
		disponibi.setBackground(new Color( 82, 26, 15));
		disponibi.setForeground(new Color(255, 255, 255));
		valabi.setBackground(new Color( 82, 26, 15));
		valabi.setForeground(new Color(255, 255, 255));

		viewP.setBounds(15,15,130,30);
		pretz.setBounds(15,450,140,30);
		disponibi.setBounds(165,450,180,30);
		valabi.setBounds(355,450,180,30);

		repaint();
	}

	public void adaugare() {
		contentt.add(denumire);
		contentt.add(pret);
		contentt.add(cofetarie);
		contentt.add(stoc);
		contentt.add(valabilitate);

		contentt.add(denumiret);
		contentt.add(prett);
		contentt.add(stoct);
		contentt.add(valabilitatet);
		contentt.add(cofetariecc);

		contentt.add(adauga);

		denumire.setBounds(47,20,200,30);
		pret.setBounds(47,60,200,30);
		cofetarie.setBounds(47,100,200,30);
		stoc.setBounds(47,140,200,30);
		valabilitate.setBounds(47,180,200,30);

		denumiret.setBounds(140,20,200,30);
		prett.setBounds(140,60,200,30);
		cofetariecc.setBounds(140,100,200,30);
		stoct.setBounds(140,140,200,30);
		valabilitatet.setBounds(140,180,200,30);

		denumiret.setText("");
		prett.setText("");
		valabilitatet.setSelectedItem("");
		stoct.setText("");
		cofetariec.setSelectedIndex(0);
		adauga.setBounds(95,270,200,35);
		adauga.setBackground(new Color(  242, 235, 230));
		cofetariecc.setEnabled(true);
		contentt.setVisible(true);
		salveaza.setVisible(false);
		adauga.setVisible(true);
		contentt.repaint();
	}

	public void updatePrajitura() {
		contentt.add(denumire);
		contentt.add(pret);
		contentt.add(cofetarie);
		contentt.add(stoc);
		contentt.add(valabilitate);

		contentt.add(denumiret);
		contentt.add(prett);
		contentt.add(stoct);
		contentt.add(valabilitatet);
		contentt.add(cofetariecc);

		contentt.add(salveaza);

		denumire.setBounds(47,20,200,30);
		pret.setBounds(47,60,200,30);
		cofetarie.setBounds(47,100,200,30);
		stoc.setBounds(47,140,200,30);
		valabilitate.setBounds(47,180,200,30);
		cofetariecc.setEnabled(false);
		denumiret.setBounds(140,20,200,30);
		prett.setBounds(140,60,200,30);
		cofetariecc.setBounds(140,100,200,30);
		stoct.setBounds(140,140,200,30);
		valabilitatet.setBounds(140,180,200,30);

		denumiret.setText(denumirett);
		prett.setText(prettt);
		cofetariecc.setSelectedItem(cofetariett);
		valabilitatet.setSelectedItem(valabilitatett);
		stoct.setText(stoctt);
		salveaza.setBounds(95,270,200,35);
		salveaza.setBackground(new Color(  242, 235, 230));
		salveaza.setVisible(true);
		adauga.setVisible(false);
		contentt.setVisible(true);
		contentt.repaint();
	}


	public void optiuniSalvare() {
		content.add(numeFisier);
		content.add(format);
		content.add(r1);
		content.add(r2);
		content.add(r3);
		content.add(save2);
		save1.setVisible(false);
		numeFisier.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				JTextField source = (JTextField)e.getComponent();
				source.setText("");
				source.removeFocusListener(this);
			}
		});
		numeFisier.setBounds(220,450,200,28);
		save2.setBounds(550,448,100,35);
		save2.setBackground(new Color(  242, 235, 230));
		format.setBounds(450,400,200,28);
		r1.setBounds(455,430,60,20);    
		r2.setBounds(455,455,60,20); 
		r3.setBounds(455,480,60,20); 
		repaint();
	}

	public  void infoBox(String infoMessage, String titleBar)
	{
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public int getRow() {
		return this.row;
	}

	public void paint() {
		this.getContentPane().setBackground( new Color(252, 228, 201));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Angajat");
		setSize(726,700);
		setResizable(false);
		setVisible(true);

		contentt.getContentPane().setBackground( new Color(252, 228, 201));
		///contentt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentt.setTitle("Prajitura");
		contentt.setSize(400,400);
		contentt.setResizable(false);

	}
}
