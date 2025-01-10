import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");//要素に何かを入力する
		driver.findElement(By.name("inputPassword")).sendKeys("12345");//要素に何かを入力する
		driver.findElement(By.className("signInBtn")).click();//ボタンをクリックする
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());//エラー分を取得する
		//Forgot your password?
		driver.findElement(By.linkText("Forgot your password?")).click();//リンクをクリックする
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");//xpathによる記述
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@co.jp");//cssによる記述
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@.com");//cssによる記述
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("08011112222");//cssによる記述
		//RESET LOGIN
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//GO TO LOGIN
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("john");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		//CheckBox1クリック
		driver.findElement(By.id("chkboxOne")).click();
		//CheckBox2クリック
		driver.findElement(By.id("chkboxTwo")).click();
		//SIGN IN
		driver.findElement(By.className("signInBtn")).click();
		
		driver.close();
	}

}
