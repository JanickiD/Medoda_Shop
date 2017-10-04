package reaktor;

import java.awt.event.*;
import javax.swing.*;

public class App4 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("App4");										//guziki + ramka
		JButton btn1 = new JButton("Wypisz");
		JButton btn2 = new JButton("Wyjdz");
		
		JTextField tf_imie = new JTextField();									//pola tekstowe
		JTextField tf_nazwisko = new JTextField();
		JTextField tf_stanowisko = new JTextField();
		JTextField tf_mail = new JTextField();
		JTextArea ta = new JTextArea();
		
		JLabel lbl_imie = new JLabel("imiê");									//etykietki
		JLabel lbl_nazwisko = new JLabel("nazwisko");
		JLabel lbl_stanowisko = new JLabel("stanowisko");
		JLabel lbl_mail = new JLabel("e-mail");
		JLabel lbl_prog = new JLabel("Jakie znasz jêzyki programowania?");
		JLabel lbl_ang = new JLabel("Wybierz poziom jêzyka angielskiego?");
		JLabel lbl_kurs = new JLabel("Wybierz kurs programowania?");
		
		JCheckBox check1 = new JCheckBox("Java");								//checkobxy
		JCheckBox check2 = new JCheckBox("Python");
		JCheckBox check3 = new JCheckBox("inne");
		
		ButtonGroup group = new ButtonGroup();									//radio button group
		JRadioButton rb1 = new JRadioButton("podstawowy", false);
		group.add(rb1);
		JRadioButton rb2 = new JRadioButton("œrednio-zaawaansowany", false);
		group.add(rb2);
		JRadioButton rb3 = new JRadioButton("zaawaansowany", false);
		group.add(rb3);
		
		String lista[] = {"","Back-end Developer", "Front-end Developer"};		//lista combo
		JComboBox cb = new JComboBox(lista);
		
		lbl_imie.setBounds(20, 50, 100, 20);									//rozmiary lewa strona
		tf_imie.setBounds(20, 100, 100, 20);
		lbl_nazwisko.setBounds(20, 150, 100, 20);
		tf_nazwisko.setBounds(20, 200, 100, 20);
		lbl_stanowisko.setBounds(20, 250, 100, 20);
		tf_stanowisko.setBounds(20, 300, 100, 20);
		lbl_mail.setBounds(20, 350, 100, 20);
		tf_mail.setBounds(20, 400, 200, 20);
		btn1.setBounds(20, 500, 100, 20);
		btn2.setBounds(150, 500, 100, 20);
	
		lbl_prog.setBounds(300, 50, 250, 20);									//rozmiary œrodek
		check1.setBounds(300, 100, 250, 20);
		check2.setBounds(300, 125, 250, 20);
		check3.setBounds(300, 150, 250, 20);
		
		lbl_ang.setBounds(300, 200, 250, 20);
		rb1.setBounds(300, 250, 250, 20);
		rb2.setBounds(300, 275, 250, 20);
		rb3.setBounds(300, 300, 250, 20);
		
		lbl_kurs.setBounds(300, 350, 250, 20);
		cb.setBounds(300, 400, 250, 20);
		
		ta.setBounds(600, 50, 350, 200);										//rozmiar pole tekstowe

		btn1.addActionListener(new ActionListener() {							//funkcje guzika 1
			public void actionPerformed(ActionEvent e) {
				
				String imie = tf_imie.getText();
				String nazwisko = tf_nazwisko.getText();
				String stanowisko = tf_stanowisko.getText();
				String mail = tf_mail.getText();
				
				String c1 = "";													//checkboxy
				
				if(check1.isSelected()){
					c1 = c1 + check1.getText()+": tak" +"\n";
				}else {
					c1 = c1 + check1.getText()+": nie" +"\n";
				}
		
				if(check2.isSelected()){
					c1 = c1 + check2.getText()+": tak" +"\n";
				}else {
					c1 = c1 + check2.getText()+": nie" +"\n";
				}
					
				if(check3.isSelected()){
					c1 = c1 + check3.getText()+": tak" +"\n";
				}else {
					c1 = c1 + check3.getText()+": nie" +"\n";
				}
				
				String c2 = "";													//radio buttons
				if(rb1.isSelected()){
					c2 = rb1.getText();
				}
				
				if(rb2.isSelected()){
					c2 = rb2.getText();
				}
				
				if(rb3.isSelected()){
					c2 = rb3.getText();
				}
				
				String c3 = "";													//combo list
				c3 = cb.getSelectedItem() +"\n";
				
			
				ta.setText("Dane kontaktowe:"+"\n"+imie+ " "+nazwisko+" ("+stanowisko+") "+mail+"\n"+"\n"+
				"Informacje zawodowe:"+"\n"+c1+"Angielski: "+c2 +"\n"+"\n"+"Wybrany kurs:"+"\n"+c3);
				}
			});
				
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		
		frame.add(tf_imie); frame.add(tf_nazwisko); frame.add(tf_stanowisko);frame.add(tf_mail);
		frame.add(ta);
		frame.add(btn1);frame.add(btn2);
		frame.add(lbl_imie);frame.add(lbl_nazwisko);frame.add(lbl_stanowisko);frame.add(lbl_mail);
		frame.add(lbl_prog);frame.add(lbl_ang);frame.add(lbl_kurs);
		frame.add(check1);frame.add(check2);frame.add(check3);
		frame.add(rb1);frame.add(rb2);frame.add(rb3);
		frame.add(cb);
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}

