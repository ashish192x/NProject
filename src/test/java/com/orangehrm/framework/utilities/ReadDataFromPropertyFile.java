package com.orangehrm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	


	public static Properties readProperties(String filepath) {
		FileInputStream fis=null;
		Properties prop = null;
		try {
			fis = new FileInputStream(filepath); 
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
