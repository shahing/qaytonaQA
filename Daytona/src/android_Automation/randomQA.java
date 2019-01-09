//randomQA
package android_Automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class randomQA {

	AppiumDriver<MobileElement> driver;
	DesiredCapabilities caps = new DesiredCapabilities();
	File Android_app = new File("./APP_apk/Random_v8.0_apkpure.com.apk");
	@BeforeMethod
@Test
	public void verifyRandomQA() throws MalformedURLException, InterruptedException {
		//launch app
		caps.setCapability("deviceName", "TA069036RK");
		caps.setCapability(CapabilityType.VERSION, "5.1");
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.NO_RESET, "true");
		caps.setCapability("app", Android_app.getAbsolutePath());
		caps.setCapability("appPackage", "com.vasilchenko.randomfree");
		caps.setCapability("appActivity", "com.vasilchenko.randomfree.MenuActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		Thread.sleep(5000);

		//Verify Random
		driver.findElement(By.xpath("//android.widget.TextView[@text='Random']")).isDisplayed();
		//Generate Number
		driver.findElement(By.xpath("//android.widget.Button[@text='Generate number']")).isDisplayed();
		driver.findElement(By.xpath("//android.widget.Button[@text='Generate number']")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Random number:']")).isDisplayed();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.vasilchenko.randomfree:id/min']")).sendKeys("10");
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.vasilchenko.randomfree:id/max']")).sendKeys("10");
		driver.findElement(By.xpath("//android.widget.Button[@text='Generate']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.vasilchenko.randomfree:id/result']")).getText().equalsIgnoreCase("-1");
		driver.navigate().back();
	}

	@AfterMethod
	public void CloseDriver() throws InterruptedException {

		driver.quit();
	}
}
