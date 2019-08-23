package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'User: Murodjon Azimov')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/a")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksList;
	
	@FindBy(xpath = "//a[contains(text(),'Companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath = "//a[contains(text(),'Calendar')]")
	WebElement calendarLink;

	@FindBy(xpath = "//a[contains(text(),'Cases')]")
	WebElement casesLink;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink() {
		contactLink.click();
		return new ContactsPage();
	}
	
	public ContactsPage clickOnNewContactsLink() {
		newContactLink.click();
		return new ContactsPage();
	}
	public NewContactsPage moveToContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).perform();
		return new NewContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksLink clickTasksLink() {
		tasksList.click();
		return new TasksLink();
	}
	
	public CompaniesPage clickOnCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public CalendarPage clickOnCalindarLink() {
		calendarLink.click();
		return new CalendarPage();
	}
	
	public CasesPage clickOnCasesLink() {
		casesLink.click();
		return new CasesPage();
	}
	
}
