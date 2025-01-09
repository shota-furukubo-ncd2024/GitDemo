import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Loacators2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		String name ="rahul";//ログインユーザー名は動的なため変数とする
		//WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.setProperty("Webdriver.edge.driver", "C://SeleniumTest//msedgedriver");
		WebDriver driver = new EdgeDriver();
		String password = getpassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);//要素に何かを入力する
		driver.findElement(By.name("inputPassword")).sendKeys(password);//要素に何かを入力する
		driver.findElement(By.className("signInBtn")).click();//ボタンをクリックする
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");//表示される文章が正しいか確認
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();//ログアウトボタンをクリックする（テキストで要素指定）
		driver.close();

	}
	
	public static String getpassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();//リンクをクリックする
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordText=driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");//passwordTextを分割し配列に入れる
		//String[] passwordArray2 = passwordArray[1].split("'");//配列の1つ目を分割し、さらに配列に入れる
		//passwordArray2[0]
		String password = passwordArray[1].split("'")[0];
		return password;
		
		//0th index - Please use temporary password 
		//1st index - rahulshettyacademy' to Login.
		  //0th index - rahulshettyacademy
		  //1st index - to Login.
	}

}
