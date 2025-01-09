import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assingment {

	public static void main(String[] args) {
		String text = "rahul";
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");//ページが完全にロードされるまで待機する
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();//Alertボタンをクリック
		System.out.println(driver.switchTo().alert().getText());//アラートのテキストを取得する
		driver.switchTo().alert().accept();//アラートに切り替えてOKボタンを押下する
		//accept()はYesやOkなど肯定に使用
		
		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();//confirmボタンをクリック
		System.out.println(driver.switchTo().alert().getText());//アラートのテキストを取得する
		driver.switchTo().alert().dismiss();//アラートに切り替えてCancelボタンを押下する
		//dismiss()はNoやCancelなど肯定に使用
		
		
		

	}

}
