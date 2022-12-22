package com.application;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import static java.nio.file.StandardCopyOption.*;

import com.sun.jna.platform.FileUtils;
import  com.sun.jna.win32.StdCallLibrary;

@SuppressWarnings("unused")
public class MyFile{
    private static Path p;
    private static JFileChooser fc=new JFileChooser();
    
    static void pdel(ArrayList<String> l){
        try{
        	for(String s:l){
            p=Paths.get(s);
            if(Files.deleteIfExists(p))
            	JOptionPane.showMessageDialog(null, "Files Deleted Permanently.");
            else
            	JOptionPane.showMessageDialog(null, "ERROR! plz try later.");
        	}
        }catch(IOException e){System.err.println(e);}
    }
  
    static void del(ArrayList<String> l){
    	for(String s:l){
        File file = new File(s);
        FileUtils fu = FileUtils.getInstance();
        try{
            if(fu.hasTrash()){
                fu.moveToTrash(new File[]{file});
                JOptionPane.showMessageDialog(null, "Files Deleted.");
            }else{
                JOptionPane.showMessageDialog(null, "ERROR! plz try again.");
            }
        }catch(IOException | NoClassDefFoundError e){e.printStackTrace();}
    	}
    }
    
    static void fmove(ArrayList<String> l){
    	for(String s:l){
            try{
            	String saveto=null;
				if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
					saveto=fc.getSelectedFile().getAbsolutePath();
				}
                p=Paths.get(s);                
                Files.move(p,Paths.get(saveto),REPLACE_EXISTING);
                if(p.isAbsolute())
                	JOptionPane.showMessageDialog(null, "FILE MOVED!");
                else
                	JOptionPane.showMessageDialog(null, "ERROR! plz try later");
            }catch(IOException e){System.err.println(e);}    		
    	}
    }
      
}