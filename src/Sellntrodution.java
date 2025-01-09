import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sellntrodution {

	public static void main(String[] args) {
		
		//System.setProperty("Webdriver.chrome.driver", "");
		//WebDriver driver = new ChromeDriver();
		
		
		//Firefoxで開始する
		//geckodriverを使用しFirefoxブラウザを呼び出す
		System.setProperty("Webdriver.gecko.driver", "C://SeleniumTest//geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//MSEdgeで開始する
		//MSEdgedriverを使用しedgeブラウザを呼び出す
		//System.setProperty("Webdriver.edge.driver", "C://SeleniumTest//msedgedriver");
		//WebDriver driver2 = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//現在のウィンドウを終了
		driver.close();
		//すべてのウィンドウとドライバーを終了
		//driver.quit();
		

	}

}
