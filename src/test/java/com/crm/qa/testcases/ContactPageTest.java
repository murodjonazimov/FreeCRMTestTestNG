package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
//import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	// CalendarPage calendarPage;

	String sheetName = "contacts";

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initiization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		// calendarPage = new CalendarPage();
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

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		// [] dinamtion
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company,
			String nickname, String companyPosition, String suffix, String department, String supervisor,
			String assistant, String referredBy, String category, String status, String phone, String mobile,
			String home_phone, String fax, String email, String im_id, String im_netowrk, String skype_id,
			String source, String identifier) {

		homePage.clickOnNewContactLink();
		// contactsPage.createNewContact("Miss", "Laura", "Lex", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company, nickname, companyPosition, suffix,
				department, supervisor, assistant, referredBy, category, status, phone, mobile, home_phone, fax, email,
				im_id, im_netowrk, skype_id, source, identifier);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
