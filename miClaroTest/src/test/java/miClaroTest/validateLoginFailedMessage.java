package miClaroTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.OrderWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class validateLoginFailedMessage extends miClaroRD{

	@Test
	@Order(5) 
	public void testvalidateLoginFailedMessage() throws Exception{
		
		//Started miClaro
		setUp();
		
		//Click buttom Next_Tip
		WebElement buttomNextTip = driver.findElement(By.id("com.clarord.miclaro:id/next_tip"));
		buttomNextTip.click();
		
		//Click buttom Close_Tip
		WebElement btnCloseTip = driver.findElement(By.id("com.clarord.miclaro:id/close_tips"));
		btnCloseTip.click();
		
		screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
		
		//UserName
		WebElement userName = driver.findElement(By.id("com.clarord.miclaro:id/username_view"));

		if(userName.isDisplayed() == true) {
			
			userName.sendKeys("max");
			
			//password
			WebElement password = driver.findElement(By.id("com.clarord.miclaro:id/password_view"));
			password.sendKeys("pass");
			
			screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
			
			//Butto Login
			WebElement btnLogin = driver.findElement(By.id("com.clarord.miclaro:id/full_login_button"));
			btnLogin.click();
			
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			
			screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
			
			WebElement msg = driver.findElement(By.id("android:id/message"));
			
			if(msg.isDisplayed() == true) {
				
				screenshot("/Users/luisdanielhernandez/eclipse-workspace/miClaroTest");
				
				//Point Verify
				assertEquals("El usuario y/o la contraseña son incorrectos","El usuario y/o la contraseña son incorrectos");
				
				System.out.println("El usuario y/o la contraseña son incorrectos");
			}
				
		}	
	}

}
