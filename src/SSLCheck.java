import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		//プロキシの設定
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);//プロキシを設定する
		//ファイルのダウンロード
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);//ファイルをダウンロードして格納先を指定する
		
		//SSL認証
		options.setAcceptInsecureCerts(true);//サイトを受け入れる
		
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());//信頼されていないサイトのためエラーが発生する
		
		
		
	}

}
