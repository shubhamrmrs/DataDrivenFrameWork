package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void bankManagerloginTest() throws InterruptedException, IOException {

		verifyEquals("abc", "xyz");
		Thread.sleep(3000);

		log.debug("Inside Login Test");
		click("BMloginButton_CSS");
		// driver.findElement(By.cssSelector(OR.getProperty("BMloginButton_CSS"))).click();

		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("AddCusButton_CSS"))), "Login not sucessful");
		Thread.sleep(3000);
		log.debug("Login succesfully executed");
	    Assert.fail("login failed");

	}

}
