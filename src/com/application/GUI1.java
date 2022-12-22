package com.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Vector;







import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;






public class GUI1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	static JPanel panel;
	private final JMenuBar menuBar = new JMenuBar();
	private static JTextField searchField;
	private final JMenu sett = new JMenu();
	private final JLabel title = new JLabel("vary");
	private final JMenuItem bg = new JMenuItem("change wallpaper");
	private final JLabel quit = new JLabel("X");
	static GUI1 g = new GUI1();
	 
	


	
	Boolean b=false;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 frame = new GUI1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	  void callSearch(String path){
		 
		
		Map<String, Vector<String>> map=SearchD.call(path);
		if(map.isEmpty()){
			JOptionPane.showMessageDialog(null, "Wrong Directory");
		}
		else{
		dispose();
		new GUI2(map).setVisible(true);
		}
		
	}
	
	
	public GUI1() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 80, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		
		
		menuBar.setBackground(Color.white);
		menuBar.setBorder(null);BufferedImage img5 = null;
		sett.setBounds(0, 0, 27, 27);
		try {
			img5 = ImageIO.read(new File("setting.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dimg1 = img5.getScaledInstance(sett.getWidth(), sett.getHeight(),
		        Image.SCALE_SMOOTH);
		
	
		ImageIcon imageIcon1 = new ImageIcon(dimg1);
		sett.setIcon(imageIcon1);
		sett.add(bg);
		menuBar.add(sett);
		setJMenuBar(menuBar);
		
		sett.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Coming soon");
			}
		});
		
		title.setBounds(300,0,300,300);
		title.setForeground(Color.cyan);
		title.setFont(new Font("CHEESEBURGA", Font.PLAIN, 100));
		
	        
		JLabel la = new JLabel(){
			  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
		 
		la.setBorder(BorderFactory.createEmptyBorder());
		la.setBounds(100, 305, 54, 38);
		
		BufferedImage img2 = null;
		try {
			img2 = ImageIO.read(new File("search.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dimg = img2.getScaledInstance(la.getWidth()-20, la.getHeight()-10,
		        Image.SCALE_SMOOTH);
		
	
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		la.setIcon(imageIcon);
		la.grabFocus();
		la.setBackground(Color.white);
		la.setVisible(true);
	    
		 JLabel la2 = new JLabel(){
			  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
		 
		la2.setBorder(BorderFactory.createEmptyBorder());
		la2.setBounds(630, 305, 54, 38);
		
		BufferedImage img9 = null;
		try {
			img9 = ImageIO.read(new File("fileO.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dimg3 = img9.getScaledInstance(la2.getWidth()-20, la2.getHeight()-10,
		        Image.SCALE_SMOOTH);
		
	
		ImageIcon imageIcon4 = new ImageIcon(dimg3);
		
		la2.setIcon(imageIcon4);
		la2.grabFocus();
		la2.setBackground(Color.cyan);
		la2.setVisible(true);
		
		
		
		 searchField = new JTextField(){
			  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};

		searchField.setFont(new Font("Calibri", Font.PLAIN, 22));
		searchField.setForeground(Color.gray);
		searchField.setBackground(Color.white);
		searchField.setBounds(100, 300, 570, 44);
		searchField.setText("Enter directory name");
		searchField.setFocusable(false);
		searchField.setHorizontalAlignment(JTextField.CENTER);
		
		 panel = new JPanel(){
			  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			    public void paintComponent(Graphics g) 
			    {
			        super.paintComponent(g);
			        ImageIcon img = new ImageIcon("thor7.jpg");
			        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			    }
		};
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		panel.add(title);
		panel.add(la);
		panel.add(la2);
		panel.add(searchField);
		
		
		
		searchField.addMouseListener(new MouseListener() {
			
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
				if(b!=true){
				searchField.setText("Enter directory name");
				searchField.setForeground(Color.gray);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(b!=true){
				searchField.setText(null);	
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				searchField.setFocusable(true);
				searchField.setText(null);
				b=true;
				searchField.setForeground(Color.black);
				
			}
		});
	    
	    searchField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String s=null;
	    		
	    		if((s=searchField.getText()).equals(null) || searchField.getText().equals("")){
	    			JOptionPane.showMessageDialog(null, "TextField is empty");	
	    		}
	    		
	    		else{
	    		
	    			callSearch(s);	
	    		}
				
			}
		});
	    la.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String s=null;
	    		
	    		if((s=searchField.getText()).equals(null) || searchField.getText().equals("")){
	    			JOptionPane.showMessageDialog(null, "TextField is empty");	
	    		}
	    		
	    		else{
	    		
	    			callSearch(s);	
	    		}
	    		}
		});
	    la2.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		searchField.setText(null);
	    		JFileChooser jc = new JFileChooser();
	    		jc.setCurrentDirectory(new File("user.home"));
	    	    jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    		int re = jc.showSaveDialog(null);
	    		
	    		if(re==JFileChooser.APPROVE_OPTION){
	    			String s = null;	
	    			try{
	    			s=jc.getSelectedFile().getAbsoluteFile().toString();
	    			}
	    			catch(Exception e1){
	    				e1.printStackTrace();
	    			}
	    			searchField.setText(s);
	    			
	    			callSearch(s);
	    			
	    		}
	    	}
	    	});
	   
	     JLabel label = new JLabel("");
	        
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					 xx = e.getX();
				     xy = e.getY();
				}
			});
			label.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent arg0) {
					
					int x = arg0.getXOnScreen();
		            int y = arg0.getYOnScreen();
		            GUI1.this.setLocation(x - xx, y - xy);  
				}
			});
			quit.setForeground(Color.black);
			quit.setFont(new Font("algeberian",Font.PLAIN,18));
			quit.setBounds(806, 10, 37, 27);
			panel.add(quit);
			quitClick();
		}
		void quitClick(){
			quit.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					System.exit(0);
				}
				
			});
		}
}
