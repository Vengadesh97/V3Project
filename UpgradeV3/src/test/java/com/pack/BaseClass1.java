package com.pack;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import com.store.CreateGroupPOM;
import com.store.DashboardPOM;
import com.store.LoginPagePOM;



public class BaseClass1 {
	public WebDriver driver;

	public Properties prop;
	
	public LoginPagePOM loginPage;
	public DashboardPOM dashBoard;
	public CreateGroupPOM createGroup;

	
	public WebDriver initalize() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/vengadeshwaran/git/repository2/UpgradeV3/src/main/java/com/resourceData/Data1.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
		//	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(ops);
		} else if (browserName.equalsIgnoreCase("Firefox")) {
		//	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
		//	WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		return driver;
	}

	@BeforeClass()
	public LoginPagePOM launchApplication() throws IOException, InterruptedException {
		driver = initalize();
		// driver.get("https://app.lauditor.com/login");
		loginPage = new LoginPagePOM(driver);
		loginPage.goTo();
		loginPage.loginApplication(prop.getProperty("name"), prop.getProperty("password"));
		dashBoard = new DashboardPOM(driver);
		createGroup = new CreateGroupPOM(driver);
		return loginPage;
	}
	


}
