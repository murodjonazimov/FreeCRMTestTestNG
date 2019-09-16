package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(name = "nickname")
	WebElement nickname;

	@FindBy(name = "company_position")
	WebElement companyPosition;

	@FindBy(name = "department")
	WebElement department;

	@FindBy(name = "contact_lookup_sup")
	WebElement supervisor;

	@FindBy(name = "contact_lookup_ass")
	WebElement assistant;

	@FindBy(name = "contact_lookup_ref")
	WebElement referredBy;

	@FindBy(name = "phone")
	WebElement phone;

	@FindBy(name = "mobile")
	WebElement mobile;

	@FindBy(name = "home_phone")
	WebElement home_phone;

	@FindBy(name = "fax")
	WebElement fax;

	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "im_id")
	WebElement im_id;
	
	@FindBy(name = "skype_id")
	WebElement skype_id;
	
	@FindBy(name = "identifier")
	WebElement identifier;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLebel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public void createNewContact(String title, String ftName, String ltName, String comp, String nickName,
			String companyposition, String suffix, String Department, String Supervisor, String Assistant,
			String ReferredBy, String category, String status, String Phone, String Mobile, String Home_Phone,
			String Fax, String Email, String Im_Id, String im_netowrk, String Skype_id, String Source, String Identifier) {

		Select select = new Select(driver.findElement(By.xpath("//*[@name='title']")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		nickname.sendKeys(nickName);
		companyPosition.sendKeys(companyposition);
		
		select = new Select(driver.findElement(By.xpath("//*[@name='suffix']")));
		select.selectByVisibleText(suffix);
		
		department.sendKeys(Department);
		supervisor.sendKeys(Supervisor);
		assistant.sendKeys(Assistant);
		referredBy.sendKeys(ReferredBy);
		
		select = new Select(driver.findElement(By.xpath("//*[@name='category']")));
		select.selectByVisibleText(category);
		select = new Select(driver.findElement(By.xpath("//*[@name='status']")));
		select.selectByVisibleText(status);
		
		phone.sendKeys(Phone);
		mobile.sendKeys(Mobile);
		home_phone.sendKeys(Home_Phone);
		fax.sendKeys(Fax);
		email.sendKeys(Email);
		im_id.sendKeys(Im_Id);
		
		select = new Select(driver.findElement(By.xpath("//*[@name='im_netowrk']")));
		select.selectByVisibleText(im_netowrk);
		
		skype_id.sendKeys(Skype_id);
		
		select = new Select(driver.findElement(By.xpath("//*[@name='source']")));
		select.selectByVisibleText(Source);
		
		identifier.sendKeys(Identifier);
		
		saveBtn.click();
	}

}
