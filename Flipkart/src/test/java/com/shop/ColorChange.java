package com.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ColorChange {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sarav\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("how to verify color change in selenium");

		driver.findElement(By.name("btnK")).click();

		// driver.findElement(By.xpath("(//*[@class='LC20lb DKV0Md'])[2]")).click();
		// driver.navigate().back();
		 Thread.sleep(3000);
		// String color = driver.findElement(By.xpath("(//*[@class='LC20lb
		// DKV0Md'])[2]")).getCssValue("color");
		// String hex = Color.fromString(color).asHex();
		// System.out.println(hex);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		List<String> li = new ArrayList<String>();

		for (WebElement lin : links) {

			li.add(lin.getAttribute("href"));

		}

		for (String url : li) {
			if(url !=null) {
			
			driver.get(url);
			
		}
		}
		driver.close();

	}

}
