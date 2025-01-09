import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");//ページが完全にロードされるまで待機する
		driver.navigate().to("https://rahulshettyacademy.com");//ページが完全にロードされるまで待機しない
		driver.navigate().back();//前のページに戻る
		driver.navigate().forward();//先のページに進む
	}

}
