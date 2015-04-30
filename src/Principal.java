import java.lang.reflect.Constructor;
import java.util.Date;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;



@SuppressWarnings("unused")
public class Principal  {
	//int nCase=3;// terbuie citit de la tastatura;
	//nr clienti de la tastatura;
	//interval de functionare;
	//timp minim si maxim de procesare al clientului;
	
JTextArea text;

	public  Principal(){

	//	 initComponents();
   
    	try{
   
    		System.out.println("Se incepe");
    		Magazin Oncos = new Magazin(3,20,12, "Oncos" );
    		Oncos.start();
    		
    	} catch (Exception ex) {
    		System.out.println(ex.toString());
    	}
    	
    	}
	public static void main(String[] args){
		new Principal();
//	start();
	}

	/*

public static void start(){
		JFrame frame = new JFrame("Tema 2");
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JTextArea text = new JTextArea(10,60);
//text.addActionListener(this);
		JScrollPane scroller = new JScrollPane(text);
		text.setLineWrap(true);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    JButton buton1 = new JButton("Simulare");
		buton1.addActionListener((ActionListener) new Principal());
		panel.add(scroller);
	    panel1.setBackground(Color.red);
	    panel1.add(buton1);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(BorderLayout.NORTH,panel);
	    frame.getContentPane().add(BorderLayout.SOUTH,panel1);
	    frame.setSize(700,300);
	    frame.setVisible(true); 
	
	}
	
	class InfoClase implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JButton buton1 = new JButton("Simulare");
			buton1.addActionListener((ActionListener) new Principal());			
		}
		
	} 
*/
}
   