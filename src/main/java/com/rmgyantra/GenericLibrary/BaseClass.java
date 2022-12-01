package com.rmgyantra.GenericLibrary;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This class contains basic configuration automation for common
 * functionalities like connection to database,launch the browser etc
 * 
 * @author Pawan
 *
 */
public class BaseClass {
	public DatabaseUtility dUtil=new DatabaseUtility();
	
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dUtil.connectToDB();
		Reporter.log("--Database Connection Succeeful--",true);
	}
	
		@AfterSuite
	public void asConfig() throws SQLException
	{
		dUtil.closeDB();
		Reporter.log("--Database close successfull--",true);
	}
}
