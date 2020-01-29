// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class semana1 {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void Fahrenheit() {
    driver.get("http://localhost:8080/semana1/");
    driver.manage().window().setSize(new Dimension(1366, 735));
    driver.findElement(By.name("p1")).click();
    driver.findElement(By.name("p1")).sendKeys("100");
    driver.findElement(By.name("calcular")).click();
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("A temperatura em Fahrenheit é 212"));
  }
    @Test
  public void Celsius() {
    driver.get("http://localhost:8080/semana1/");
    driver.manage().window().setSize(new Dimension(1366, 728));
    driver.findElement(By.name("temperaturas")).click();
    {
      Select dropdown = new Select(driver.findElement(By.name("temperaturas")));
      dropdown.selectByVisibleText("Celsius");
    }
    driver.findElement(By.name("p1")).click();
    driver.findElement(By.name("p1")).sendKeys("212");
    driver.findElement(By.name("calcular")).click();
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("A temperatura em Celsius é 10"));
  }
}
