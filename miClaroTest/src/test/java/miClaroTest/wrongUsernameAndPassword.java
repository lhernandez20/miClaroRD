package miClaroTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class wrongUsernameAndPassword extends miClaroRD{

	@Test
	@Order(4) 
	public void testWrongUsernamePassword() throws Exception {
		
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
			password.sendKeys("pass");
			
			screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
			
			//Butto Login
			WebElement btnLogin = driver.findElement(By.id("com.clarord.miclaro:id/full_login_button"));
			btnLogin.click();
			
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			
			screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
			
			System.out.println("wrong Username And Password");
				
			
		}
	}

}
