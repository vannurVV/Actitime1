package com.crm.objectrepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericlibrary.ExcelUtility;

public class TaskListPage {
	//declaration
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewButton;
	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	private WebElement newCustomerButton;
	@FindBy(xpath = "//div[@class='customerNameDiv']/input[@placeholder='Enter Customer Name']")
	private WebElement enterCustomerNameTextField;
	@FindBy(xpath = "//div[@class='inputContainer']/textarea[@placeholder='Enter Customer Description']")
	private WebElement descriptionTextField;
	@FindBy(xpath = "//div[contains(text(),'Select Customer') and @class='emptySelection']")
	private WebElement selectCustomerDropDown;
	@FindBy(xpath = "//div[text()='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourCompany;
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomerButton;
	@FindBy(xpath = "//div[@class='topContainer']//div[@class='title']")
	private WebElement customerName;
	@FindBy(id="logoutLink")
	private WebElement logoutButton;
	ExcelUtility excel=new ExcelUtility();
	//initialization
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utilization
	public void clickOnAddNewButton() {
		addNewButton.click();
	}
	public void clickOnNewCustomerButton() {
		newCustomerButton.click();
	}
	public void enterTextInCustomerName() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Thread.sleep(2000);
		//String customerName = excel.getData("CreateCustomer", 1, 1);
		enterCustomerNameTextField.sendKeys("HDFC_006");
	}
	public void enterTextInDescription() throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(2000);
		//String description = excel.getData("CreateCustomer", 1, 2);
		descriptionTextField.sendKeys("BANKING PROJECT");
	}
	public void clickOnDropDown() throws InterruptedException {
		Thread.sleep(4000);
		selectCustomerDropDown.click();
	}
	public void clickOnOurCompany() throws InterruptedException {
		Thread.sleep(2000);
		ourCompany.click();
	}
	public void clickOnCreatCustomer() throws InterruptedException {
		Thread.sleep(2000);
		createCustomerButton.click();
	}
 public String verifyCustomerName() throws InterruptedException {
	 Thread.sleep(2000);
	return customerName.getText();
	 
 }
 public void clickOnLogoutButton() {
		logoutButton.click();
	}

}
