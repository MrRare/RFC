package com.application;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.ListSelectionModel;









import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;












import java.util.*;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class GUI3 {

	private GUI2 g=null;
	//static List <String> array; 
	private final JDesktopPane desktopPane = new JDesktopPane();
	@SuppressWarnings("rawtypes")
	private  JList list;
	private ArrayList<String> arrayList;
	private Vector <String> vector;
	private final JButton btnMove = new JButton("move");
	private final JButton btnDel = new JButton("delete");
	private final JButton btnPDel = new JButton("parmanent \r\ndelete");
	private final JButton btnSelectAll = new JButton("select all");
	private final JButton btnBack = new JButton();
	protected final JScrollPane scrollPane = new JScrollPane();

	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public void back() {
		desktopPane.setVisible(false);
		g.panel.setVisible(true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setArrayList(){
		arrayList=new ArrayList();
		int arr[]=list.getSelectedIndices();
		for(int i=0;i<arr.length;i++)
			arrayList.add(vector.get(arr[i]));
	}
	
	
	public GUI3(Vector<String> vector,GUI2 g) {
		if(vector!=null){
		this.g=g;
		g.panel.setVisible(false);
		g.add(desktopPane);
		this.vector=vector;
		initialize( );
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
	
		scrollPane.setBounds(31, 50, 824, 442);
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
	        @Override
	        protected void configureScrollBarColors() {
	            this.thumbColor = Color.gray;
	            this.trackColor=Color.white;
	        }
			});
			scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
	        @Override
	        protected void configureScrollBarColors() {
	            this.thumbColor = Color.gray;
	            this.trackColor=Color.white;
	        }
			});
			
			
			
		desktopPane.add(scrollPane);
		list=new JList(vector);
		scrollPane.setViewportView(list);
		list.setBorder(UIManager.getBorder("DesktopIcon.border"));
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		list.setFont(new Font("Calibri", Font.PLAIN, 24));
		list.setSelectionBackground(Color.lightGray);
		list.setSelectionForeground(Color.black);
		
		
		list.addMouseListener( new MouseAdapter()
		{
		    public void mousePressed(MouseEvent e)
		    {
		        if ( SwingUtilities.isRightMouseButton(e) )
		        {
		            JList list = (JList)e.getSource();
		            int row = list.locationToIndex(e.getPoint());
		            list.setSelectedIndex(row);
		            PopUpDemo.s=(String) list.getSelectedValue();
		        }
		    }

		});
		list.addMouseListener(new PopClickListener());
		
			
		
		
		
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setArrayList();
			MyFile.fmove(arrayList);
			}
		});
		btnMove.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		btnMove.setBackground(Color.white);
		btnMove.setForeground(Color.gray);
		btnMove.setBorder(new LineBorder(Color.gray,2));
		btnMove.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnMove.setBackground(Color.white);
				btnMove.setForeground(Color.gray);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMove.setBackground(Color.gray);
				btnMove.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnMove.setBounds(21, 505, 112, 37);
		
		desktopPane.add(btnMove);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setArrayList();
			MyFile.del(arrayList);
			}
		});
		btnDel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		btnDel.setBackground(Color.white);
		btnDel.setForeground(Color.gray);
		btnDel.setBorder(new LineBorder(Color.gray,2));
		btnDel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnDel.setBackground(Color.white);
				btnDel.setForeground(Color.gray);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDel.setBackground(Color.gray);
				btnDel.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnDel.setBounds(230, 505, 112, 37);
		
		desktopPane.add(btnDel);
		btnPDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setArrayList();
			MyFile.pdel(arrayList);
			}
		});
		btnPDel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		btnPDel.setBackground(Color.white);
		btnPDel.setForeground(Color.gray);
		btnPDel.setBorder(new LineBorder(Color.gray,2));
		btnPDel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnPDel.setBackground(Color.white);
				btnPDel.setForeground(Color.gray);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPDel.setBackground(Color.gray);
				btnPDel.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnPDel.setBounds(440, 505, 230, 37);
		
		desktopPane.add(btnPDel);
		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [] arr=new int[vector.size()];
				for(int i=0;i<vector.size();i++)
					arr[i]=i;
				list.setSelectedIndices(arr);
					
				
				
			}
		});
		btnSelectAll.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		btnSelectAll.setBackground(Color.white);
		btnSelectAll.setForeground(Color.gray);
		btnSelectAll.setBorder(new LineBorder(Color.gray,2));
		btnSelectAll.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectAll.setBackground(Color.white);
				btnSelectAll.setForeground(Color.gray);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSelectAll.setBackground(Color.gray);
				btnSelectAll.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnSelectAll.setBounds(760, 505,130, 37);
		
		desktopPane.add(btnSelectAll);
		btnBack.setBounds(34, 10, 50, 35);
		btnBack.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		btnBack.setBackground(Color.white);
		btnBack.setForeground(Color.gray);
		btnBack.setBorder(null);
		BufferedImage img8 = null;
		try {
			img8 = ImageIO.read(new File("back.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dimg1 = img8.getScaledInstance(btnBack.getWidth(), btnBack.getHeight(),
		        Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon2 = new ImageIcon(dimg1);
		btnBack.setIcon(imageIcon2);
		btnBack.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBorder(new LineBorder(Color.gray,2));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		desktopPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
	}
}
