package com.shop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Enabledcheck {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sarav\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// Click on Radio Button

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement radio = driver.findElement(By.id("u_0_5"));

		wait.until(ExpectedConditions.elementToBeClickable(radio)).click();

		System.out.println("The Output of the IsSelected " + radio.isSelected());
		System.out.println("The Output of the IsEnabled " + radio.isEnabled());
		System.out.println("The Output of the IsDisplayed " + radio.isDisplayed());

		// Close the Browser.
		driver.close();
		 

	}

}
