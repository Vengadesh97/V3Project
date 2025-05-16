package com.store;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bs.Reusable1;

public class DashboardPOM extends Reusable1{
	
	WebDriver driver;

	public DashboardPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Groups']")
	WebElement groupLeft;

	public void groupLeftSide() throws InterruptedException {
		// Scroll Down
		Thread.sleep(2000);
		WebElement scol = driver.findElement(By.cssSelector("html"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", scol);

		// Group Select on Left Side
		Thread.sleep(4000);
		visibilityOfAllElements(groupLeft);
		groupLeft.click();
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		a.sendKeys(Keys.PAGE_UP).build().perform();

	}

}
