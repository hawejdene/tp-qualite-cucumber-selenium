package ecommerce_test;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
public class BuyTest {
private WebDriver driver;
private Map<String, Object> vars;
JavascriptExecutor js;
@Before
public void setUp() {
	System.setProperty("webdriver.chrome.driver",
	           "driver/chromedriver.exe");
 driver = new ChromeDriver();
 js = (JavascriptExecutor) driver;
 vars = new HashMap<String, Object>();
}
@After
public void tearDown() {
 //driver.quit();
	System.out.print("done");
}
@Test
public void buy() throws InterruptedException {
	driver.get("https://www.mytek.tn/");
    //driver.manage().window().setSize(new Dimension(516, 708));
    driver.findElement(By.cssSelector(".col-lg-12 .img-responsive")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.cssSelector("#add_to_cart span")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
    TimeUnit.SECONDS.sleep(3);

    WebElement startCommand = driver.findElement(By.xpath("//a[contains(@href,'https://www.mytek.tn/commande?step=1')]"));
	String link = startCommand.getAttribute("href");
	driver.navigate().to(link);
	
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("weha@yahoo.fr");
    driver.findElement(By.id("passwd")).sendKeys("password");
    driver.findElement(By.id("SubmitLogin")).click();
    TimeUnit.SECONDS.sleep(3);
 // Confirming the adress
 		WebElement processAdress = driver.findElement(By.name("processAddress"));
 		js.executeScript("arguments[0].click()", processAdress);
 		TimeUnit.SECONDS.sleep(3);
 		// Confirming carrier choice
 		WebElement processCarrier = driver.findElement(By.name("processCarrier"));
 		js.executeScript("arguments[0].click()", processCarrier);
 		TimeUnit.SECONDS.sleep(3);
 		// Confirming payment
 		WebElement pay = driver.findElement(By.xpath("//a[contains(@title,'Payer comptant à la livraison')]"));
 		js.executeScript("arguments[0].click()", pay);
 		TimeUnit.SECONDS.sleep(3);
 		// Confirming purchase
 		WebElement confirm = driver.findElement(By.xpath("//button[contains(@class,'btn-warning btn-medium')]"));
 		js.executeScript("arguments[0].click()", confirm);

    /*driver.findElement(By.cssSelector(".button-medium > span")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.name("processCarrier")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.cssSelector(".cash")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.cssSelector(".btn-medium > span")).click();*/
}

}

