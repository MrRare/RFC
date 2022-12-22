package com.textEditor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;

public class TextEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String filepath;
	private final JPanel panel = new JPanel();
	private final JTextArea textArea = new JTextArea();
	private final JMenuBar menuBar = new JMenuBar();
	private final JFileChooser fc = new JFileChooser();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnView = new JMenu("View");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmSaveAs = new JMenuItem("Save As");
	private final JMenuItem mntmPrint = new JMenuItem("Print");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmChangeFontSize = new JMenuItem("Change Font Size");
	private final JCheckBoxMenuItem chkWordWrap = new JCheckBoxMenuItem("Word Wrap");
	private final JMenuItem mntmNew = new JMenuItem("New");
	private final JMenuItem mntmOpen = new JMenuItem("Open");
	private final JMenuItem mntmViewHelp = new JMenuItem("View Help");
	private final JMenuItem mntmAbout = new JMenuItem("About");
	private final JMenuItem mntmSave = new JMenuItem("Save");

	/**
	 * Launch the application.
	 */
	
	public TextEditor(String filepath, boolean writable){
		this.filepath=filepath;
		setTitle(filepath);
		textArea.setEditable(writable);
		readFile();
		initGUI();
	}
	
	private void readFile(){
		try (BufferedReader br=new BufferedReader(new FileReader(filepath))){
			String str;
			while((str=br.readLine())!=null){
				textArea.setText(textArea.getText()+"\n"+str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void openFile(String filepath){
		this.filepath=filepath;
		try(FileReader fr=new FileReader(filepath)){
			textArea.read(fr, null);
			setTitle(filepath);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void saveFileAs(){
		if(fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
			try(FileWriter fw=new FileWriter(fc.getSelectedFile().getAbsolutePath())){
				textArea.write(fw);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditor frame = new TextEditor();
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
	public TextEditor() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(880, 100, 450, 520);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Open A New File?");
				if(flag==0){
					textArea.setText(null);
				}
			}
		});
		
		mnFile.add(mntmNew);
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					openFile(fc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		mnFile.add(mntmOpen);
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textArea.getText().equals(null))
					saveFileAs();
				else
					JOptionPane.showMessageDialog(null, "Cant Save Empty File");
			}
		});
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textArea.getText().equals(null)){
					if(filepath.equals(null))
						saveFileAs();
					else{
						try (FileWriter fw = new FileWriter(filepath)){
							textArea.write(fw);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}					
				}
				else
					JOptionPane.showMessageDialog(null, "Cant Save Empty File");
			}
		});
		
		mnFile.add(mntmSave);
		
		mnFile.add(mntmSaveAs);
		
		mnFile.addSeparator();
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
				
		mnFile.add(mntmPrint);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnView);
		chkWordWrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setWrapStyleWord(chkWordWrap.isSelected());
			}
		});
		
		mnView.add(chkWordWrap);
		mntmChangeFontSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size=Integer.parseInt(JOptionPane.showInputDialog("Enter The Size of Text You Want."));
				Font font=textArea.getFont();
				textArea.setFont(new Font(font.getName(), font.getStyle(), size));
			}
		});
		
		mnView.add(mntmChangeFontSize);
		
		menuBar.add(mnHelp);
		
		mnHelp.add(mntmViewHelp);
		
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel.add(textArea);
	}
}
