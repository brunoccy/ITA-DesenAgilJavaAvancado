/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;


/**
 *
 * @author Mariana
 */
public class testeSomaClasse {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testesoma() {
    driver.get("http://localhost:8080/TreinoTeste/");
    driver.manage().window().setSize(new Dimension(1366, 728));
    driver.findElement(By.name("p1")).click();
    driver.findElement(By.name("p1")).sendKeys("5");
    driver.findElement(By.name("p2")).click();
    driver.findElement(By.name("p2")).sendKeys("11");
    driver.findElement(By.name("calcular")).click();
    driver.findElement(By.cssSelector("html")).click();
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("O resultado 16"));
  }
}
