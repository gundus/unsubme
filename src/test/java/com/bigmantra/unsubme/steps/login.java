package com.bigmantra.unsubme.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class login {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		this.driver = new ChromeDriver();
		// System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

	}

	@After
	public void tearDown() {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}

	@Given("^I want to navigate to gmail page$")
	public void i_want_to_navigate_to_gmail_page() throws Throwable {
		driver.get("https://mail.google.com/");
		// String Title = driver.getTitle();
		// System.out.println("Title of the page: " + Title);

	}

	@Given("^I enter username and password$")
	public void i_enter_username_and_password() throws Throwable {
		driver.findElement(By.id("identifierId")).sendKeys("nandhini.girish@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("1wbied12j");

	}

	@When("^I click signin$")
	public void i_click_signin() throws Throwable {
		driver.findElement(By.id("passwordNext")).click();

	}

	@Then("^I am logged into gmail$")
	public void i_am_logged_into_gmail() throws Throwable {
		Thread.sleep(12000);
		String Title = driver.getTitle();
		System.out.println("Title of the page: " + Title);

	}

	@Then("^I should see my inbox page$")
	public void i_should_see_my_inbox_page() throws Throwable {
		WebElement composeButton = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
		Assert.assertEquals(true, composeButton.isDisplayed());
	}
}
