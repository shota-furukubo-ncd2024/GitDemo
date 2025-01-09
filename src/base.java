import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//暗黙の待機(テスト全体)
		WebDriverWait w = new WebDriverWait(driver, null);//明示的な待機(ターゲットが明らか)

		String[] itemNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		addItems(driver, itemNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/div[2]/div[2]/button")).click();
		//Thread.sleep(3000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/input")));//明示的な待機(ターゲットが明らか)
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/input")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/button")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/span")));//明示的な待機(ターゲットが明らか)
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/span")).getText());
		//sThread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button")).click();

	}

	public static void addItems(WebDriver driver, String[] itemNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));//全商品をリストに格納する

		//for文で一致するまでループさせる
		for (int i = 0; i < products.size(); i++) {

			//Brocolli - 1Kg
			//Brocolli,  1Kg

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();//trim()でスペースを取り除く
			//配列をArrayListに変換する
			//ArrayListに期待するものが含まれるかのチェック
			//ここでget(i)で取得した名前とArrayListの中の名前が異なるため合わせる必要がある
			//split()で"-"で分割し配列に格納する

			List itemNeededList = Arrays.asList(itemNeeded);

			if (itemNeededList.contains(formattedName)) {

				int j = 0;

				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				//Cucumberの中にいるため複数の要素があってもCucumberが追加される
				//get(index)で要素の番号を取得

				if (j == itemNeeded.length) {
					break;
				}
			}

		}

	}
}