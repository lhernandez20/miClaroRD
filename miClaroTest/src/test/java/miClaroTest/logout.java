package miClaroTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class logout extends miClaroRD{

	@Test
	@Order(1) 
	public void testLogout() throws Exception {
		
		//Started miClaro
		setUp();
				
		//Click buttom Next_Tip
		WebElement buttomNextTip = driver.findElement(By.id("com.clarord.miclaro:id/next_tip"));
		buttomNextTip.click();
		
		//Click buttom Next_Tip
		WebElement btnCloseTip = driver.findElement(By.id("com.clarord.miclaro:id/close_tips"));
		btnCloseTip.click();
		
		screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
		
		//UserName
		WebElement userName = driver.findElement(By.id("com.clarord.miclaro:id/username_view"));

		if(userName.isDisplayed() == true) {
			
			userName.sendKeys("user");
			
			//password
			WebElement password = driver.findElement(By.id("com.clarord.miclaro:id/password_view"));
			password.sendKeys("password");
			
			//Butto Login
			WebElement btnLogin = driver.findElement(By.id("com.clarord.miclaro:id/full_login_button"));
			btnLogin.click();
			
			screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			//service_nickname
			WebElement nickName = driver.findElement(By.id("com.clarord.miclaro:id/service_nickname"));
			
			if(nickName.isDisplayed() == true) {
		
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				
				screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
				
				System.out.println("Login Successfull");
				
				//logout
				WebElement butto = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Mi Claro\"]"));
				butto.click();
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				WebElement navigation = driver.findElement(By.id("com.clarord.miclaro:id/design_navigation_view"));
				
				if(navigation.isDisplayed() == true) {
					
					WebElement btnLogout = driver.findElement(By.id("com.clarord.miclaro:id/logout_menu_option"));
					
					screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
					
					btnLogout.click();
					
					WebElement logo = driver.findElement(By.id("com.clarord.miclaro:id/logo"));
					
					if(logo.isDisplayed() == true) {
						
						screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
						
						System.out.println("Logout Successfull");
						
					}
					
				}
				
			}
			
		}		
		
	}
}
