package com.crm.genericlibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.TaskListPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	protected static WebDriver sdriver;
	@BeforeClass
	public void openBrowser() {
		String browser="chrome";
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			sdriver=driver;
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			sdriver=driver;
		}

	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@BeforeMethod
	public void login() {
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage login=new LoginPage(driver);
		login.setLogin();
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		TaskListPage listpage=new TaskListPage(driver);
		listpage.clickOnLogoutButton();
	}

}


