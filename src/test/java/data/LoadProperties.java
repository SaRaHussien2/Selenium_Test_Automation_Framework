package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// this class read data from properties file from the folder
public class LoadProperties {
	public static Properties userData = 
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userData.properties");

	//Load Sauce Labs AccountSata
	public static Properties saucelabData= loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\SauceLabUserData.properties");

	
	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		//Stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);

		} catch (FileNotFoundException e) {
			System.out.println("Error occured"+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error occured"+ e.getMessage());
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("Error occured"+ e.getMessage());
			e.printStackTrace();
		}
		return pro;

	}


}
