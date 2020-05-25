package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException {

		if (!data.get("runmode").equalsIgnoreCase("Y")) {

			throw new SkipException("skipping the testcase as the rum mode for data set is NO");
		}

//		driver.findElement(By.cssSelector(OR.getProperty("AddCusButton_CSS"))).click();
//		driver.findElement(By.cssSelector(OR.getProperty("FirstName_CSS"))).sendKeys(firstName);
//		driver.findElement(By.cssSelector(OR.getProperty("LastName_CSS"))).sendKeys(lastName);
//		driver.findElement(By.cssSelector(OR.getProperty("PostCode_CSS"))).sendKeys(postCode);
//		driver.findElement(By.cssSelector(OR.getProperty("AddButton_CSS"))).click();

//OR		
		click("AddCusButton_CSS");
		type("FirstName_CSS", data.get("firstName"));
		type("LastName_XPATH", data.get("lastName"));
		type("PostCode_CSS", data.get("postCode"));
		click("AddButton_CSS");
		Thread.sleep(2000);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();

		Thread.sleep(2000);

	}

}
