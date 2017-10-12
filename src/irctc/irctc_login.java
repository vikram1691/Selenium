package irctc;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class irctc_login {
	
	public static void ConfigueFirefox(){
		String key="webdriver.gecko.driver";
		String value="./software/geckodriver.exe";
		System.setProperty(key, value);
	}
	
	public static void ConfigueChrome(){
		String key="webdriver.chrome.driver";
		String value="./software/chromedriver.exe";
		System.setProperty(key, value);
	}

	public static void main(String[] args) {

		ConfigueChrome();
		ChromeDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.findElement(By.id("usernameId")).sendKeys("KADAM1991");
		dr.findElement(By.className("loginPassword")).sendKeys("umakadam");
		
		System.out.println("Enter Capcha for login");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String logincapcha=sc.nextLine();
		
		dr.findElement(By.className("loginCaptcha")).sendKeys(logincapcha);
		dr.findElement(By.id("loginbutton")).click();
		
		dr.close();
		
		

	}

}
