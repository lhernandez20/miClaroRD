package miClaroTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy.ById;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;


public class miClaroRD {

	//WebDriver driver;
	static AppiumDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			setUp();
			
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}
	
	public static <MobileElement> void setUp () throws Exception {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		//Capabilities
		cap.setCapability("deviceName", "sdk_gphone64_x86_64");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("udid", "emulator-5554");
		
		//Capabilities App miClaro
		cap.setCapability("appPackage", "com.clarord.miclaro");
		cap.setCapability("appActivity", "com.clarord.miclaro.controller.LoginActivity");
		
		//URL
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		driver =new AppiumDriver(url, cap);
		
		System.out.println("Application miCalroRD Started...");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
	}
	
	//screenshot
	public void screenshot(String path_screenshot) throws IOException{
		
	    File srcFile=driver.getScreenshotAs(OutputType.FILE);
	    String filename=UUID.randomUUID().toString(); 
	    File targetFile=new File(path_screenshot + filename +".jpg");
	    FileUtils.copyFile(srcFile,targetFile);
	}

	@After
	public void closeApp() throws Exception {
		
		driver.quit();
	}	

}
