package com.llbean.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
	
	@Test
	public void loginFailUsername() {
		
		//Set ChromeDriver property
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		
		//Instantiate WebDriver driver object
		WebDriver driver = new FirefoxDriver();
		
		//maximize browser screen
		driver.manage().window().maximize();
		
		//open website
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		
		//Enter incorrect username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gautam");
		
		
		//Enter correct Password
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		password.sendKeys("SuperSecretPassword!");
		
		//Click Login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
		loginButton.click();
		
		
		//verify login failed message
		String usernameIncorrectMessageActual = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String usernameIncorrectMessageExpected = "Your username is invalid!";
		/*
		 * System.out.println(usernameIncorrectMessageActual.contains(
		 * usernameIncorrectMessageExpected)); if
		 * (usernameIncorrectMessageActual.contains(usernameIncorrectMessageExpected)) {
		 * System.out.println("login failed message is displayed");
		 * 
		 * }else { System.out.println("login failed message is not displayed"); }
		 */
		
		Assert.assertTrue(usernameIncorrectMessageActual.contains(usernameIncorrectMessageExpected), "login failed username message is not displayed");
		
		
		
		//Quit Driver/End Session
		driver.quit();
		
		
		
	}
	
	@Test
	public void loginFailPassword() {
		
		//Set ChromeDriver property
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		
		//Instantiate WebDriver driver object
		WebDriver driver = new ChromeDriver();
		
		//maximize browser screen
		driver.manage().window().maximize();
		
		//open website
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		
		//Enter incorrect username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		
		//Enter correct Password
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		password.sendKeys("SuperSecretPasswod!");
		
		//Click Login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
		loginButton.click();
		
		
		//verify login failed message
		String usernameIncorrectMessageActual = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String usernameIncorrectMessageExpected = "Your password is invalid!";
		/*
		 * System.out.println(usernameIncorrectMessageActual.contains(
		 * usernameIncorrectMessageExpected)); if
		 * (usernameIncorrectMessageActual.contains(usernameIncorrectMessageExpected)) {
		 * System.out.println("login failed message is displayed");
		 * 
		 * }else { System.out.println("login failed message is not displayed"); }
		 */
		
		Assert.assertTrue(usernameIncorrectMessageActual.contains(usernameIncorrectMessageExpected), "login failed password message is not displayed");
		
		
		
		//Quit Driver/End Session
		driver.quit();
		
		
		
	}

}
