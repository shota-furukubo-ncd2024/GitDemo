import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());//フレーム数を取得する
		driver.switchTo().frame(0);//インデックスでフレームを指定する
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));//要素でフレームを指定する
		//driver.findElement(By.id("draggable")).click();
		WebElement sourse = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.cssSelector("div[class='ui-widget-header ui-droppable']"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(sourse, target).build().perform();
		driver.switchTo().defaultContent();

	}

}
