import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {

		//1.ページ状のリンク数を知りたい

		//2.フッターのセクション数を知りたい

		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());//リンク数を調べる

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));//フッターの要素を変数に格納する、ドライバーの役割を果たす
		System.out.println(footerDriver.findElements(By.tagName("a")).size());//フッターのリンク数を調べる

		//3.フッターのコラムのセクション数を知りたい
		WebElement coloumnDriver = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]"));//フッターのコラムの要素を変数に格納する、ドライバーの役割を果たす
		System.out.println(coloumnDriver.findElements(By.tagName("a")).size());//フッターのコラムのリンク数を調べる

		//4.リンクが機能しているかを知りたい
		for (int i = 1; i < coloumnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);//コントロールをしながらエンターを押す(クリックとエンターは同じ)
			coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);//キーを押下する際にもsenndKeysメソッドは使用する
		}
		//すべてのタブを開く
		/*Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
		driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());*/

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator(); // 通常のfor文を使用 
		for (int i = 0; i < windows.size(); i++) {
			if (it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}

	}

}
