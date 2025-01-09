import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:\\SeleniumTest\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");//ページが完全にロードされるまで待機する
		Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_friendsandfamily\"]")).isSelected());//Falseを返しているかチェック
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_friendsandfamily\"]")).isSelected());
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_friendsandfamily\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_friendsandfamily\"]")).isSelected());//Trueを返しているかチェック
		System.out.println(
				driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_friendsandfamily\"]")).isSelected());//選択されているかのチェッ

		//チェックボックスの数を数える
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());//sizeメソッドは要素数

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		//while繰り返し
		/*int i =1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}*/

		//for繰り返し
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();//Doneで閉じる
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");//期待値と実際の値が一致しているか
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
