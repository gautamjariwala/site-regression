package com.llbean.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTest() {
		// Set Chrome Driver location
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		// intitialize WebDriver instance
		WebDriver driver = new ChromeDriver();

		// sleep for 3 seconds
		// sleep(3000);
		// maximize browser window
		driver.manage().window().maximize();
		// open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		// sleep for 2 seconds
		// sleep(2000);
		// enter username
		WebElement username = driver.findElement(By.id("username"));

		username.sendKeys("tomsmith");

		// enter password
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		password.sendKeys("SuperSecretPassword!");

		// click login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
		loginButton.click();
		// verificatins:

		// new url

		// logout button is visible
		WebElement logoutButton = driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
		Assert.assertTrue(logoutButton.isDisplayed(), "Logout Button is not displayed");;
		//System.out.println("logout button is displayed: " + logoutButton);

		// succesful login message
		WebElement successfulMessage = driver.findElement(By.cssSelector("h2"));
		String expectedSuccessfulMessage = "Secure Area";
		String actualSuccessfulMessage = successfulMessage.getText();
		Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage, "This is not logged In screen");
		

		// Close browser
		driver.quit();

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}