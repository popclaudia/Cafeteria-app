package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AdministratorGUI extends JFrame implements ActionListener {
	JPanel menu=new JPanel();
	JPanel content=new JPanel();
	JLabel hello, message,im;
	JTextField userName_text;
	JPasswordField password_text;
	JButton view, ad, del, change;
	ImageIcon image= new ImageIcon("download.png");
	JButton vezi, adauga, sterge, updateaza, salveaza;
	JLabel confirm=new JLabel();
	JTable cl;
	int row=9999;
	int st=0;
	String tnume, tvarsta, trol, tpost, tcofetarie, tuser, tparola;
	JLabel nume= new JLabel();
	JLabel varsta=new JLabel(); 
	JLabel cod= new JLabel(); 
	JLabel rol= new JLabel(); 
	JLabel post= new JLabel(); 
	JLabel cofetarie= new JLabel();
	JLabel user= new JLabel();
	JLabel pass = new JLabel();
	JLabel upd = new JLabel();

	JTextField numet= new JTextField();
	JTextField varstat= new JTextField();
	JTextField usert= new JTextField();
	JTextField passt= new JTextField();
	JTextField numett= new JTextField();
	JTextField varstatt= new JTextField();
	JTextField usertt= new JTextField();
	JTextField passtt= new JTextField();

	String r[]= {"Angajat","Administrator"};
	String p[]= {"Cofetar","Vanzator"};
	String c[]= {"Sweet Crown, Zorilor, 2","Sweet Crown, Marasti, 103","Sweet Crown, Eroilor, 24","Sweet Crown, Ghiorgheni, 72","Sweet Crown, Grigorescu, 3"};
	JComboBox<String> rolc=new JComboBox<String>(r);
	JComboBox<String>  postc=new JComboBox<String> (p);
	JComboBox<String>  cofetariec=new JComboBox<String>(c);

	JComboBox<String> rolcc=new JComboBox<String>(r);
	JComboBox<String>  postcc=new JComboBox<String> (p);
	JComboBox<String>  cofetariecc=new JComboBox<String>(c);

	public AdministratorGUI() {

		hello = new JLabel();
		im=new JLabel(image);
		view = new JButton("Vezi angajati");
		ad = new JButton("Adauga angajat");
		del = new JButton("Sterge angajat");
		change = new JButton("Modifica angajat");
		vezi=new JButton("Afiseaza lista cu toti angajatii");
		adauga=new JButton("Adauga noul utilizator");
		sterge=new JButton("Sterge angajatul selectat");
		updateaza=new JButton("Actualizati angajatul selectat");
		salveaza=new JButton("Savati modificarile");

		this.setLayout(null);
		menu.setLayout(null);
		content.setLayout(null);

		this.add(im);
		this.add(menu);
		this.add(content);
		menu.add(view);
		menu.add(ad);
		menu.add(del);
		menu.add(change);
		content.add(hello);

		view.addActionListener(this);
		ad.addActionListener(this);
		del.addActionListener(this);
		change.addActionListener(this);

		formatare();
		paint();	

	}
	public void formatare() {

		menu.setBackground(new Color( 227, 180, 146));
		menu.setBounds(10,115,160,500);
		content.setBackground(new Color(  254, 251, 245));
		content.setBounds(185,115,790,500);

		view.setBackground(new Color(  82, 26, 15));
		view.setForeground(new Color(255, 255, 255));
		ad.setBackground(new Color(  82, 26, 15));
		ad.setForeground(new Color(255, 255, 255));
		del.setBackground(new Color( 82, 26, 15));
		del.setForeground(new Color(255, 255, 255));
		change.setBackground(new Color( 82, 26, 15));
		change.setForeground(new Color(255, 255, 255));

		hello.setText("Hello Admin!");
		hello.setForeground(new Color(71, 39, 24));
		upd.setText("Selectati utilizatorul al carui date doriti sa le actualizati.  ");
		hello.setFont(hello.getFont().deriveFont (30.0f));
		im.setBounds(30,7,120,80);
		view.setBounds(15,15,130,40);
		ad.setBounds(15,65,130,40);
		del.setBounds(15,115,130,40);
		change.setBounds(15,165,130,40);
		hello.setBounds(50,40,300,40);

		nume.setText("Nume");
		varsta.setText("Varsta");
		cod.setText("Cod");
		rol.setText("Rol");
		post.setText("Post ocupat");
		cofetarie.setText("Cofetarie");
		user.setText("Username");
		pass.setText("Parola");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		JButton button=(JButton) ae.getSource();
		if(button.equals(view)) {
			vizualizare();
		}
		if(button.equals(ad)) {
			adaugare();
		}
		if(button.equals(change)) {
			modificare();
		}
		if(button.equals(del)) {
			stergere();
		}
	}

	public void vizualizare() {
		st=0;
		content.removeAll();
		vezi.setText("Afiseaza lista cu toti angajatii lantului de cofetarii");
		vezi.setBackground(new Color(  242, 235, 230));
		content.add(vezi);
		vezi.setBounds(17,17,370,30);	
		repaint();
	}

	public void adaugare() {

		content.removeAll();
		content.add(nume);
		content.add(varsta);
		content.add(cod);
		content.add(rol);
		content.add(post);
		content.add(cofetarie);
		content.add(user);
		content.add(pass);
		content.add(numet);
		content.add(varstat);
		content.add(rolc);
		content.add(postc);
		content.add(cofetariec);
		content.add(usert);
		content.add(passt);
		content.add(adauga);

		nume.setBounds(17,20,200,30);
		varsta.setBounds(17,60,200,30);
		rol.setBounds(17,100,200,30);
		post.setBounds(17,140,200,30);
		cofetarie.setBounds(17,180,200,30);
		user.setBounds(17,220,200,30);
		pass.setBounds(17,260,200,30);

		numet.setBounds(140,20,200,30);
		varstat.setBounds(140,60,200,30);
		rolc.setBounds(140,100,200,30);
		postc.setBounds(140,140,200,30);
		cofetariec.setBounds(140,180,200,30);
		usert.setBounds(140,220,200,30);
		passt.setBounds(140,260,200,30);

		adauga.setBounds(20,360,200,30);
		adauga.setBackground(new Color(  242, 235, 230));

		repaint();
	}

	public void stergere() {

		content.removeAll();
		st=1;
		vezi.setText("Afiseaza lista cu angajatii");
		vezi.setBackground(new Color(  242, 235, 230));
		content.add(vezi);
		vezi.setBounds(17,17,200,30);
		sterge.setBackground(new Color(  242, 235, 230));
		sterge.setEnabled(false);
		content.add(sterge);
		sterge.setBounds(20,440,200,30);

		repaint();
	}

	public void modificare() {
		content.removeAll();
		st=2;
		vezi.setText("Afiseaza angajati");
		vezi.setBackground(new Color(  242, 235, 230));
		content.add(vezi);
		vezi.setBounds(17,17,200,30);
		upd.setBounds(17,60,400,30);
		updateaza.setBackground(new Color(  242, 235, 230));
		updateaza.setEnabled(false);
		content.add(updateaza);
		updateaza.setBounds(20,440,200,30);

		repaint();
	}

	public void updateAngajat(){
		content.removeAll();

		content.add(nume);
		content.add(varsta);
		content.add(cod);
		content.add(rol);
		content.add(post);
		content.add(cofetarie);
		content.add(user);
		content.add(pass);
		content.add(numett);
		content.add(varstatt);
		content.add(rolcc);
		content.add(postcc);
		content.add(cofetariecc);
		content.add(usertt);
		content.add(passtt);
		content.add(salveaza);

		nume.setBounds(17,20,200,30);
		varsta.setBounds(17,60,200,30);
		rol.setBounds(17,100,200,30);
		post.setBounds(17,140,200,30);
		cofetarie.setBounds(17,180,200,30);
		user.setBounds(17,220,200,30);
		pass.setBounds(17,260,200,30);

		numett.setBounds(140,20,200,30);
		varstatt.setBounds(140,60,200,30);
		rolcc.setBounds(140,100,200,30);
		postcc.setBounds(140,140,200,30);
		cofetariecc.setBounds(140,180,200,30);
		usertt.setBounds(140,220,200,30);
		passtt.setBounds(140,260,200,30);

		numett.setText(tnume);
		varstatt.setText(tvarsta);
		rolcc.setSelectedItem(trol);
		postcc.setSelectedItem(tpost);
		cofetariecc.setSelectedItem(tcofetarie);
		usertt.setText(tuser);
		passtt.setText(tparola);

		usertt.setEditable(false);
		passtt.setEditable(false);
		salveaza.setBounds(20,360,200,30);
		salveaza.setBackground(new Color(  242, 235, 230));
		System.out.println(row);
		repaint();
	}

	public String getN(){
		return numet.getText();
	}
	public String getV(){
		return varstat.getText();
	}
	public Object getRol(){
		return rolc.getSelectedItem();
	}
	public Object getPost(){
		return postc.getSelectedItem();
	}
	public Object getCof(){
		return cofetariec.getSelectedItem();
	}
	public String getN1(){
		return numett.getText();
	}
	public String getV1(){
		return varstatt.getText();
	}
	public Object getRol1(){
		return rolcc.getSelectedItem();
	}
	public Object getPost1(){
		return postcc.getSelectedItem();
	}
	public Object getCof1(){
		return cofetariecc.getSelectedItem();
	}
	public String getPar(){
		return passt.getText();
	}
	public String getU(){
		return usert.getText();
	}

	public void viewListener(ActionListener m) {
		vezi.addActionListener(m);
	}

	public void addListener(ActionListener m) {
		adauga.addActionListener(m);
	}

	public void deleteListener(ActionListener m) {
		sterge.addActionListener(m);
	}
	public void updateListener(ActionListener m) {
		updateaza.addActionListener(m);
	}
	public void saveListener(ActionListener m) {
		salveaza.addActionListener(m);
	}

	public void afisareLista(DefaultTableModel a) {

		content.removeAll();
		updateaza.setEnabled(false);
		content.add(vezi);
		cl = new JTable(a);
		cl.setPreferredScrollableViewportSize(new Dimension(500,50));
		JScrollPane s1=new JScrollPane(cl);
		cl.setAutoResizeMode(WIDTH);
		cl.getCellSelectionEnabled();
		cl.getTableHeader().setBackground(new Color(52, 34, 21));
		cl.getTableHeader().setForeground(Color.WHITE);
		cl.getTableHeader().setFont(cl.getTableHeader().getFont().deriveFont(Font.BOLD));
		s1.setBounds(17, 60, 756, 280);
		content.add(s1);
		row=cl.getSelectedRow();
		if (st==1) {
			content.add(sterge);
		}
		if (st==2) {
			content.add(vezi);
			content.add(upd);
			content.add(updateaza);
			s1.setBounds(17, 100, 756, 280);

		}
		cl.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {   
				row=(int) cl.getValueAt(cl.getSelectedRow(), 0);
				if (st==1) {
					mesajStergere(row,1);
					sterge.setEnabled(true);}
				if (st==2){
					mesajStergere(row,2);
					updateaza.setEnabled(true);
					tnume=(String) cl.getValueAt(cl.getSelectedRow(), 1);
					tvarsta=cl.getValueAt(cl.getSelectedRow(), 2).toString();
					trol=(String) cl.getValueAt(cl.getSelectedRow(), 3);
					tpost=(String) cl.getValueAt(cl.getSelectedRow(), 4);
					tcofetarie=(String) cl.getValueAt(cl.getSelectedRow(), 5);
					tuser=(String) cl.getValueAt(cl.getSelectedRow(), 6);
					tparola=(String) cl.getValueAt(cl.getSelectedRow(), 7);
				}

			}
		});

		repaint();
	}


	public int getRow() {
		return this.row;
	}

	public void mesajStergere(int i, int j) {
		if(j==1)
			confirm.setText("Doriti sa stergeti angajatul de la linia "+ i +"?");

		if(j==2)
			confirm.setText("Doriti sa actualizati datele angajatului de la linia "+ i +"?");

		content.remove(confirm);
		content.add(confirm);
		confirm.setForeground(Color.red);
		confirm.setBounds(17, 280, 756, 250);
		content.repaint();

	}

	public  void infoBox(String infoMessage, String titleBar)
	{
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public void paint() {

		this.getContentPane().setBackground( new Color(252, 228, 201));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Administrator");
		setResizable(false);
		setSize(1000,680);
		setVisible(true);



	}


}
