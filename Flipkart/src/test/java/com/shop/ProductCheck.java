package com.shop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCheck {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\sarav\\eclipse-workspace\\sel\\Flipkart\\inputData.properties");
		FileInputStream stream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(stream);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sarav\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox"))).sendKeys(prop.getProperty("product"));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='submit'])[1]"))).click();
       
		List<WebElement> element = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		for (WebElement get : element) {

			String text = get.getText();
			System.out.println(text);

		}

		driver.quit();

	}

}
