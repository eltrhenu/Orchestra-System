package filepackage;

import java.util.*;
import java.io.*;



public class FileIOManager {
	
	public static List<String> getLines(String fileName) {
		
		List<String> temp = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) { 
				temp.add(line);
				line = reader.readLine();
			}
			reader.close();
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
		return temp;
	}
	
	public static void printLines(String fileName, List<String> lines) {
		try {
			
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fw);
            for(String line : lines) {
                 out.write(line);
                 out.write("\n");
            }
            out.flush();
            out.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
}
