package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Enter_Time_TrackPage {
	//declaration
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement tasksButton;
	
	//initialization
	public Enter_Time_TrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void clinkOnTasksButton() {
		tasksButton.click();
	}
	
}
