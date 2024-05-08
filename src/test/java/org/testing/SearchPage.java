package org.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.pojo.FlipkartPojo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import net.bytebuddy.jar.asm.Handle;

public class SearchPage extends BaseClass {
	FlipkartPojo find;
	Robot robot;
	
	@BeforeClass
	private void openBrowser() {
		chromeBrowser();
		launchUrl("https://www.flipkart.com/");
		maximizePage();
	}
	
	
	@Test
	private void searchProduct1() throws AWTException, IOException {
		find = new FlipkartPojo();
		WebElement searchBox = find.getSearch();
		passValue(searchBox, "samsung m31");
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WebElement searchedproduct = find.getProduct();
		clickItem(searchedproduct);
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String nxtTab : child) {
			if (!nxtTab.equals(parent)) {
				 driver.switchTo().window(nxtTab);
				
			}
			
		}
		
		screenShot("D:\\selenium workspace2\\FlipKartProject1\\screenshot\\samsung m31.png");
		
	}
	@Ignore
	@Test
	private void login() {
		find = new FlipkartPojo();
		clickItem(find.getLog());

	}

}

