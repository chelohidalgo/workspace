package com.merchant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.merchant.util.Constants;

public class File {

	public static BufferedReader br;

	public static void getFile() throws Exception {
		StringBuilder filename = new StringBuilder();
		try {
			filename.append(Constants.PATH_FILE).append(Constants.FILENAME);
			br = new BufferedReader(new FileReader(filename.toString()));
		} catch (IOException ex) {
			throw new Exception("File not founded or corrupted");
		} catch (Exception e) {
			throw new Exception("Sorry, we have troubles with the application, please try later...");
		}
	}

	public static CurrentLine getCurrentLine() throws Exception {
		try {
			String readLine = br.readLine();
			if (readLine != null) {
				String[] dataLine = readLine.split(Constants.IS_SEPARATOR);
				if (isInputLineLenghtMoreThanOne(dataLine)) {
					return new CurrentLine(dataLine[Constants.VALUE_ZERO], dataLine[Constants.VALUE_ONE]);
				} else {
					return new CurrentLine(dataLine[Constants.VALUE_ZERO], dataLine[Constants.VALUE_ZERO]);
				}
			}
			return null;
		} catch (IOException e) {
			throw new Exception("Sorry, we have troubles reading the file, please try later...");
		}
	}

	private static boolean isInputLineLenghtMoreThanOne(String[] dataLine) {
		return dataLine != null && dataLine.length > Constants.VALUE_ONE;
	}

	public static void close() throws IOException {
		br.close();
	}

}
