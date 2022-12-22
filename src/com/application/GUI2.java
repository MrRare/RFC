package com.application;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException; 
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;






@SuppressWarnings("serial")
public class GUI2 extends JFrame {

	private JPanel contentPane;
	protected final JPanel panel = new JPanel();
	private final JLabel l2 = new JLabel();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu fil = new JMenu("Filter");
	private final JMenuItem sort = new JMenuItem("sort");
	private final JLabel title = new JLabel("RFC");
	private final JLabel quit = new JLabel("X");
	private DefaultListModel<String> listmodel=new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listmodel);
	protected final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnOpen = new JButton("OPEN");
	protected static Map<String, Vector<String>> map=null;
	private final JButton btnBack = new JButton();
	
	Boolean b=false;
	int xx,xy;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param map 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 frame = new GUI2(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	public GUI2(Map<String, Vector<String>> map) {
		GUI2.map=map;
		initGUI();
		listM();
	}
	public void back() {
		dispose();
		new GUI1().setVisible(true);
		
	}
	void listM(){
		if(map!=null){
			listmodel.clear();
			for(String s:map.keySet()){
				
				if(map.get(s).size()>1){
					listmodel.addElement(s+"		("+map.get(s).size()+")");
					l2.setText(Integer.toString(listmodel.size()));
				}
				
			}
		}
		
	}
	void callSearch2(Vector<String> v){
		new GUI3(v,this);
	}
	
	private void initGUI() {

		
		setUndecorated(true);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 80, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);

		
		
		menuBar.setBackground(Color.white);
		menuBar.setBorder(null);
		fil.add(sort);
		menuBar.add(fil);
		setJMenuBar(menuBar);
		
		
		title.setBounds(400,13,170,100);
		title.setForeground(Color.gray);
		title.setFont(new Font("CHEESEBURGA", Font.PLAIN, 60));
		panel.add(title);
			
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		
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
			scrollPane.setBorder(new LineBorder(Color.black,1));
			scrollPane.setBounds(15, 100, 843, 400);
			panel.add(scrollPane);
		
		list.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		list.setFont(new Font("Calibri", Font.PLAIN, 30));
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setSelectionBackground(Color.lightGray);
		list.setSelectionForeground(Color.black);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		BufferedImage img4 = null;
		try {
			img4 = ImageIO.read(new File("icon1.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dim = img4.getScaledInstance(54, 38,
		        Image.SCALE_SMOOTH);
		
	
		ImageIcon imageIcon1 = new ImageIcon(dim);
		list.setCellRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		        label.setIcon(imageIcon1);
		        return label;
		    }
		});
		scrollPane.setViewportView(list);
		panel.add(scrollPane);
		
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try{
						String s1 = list.getSelectedValue();
						Vector<String> v=map.get(s1.substring(0,s1.indexOf("		(")));
						callSearch2(v);
					}
					catch(ArrayIndexOutOfBoundsException aiobe){
						JOptionPane.showMessageDialog(null, "Select a File");
						
					}
					catch (NullPointerException e2) {
						JOptionPane.showMessageDialog(null, "Select a File");
						
					}
			}});
		btnOpen.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		btnOpen.setBounds(753, 507, 112, 37);
		btnOpen.setBackground(Color.white);
		btnOpen.setForeground(Color.gray);
		btnOpen.setBorder(new LineBorder(Color.gray,2));
		btnOpen.addMouseListener(new MouseListener() {
			
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
				btnOpen.setBackground(Color.white);
				btnOpen.setForeground(Color.gray);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOpen.setBackground(Color.gray);
				btnOpen.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnBack.setBounds(34, 55, 50, 35);
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
		
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		
		panel.add(btnOpen);
		quit.setForeground(Color.black);
		quit.setFont(new Font("algeberian",Font.PLAIN,18));
		quit.setBounds(850, 10, 37, 27);
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
