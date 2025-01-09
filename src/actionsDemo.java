import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.co.jp/?&tag=hydraamazonav-22&ref=pd_sl_8eaqjij3p0_e&adgrpid=157529193801&hvpone=&hvptwo=&hvadid=675152705458&hvpos=&hvnetw=g&hvrand=10351399578737023689&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9198197&hvtargid=kwd-893523692&hydadcr=27920_14701882&gad_source=1");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		
		//テキストボックスに大文字で入力
		a.moveToElement(driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//特定の要素に移動する
		a.moveToElement(move).contextClick().build().perform();
		driver.close();

	}

}
