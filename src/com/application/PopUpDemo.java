package com.application;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.textEditor.*;

class PopUpDemo extends JPopupMenu {
	static String s=null;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public PopUpDemo() {
        anItem = new JMenuItem("Open");
        anItem.setBackground(Color.LIGHT_GRAY);
        anItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TextEditor(s,true).setVisible(true);
				
			}
		});
        		
        	
        add(anItem);
    }
}