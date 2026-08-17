package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	WebElement txtUsername;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="submit")
	WebElement btnSubmit;
	
	@FindBy(xpath="//h1[normalize-space()='Logged In Successfully']")
	WebElement successMessage;
	
	@FindBy(xpath="//div[@id='error']")
	WebElement errorMessage;
	
	@FindBy(xpath="//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")
	WebElement btnLogout;
	
	public void enterUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	public void clickLogin() {
		btnSubmit.click();
	}
	public String getSuccessMessage() {
		return successMessage.getText();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	
	public void clickLogout() {
		btnLogout.click();
	}
}