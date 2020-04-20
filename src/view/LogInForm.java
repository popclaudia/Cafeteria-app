package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogInForm extends JFrame {

	JLabel user_label, password_label, message,im;
	JTextField userName_text;
	JPasswordField password_text;
	JButton submit, cancel;
	ImageIcon image= new ImageIcon("download.png");

	public LogInForm() {

		user_label = new JLabel();
		im=new JLabel(image);
		userName_text = new JTextField();
		password_label = new JLabel();
		password_text = new JPasswordField();
		message = new JLabel();
		submit = new JButton("LOG IN");

		user_label.setText("User Name :");
		password_label.setText("Password :");
		message.setText("Datele introduse sunt gresite. Incercati din nou!");

		this.setLayout(null);

		this.add(user_label);
		this.add(userName_text);
		this.add(password_text);
		this.add(password_label);
		this.add(submit);
		this.add(im);

		submit.setBackground(new Color(85, 27, 20));
		submit.setForeground(new Color(255, 255, 255));

		user_label.setBounds(70,90,90,60);
		password_label.setBounds(70,130,90,60);
		userName_text.setBounds(170,105,140,25);
		password_text.setBounds(170,145,140,25);
		submit.setBounds(130,260,100,30);
		im.setBounds(135,5,120,80);

		this.getContentPane().setBackground( new Color(252, 228, 201));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Please Login Here !");
		setSize(400,400);
		setResizable(false);
		setVisible(true);
	}

	public String getuser(){
		return userName_text.getText();
	}

	public String getpass(){
		return password_text.getText();
	}

	public void loginListener(ActionListener m) {
		submit.addActionListener(m);
	}

	public void showMessage() {
		message.setBounds(60,300,400,30);
		message.setForeground(Color.red);
		this.add(message);
		userName_text.setText("");
		password_text.setText("");
		this.repaint();
	}


}
