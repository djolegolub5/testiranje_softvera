/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
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
public class tp41 {

    @Test
    public void tp41() {
        String exePath = "C:\\Users\\korisnik\\Desktop\\operadriver.exe";
        System.setProperty("webdriver.opera.driver", exePath);

        WebDriver driver = new OperaDriver();

        driver.get("http://localhost/projekat5/IP_projekat/");
        
        WebElement login = driver.findElement(By.linkText("Prijavi se"));
        login.click();
        WebElement username = driver.findElement(By.name("k_ime"));
        username.sendKeys("softvering");
        WebElement password = driver.findElement(By.name("lozinka"));
        password.sendKeys("ETFbgd.123");
        WebElement log = driver.findElement(By.name("dugme_log"));
        log.click();
        WebElement grade = driver.findElement(By.linkText("Oceni konkurse"));
        grade.click();
        WebElement cgrade = driver.findElement(By.linkText("Junior Software Developer"));
        cgrade.click();
        WebElement post = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td/input"));
        post.click();
        WebElement verification = driver.findElement(By.id("ispis"));
        
        Assert.assertEquals(verification.getText(), "Rang lista je objavljena");
        
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
