package com.orangehrm.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkTestUsingIfElse
{

	@Test
    public void verifyLoginLinks()                 
    { 
		System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		WebDriver dr= new ChromeDriver();
	
		dr.manage().window().maximize();
		dr.get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/admin/viewSystemUsers?sortField=user_name&sortOrder=ASC");
		
		WebElement linkIn = dr.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']"));
		linkIn.click();
		 
		WebElement fb = dr.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']"));
		fb.click();
		
		WebElement tw=  dr.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']"));  
		tw.click();
		
		WebElement yu = dr.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']"));  
		yu.click();
		
		String ohandle = dr.getWindowHandle();
		Set<String> allHandles = dr.getWindowHandles();
		Iterator<String> itr   = allHandles.iterator();
		
		while (itr.hasNext())
		{
			String currentHandle = itr.next();
		
			if(!ohandle.contentEquals(currentHandle))
			{
				dr.switchTo().window(currentHandle);
				System.out.println(dr.getTitle());
				dr.close();
			}
			else
			{
			dr.switchTo().window(ohandle);
			System.out.println(dr.getTitle());			
			
			}
		}
    }	
}
