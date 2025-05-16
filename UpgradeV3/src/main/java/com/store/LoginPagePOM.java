package com.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bs.Reusable1;

public class LoginPagePOM extends Reusable1{

	WebDriver driver;

	public LoginPagePOM(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="id_email")
	WebElement email;
	
	@FindBy(id="id_password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	

	public void loginApplication(String emailId,String pass) throws InterruptedException
	{
		email.sendKeys(emailId);
		password.sendKeys(pass);
		login.click();
	}
	
	public void goTo() throws InterruptedException
	{
		driver.get("https://staging.lauditor.com/login");
	}
	
	
	
	
}
