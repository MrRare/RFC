package com.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Loading extends JInternalFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Loading() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 80, 900, 600);
		JPanel contentPane = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g){

			       ImageIcon i=new ImageIcon("loading.gif");
			        
			        g.drawImage(i.getImage(),30,0,this);
			        /*g.setColor(Color.orange);
			     g.fillOval(50,50,100,100);*/

			    }
		};;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.white);
		add(contentPane);
		
		
		contentPane.setBounds(200, 80, 900, 600);
		contentPane.setBackground(Color.white);
		
		
	
		

	}

}
