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
public class tp22 {
    
    @Test
    public void tp22() {
        
        String exePath = "C:\\Users\\korisnik\\Desktop\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost/projekat5/IP_projekat/");

        WebElement registracija = driver.findElement(By.linkText("Postani korisnik"));
        registracija.click();
        WebElement tip = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td/input[2]"));
        tip.click();
        WebElement zapocni = driver.findElement(By.name("dugme_reg"));
        zapocni.click();
        WebElement username = driver.findElement(By.name("k_ime"));
        username.sendKeys("User123");
        WebElement password = driver.findElement(By.name("lozinka"));
        password.sendKeys("djolEG.5.5");
        WebElement ppassword = driver.findElement(By.name("lozinka_potvrdi"));
        ppassword.sendKeys("djolEG.5.5");
        WebElement name = driver.findElement(By.name("ime"));
        name.sendKeys("Djordje");
        WebElement surname = driver.findElement(By.name("prezime"));
        surname.sendKeys("Golubovic");
        WebElement phone = driver.findElement(By.name("telefon"));
        phone.sendKeys("065271688");
        WebElement year = driver.findElement(By.name("god_stud"));
        year.sendKeys("3");
        WebElement diplom = driver.findElement(By.name("diploma"));
        diplom.sendKeys("Da");
        WebElement picture = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[10]/td[2]/input"));
        picture.sendKeys("C:\\Users\\korisnik\\Desktop\\slika-astek-150x150.jpg");
        WebElement fregistration = driver.findElement(By.name("dugme_reg"));
        fregistration.click();
        String text = driver.findElement(By.name("eposta")).getAttribute("validationMessage");
        System.out.println(text);
        Assert.assertEquals(text, "Please fill out this field.");
        
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
