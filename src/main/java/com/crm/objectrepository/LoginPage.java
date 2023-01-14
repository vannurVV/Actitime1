package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(id = "username")
	private WebElement usernameTextBox;
	@FindBy(name = "pwd")
	private WebElement pwdTextBox;
	@FindBy(xpath = "//div[text()='Login ']")
	private WebElement loginButton;
	//initialize
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void setLogin() {
		usernameTextBox.sendKeys("admin");
		pwdTextBox.sendKeys("manager");
		loginButton.click();
	}
}
