package com.MyStore.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {Properties pro;

public ReadConfig() //thisis cunstructor automatically call with object
{

	try {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\config.properties");
		pro = new Properties();
		pro.load(fis); // properties class will load the .properties file at runtime if it's not
						// present then we have try n catch blk

		} catch (Exception e) {
		System.out.println("Exception is " + e.getMessage());
		}
}

public String getApplicationURL() {
	String baseURL = pro.getProperty("url");
	return baseURL;
}

public String getUsername() {
	String usr = pro.getProperty("username");
	return usr;
}

public String getPassword() {
	String pwd = pro.getProperty("password");
	return pwd;
}

public String getBrowserName() {
	String browserName = pro.getProperty("browser");
	return browserName;
}

public String getChromePath() {
	String cp = pro.getProperty("chromepath");
	return cp;
}

public String getFirefoxPath() {
	String fx = pro.getProperty("firepath");
	return fx;
}

public String getIEPath() {
	String ie = pro.getProperty("iepath");
	return ie;
}}
