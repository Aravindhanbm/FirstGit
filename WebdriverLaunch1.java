
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverLaunch1 {
	static int rowvalue;
	static int columnvalue;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String url = "https://demo.guru99.com/test/web-table-element.php";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		int rowsize = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr")).size();
		System.out.println("size of row:" + rowsize);
		int columnsize = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr[1]//td")).size();
		System.out.println("size of cloumn:" + columnsize);
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= columnsize; j++) {
				String text = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+i+"]//td["+j+"]")).getText();
				System.out.println(text);
				}
		}
		String text2 = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[1]//td[1]")).getText();
		System.out.println(text2);

		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= columnsize; j++) {
				String text1 = driver
						.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[" + i + "]//td[" + j + "]"))
						.getText();
				if (text1.contains("Central Bank")) {
					System.out.println(text1);
					rowvalue = i;
					columnvalue = j;
                    break;
				}

			}
		}
		for (int i = 1; i <= columnsize; i++) {
			String text1 = driver
					.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+rowvalue+"]//td["+i+"]"))
					.getText();
			System.out.println(text1);
		}
		for (int j = 1; j <= rowsize; j++) {
			String text1 = driver
					.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[" +j+ "]//td["+columnvalue+"]"))
					.getText();
			System.out.println(text1);
		}
	
		
		List<WebElement> TableElement=driver.findElements(By.xpath("//table[@class='dataTable']//thead//tr//th"));
		WebElement prevclose = driver.findElement(By.xpath("//table[@class='dataTable']//thead//tr//th[text()='Prev Close (Rs)']"));
		WebElement Group = driver.findElement(By.xpath("//table[@class='dataTable']//thead//tr//th[text()='Group']"));
		int indexOfPc = TableElement.indexOf(prevclose)+1;
		System.out.println(indexOfPc);
		int indexOfGp = TableElement.indexOf(Group)+1;
		System.out.println(indexOfGp);
		for (int j = 1; j <= rowsize; j++) {
			String text1 = driver
					.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+j+"]//td["+indexOfPc+"]"))
					.getText();
			System.out.println(text1);
		}
			for (int j = 1; j <=rowsize; j++) {
				String text1 = driver
						.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+j+"]//td["+indexOfGp+"]"))
						.getText();
				System.out.println(text1);
		}
	}
}