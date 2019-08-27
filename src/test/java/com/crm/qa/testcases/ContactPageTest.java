package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	CalendarPage calendarPage;
	

	public ContactPageTest() {
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
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();

	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLebel(), "contact label is missing on the page");
	}

	@Test(priority = 2)
	public void selectSingleContactsLink() {
		contactsPage.selectContactsByName("Iryna Azimova");
	}

	@Test(priority = 3)
	public void selectMultipleContactsLink() {
		contactsPage.selectContactsByName("Iryna Azimova");
		contactsPage.selectContactsByName("Micheal Jacson");
	}
	
	@Test
	public void validateCreateNewContact() {
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
