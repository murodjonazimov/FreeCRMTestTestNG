package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase {

	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "nickname")
	WebElement nickName;
	
	@FindBy(id= "mobile")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	public void typeFirstName() {
		firstName.sendKeys("Mike");
	}
	public void tybeLastName() {
		lastName.sendKeys("Lowrans");
	}
	public void typeMobileNumber() {
		mobileNumber.sendKeys("3122221313");
	}
	public void clickOnSaveBtn() {
		saveBtn.submit();
	}
}
