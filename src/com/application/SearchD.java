package com.application;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;





public class SearchD {

	private static Map<String, Vector<String>> map=new HashMap<String, Vector<String>>();
	private static Vector<String> vector=null; // just to prevent any recreation of 
	//private static Loading load=null;	 	   // List while dealing with values. 
	
	/*static {
		load=new Loading();
		load.setVisible(true);
	}*/
	
	/*public SearchD(String Dir, GUI2 g){
		g.setVisible(false);
		map.clear();
		search(Dir);
		g.setVisible(true);
		load.dispose();
		
		if(!map.isEmpty()){
			GUI2.map=map;
			g.listM();			
		}
		else
			JOptionPane.showMessageDialog(null, "Wrong Directory!!");
	}*/
	
	public SearchD(){
		
		//new GUI2(map).setVisible(true);
	}
    
    
    static Map<String, Vector<String>> call(String Dir){
        
        search(Dir);
        
        if(map!=null)
	        return map;
	        else{
	        return null;
	        }
	
    }

	


	public static void search(String Dir) {
		try{
			String[] dirFiles=new File(Dir).list();
			for(String dirFile:dirFiles){
				File file=new File(Dir+"/"+dirFile);
				if(file.isFile()){
					mapping(file.getName(),file.getAbsolutePath());
				}
				else if(file.isDirectory())
					search(file.getAbsolutePath());
			}
			
		} catch (NullPointerException e){
		} catch(Exception e){
			e.printStackTrace();
		}		
	}

	public static void mapping(String name, String path) throws IOException{
		if(map.containsKey(name)){
			vector=map.get(name);
			if(Utility.contentEquals(new File(path),new File(vector.get(0))))
				vector.add(path);
			else{
				String newName=name+" I";
				mapping(newName,path);
			}
		}
		else{
			vector=new Vector<String>();
			vector.add(path);
			map.put(name, vector);
		}
	}	
}
