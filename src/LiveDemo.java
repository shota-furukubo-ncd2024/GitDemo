import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// コラムをクリックする
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// 要素をリストに取り込む
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// 要素の名前をリストに取り込む
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// リストをソートする
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// 元のリストとソートしたリストを比較する
		Assert.assertTrue(originalList.equals(sortedList));

		List<String> price;

		// scan the name column with getText ->Beans->print the price of the Rice
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice"))
					.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
	}

	private static String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;

	}

}