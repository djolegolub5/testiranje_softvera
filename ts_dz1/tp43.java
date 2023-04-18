/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author korisnik
 */
public class tp43 {
    
    
    
    @Test
    public void tp43() {
        String exePath = "C:\\Users\\korisnik\\Desktop\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/projekat5/IP_projekat/");
        
        WebElement login=driver.findElement(By.linkText("Prijavi se"));
        login.click();
        WebElement username=driver.findElement(By.name("k_ime"));
        username.sendKeys("ana");
        WebElement password=driver.findElement(By.name("lozinka"));
        password.sendKeys("Sifra1234$");
        WebElement log=driver.findElement(By.name("dugme_log"));
        log.click();
        WebElement find=driver.findElement(By.linkText("Pretraga kompanija i konkursa"));
        find.click();
        WebElement job=driver.findElement(By.name("posao"));
        job.click();
        WebElement search=driver.findElement(By.name("dugme"));
        search.click();
        WebElement verification=driver.findElement(By.xpath("/html/body/center[2]/h3"));
        Assert.assertEquals(verification.getText(), "Pronadjeni konkursi");
        
        WebElement logout=driver.findElement(By.linkText("Odjavi se"));
        logout.click();
        
        
        
        
        driver.quit();
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
