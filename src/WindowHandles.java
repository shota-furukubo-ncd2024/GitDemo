import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();

		//別タブから情報を取得したい場合s
		Set<String> windows = driver.getWindowHandles();//親ウィンドウと子ウィンドウ(インデックス0.1)
		Iterator<String> it = windows.iterator();
		String parentId = it.next();//親のウィンドウID取得(1つ目のウィンドウ)
		String childId = it.next();//子のウィンドウID取得
		driver.switchTo().window(childId);//子ウィンドウにコントロールを移動

		System.out.println(
				driver.findElement(By.xpath("//*[@id=\"interview-material-container\"]/div/div[2]/p[2]")).getText());
		String EmailId = driver.findElement(By.xpath("//*[@id=\"interview-material-container\"]/div/div[2]/p[2]"))
				.getText().split("at")[1].trim().split(" ")[0];
		System.out.println(EmailId);

		driver.switchTo().window(parentId);//親ウィンドウにコントロールを移動
		driver.findElement(By.cssSelector("input.form-control")).sendKeys(EmailId);
	}

}
