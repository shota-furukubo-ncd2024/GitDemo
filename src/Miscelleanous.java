import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		//クッキーを削除する
		driver.manage().deleteAllCookies();//全てのクッキー
		//driver.manage().deleteCookieNamed("sessionKey");//指定のクッキー
		
	//リンクをクリックする
		//ログインページに入る
		
		driver.get("http://google.com");
	//スクリーンショットを取得する処理
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//getScreenshotAs(OutputType.FILE)はdriverオブジェクトをTakesScreenshotにキャストすると使える
		//OutputTypeはファイルという意味
		
	//取得したスクリーンショットを保存する処理
        FileUtils.copyFile(src, new File("C:\\SeleniumTest\\scs.png"));
        

	}

}
