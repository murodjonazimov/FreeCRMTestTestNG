package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.util.TestUtil;

public class NewContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	CalendarPage calendarPage;
	NewContactsPage newContact;
	
	public NewContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initiization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		calendarPage = new CalendarPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void clickOnNewContactLink() {
		testUtil.switchToFrame();
		homePage.moveToContactsLink();
		homePage.clickOnNewContactsLink();
	}
	@Test
	public void fillUpTheInformation() {
		testUtil.switchToFrame();
		homePage.moveToContactsLink();
		homePage.clickOnNewContactsLink();
		testUtil.switchToFrame();
		newContact.typeFirstName();
		newContact.tybeLastName();
		newContact.typeMobileNumber();
		newContact.clickOnSaveBtn();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
