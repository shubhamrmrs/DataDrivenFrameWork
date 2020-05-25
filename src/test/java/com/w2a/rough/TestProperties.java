package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("user.dir"));
		Properties config = new Properties();
		Properties OR = new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);

		fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);

		System.out.println(config.getProperty("browser"));
		
		//driver.FindElement(By.cssSelector(OR.getProperty(\"BMloginButton\"))).click();
		System.out.println(OR.getProperty("BMloginButton"));


		
	}

}
