package com.crm.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericlibrary.BaseClass;
import com.crm.objectrepository.Enter_Time_TrackPage;
import com.crm.objectrepository.TaskListPage;

@Listeners(com.crm.genericlibrary.ListenerImplementation.class)
public class CreateCustomerTest extends BaseClass {

	@Test
	public void createCustomerTest() throws InterruptedException, EncryptedDocumentException, IOException {
		//GetData excel=new GetData();
		//String expectedCustomerName = excel.getData("CreateCustomer", 1, 1);
		Enter_Time_TrackPage timetrack=new Enter_Time_TrackPage(driver);
		timetrack.clinkOnTasksButton();
		TaskListPage taskList=new TaskListPage(driver);
		taskList.clickOnAddNewButton();
		taskList.clickOnNewCustomerButton();
		taskList.enterTextInCustomerName();
		taskList.enterTextInDescription();
		taskList.clickOnDropDown();
		taskList.clickOnOurCompany();
		taskList.clickOnCreatCustomer();
		String actualCustomerName = taskList.verifyCustomerName();
		Reporter.log(actualCustomerName,true);
		Assert.assertEquals(actualCustomerName, "HDFC_006");
		Reporter.log("TestCaseIsPass",true);
		//excel.setData("CreateCustomer", 1, 3, "pass");
		Thread.sleep(2000);

	}
}
