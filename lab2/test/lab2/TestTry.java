package lab2;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.TestCase;


@RunWith(Parameterized.class)
public class TestTry {
	private static Try t=new Try();
	private static String baseUrl;
	public static String string3[]=new String[97];
	private String string1,string2;
	public static WebDriver driver = new ChromeDriver();
	
	
    
	public TestTry(String string1,String string2){
		this.string1=string1;
		this.string2=string2;
	}
	
	@BeforeClass
	public static void setup(){
		driver.manage().window().maximize(); 
		baseUrl = "https://psych.liebes.top/st";
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}
	
	//≤Œ ˝ªØ≤‚ ‘
	@Parameters
	public static Collection<Object[]> getResult(){
		Object[][] obj = new Object[97][];
		for(int i=0;i<97;i++){
			obj[i] = new Object[]{t.string1[i],t.string2[i]};
		}
		return Arrays.asList(obj);
	}
	
	@Test
	public void testTy(){
		driver.get("https://psych.liebes.top/st");
    	String pwd = "";
    	pwd = this.string1.substring(4);
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(this.string1);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.id("submitButton")).click();
        assertEquals(driver.findElement(By.xpath("//p")).getText(),this.string2);
	}
	
	@AfterClass
	public static void tearDown(){
	    driver.quit();
	}
}
