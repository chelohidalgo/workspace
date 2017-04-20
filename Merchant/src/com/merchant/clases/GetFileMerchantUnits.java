package com.merchant.clases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class GetFileMerchantUnits {
	
	private static final String FILENAME = "D:/WorkspaceGIT/workspace/Merchant/resources/units.txt";

	public static void main(String[] args) {
		try {
			getFile();
			//System.out.println(getFile());
			//para cada string mando a convertir lo que ya tengo hecho
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

	}

	private static void getFileLetterByLetter() throws Exception {
		FileInputStream is = null;
		try {
			is = new FileInputStream("D:/WorkspaceGIT/workspace/Merchant/resources/units.txt");
			int size = is.available();

			for (int i = 0; i < size; i++) {
				System.out.print((char)is.read() + "  ");
			}
			is.close();
		} catch (IOException ex) {
			throw new Exception("File not founded");
		} 
	}
	
	private static void getFile() throws Exception {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			
			//br = new BufferedReader(new FileReader(FILENAME));
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				//return sCurrentLine;
			}
			br.close();
			fr.close();
		} catch (IOException ex) {
			throw new Exception("File not founded");
		} catch (Exception e) {
			throw new Exception("Sorry, we have troubles with the application, please try later...");
		}
		//return null;
	}
	
	private static String getLine(BufferedReader br){
		String sCurrentLine = null;
		try {
			sCurrentLine = br.readLine();
			if(sCurrentLine != null)
				return getLine(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sCurrentLine;
	}
	
}
