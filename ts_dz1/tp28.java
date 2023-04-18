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
public class tp28 {
    
    
    @Test
    public void tp28() {
         String exePath = "C:\\Users\\korisnik\\Desktop\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost/projekat5/IP_projekat/");
        
        WebElement registracija = driver.findElement(By.linkText("Postani korisnik"));

        registracija.click();
        ///html/body/center/form/table/tbody/tr[2]/td/input[2]
        WebElement tip = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td/input[3]"));

        tip.click();
        WebElement zapocni = driver.findElement(By.name("dugme_reg"));

        zapocni.click();
        WebElement username = driver.findElement(By.name("k_ime"));

        username.sendKeys(
                "user1236a7");
        WebElement password = driver.findElement(By.name("lozinka"));

        password.sendKeys(
                "djolEG.5.5");
        WebElement ppassword = driver.findElement(By.name("lozinka_potvrdi"));

        ppassword.sendKeys(
                "djolEG.5.5");
        WebElement name = driver.findElement(By.name("naziv"));

        name.sendKeys(
                "kompanija");
        WebElement city = driver.findElement(By.name("grad"));

        city.sendKeys(
                "Prijepolje");
        WebElement address = driver.findElement(By.name("adresa"));

        address.sendKeys(
                "4. deecmbar bb");
        
         WebElement director = driver.findElement(By.name("direktor"));

        director.sendKeys(
                "Djordje Golubovic");
        
        WebElement pib = driver.findElement(By.name("pib"));

        pib.sendKeys(
                "0505001");
        
        
        
        
        
        
        
        WebElement email = driver.findElement(By.name("eposta"));

        email.sendKeys(
                "djordjegolubovic55@gmail.com");
        
        

       
        WebElement website = driver.findElement(By.name("vebsajt"));

        website.sendKeys(
                "www.djg.com");
        
        WebElement delatnost = driver.findElement(By.name("delatnost"));

        delatnost.sendKeys(
                "IT");
        WebElement speciality = driver.findElement(By.name("specijalnost"));

        speciality.sendKeys(
                "testiranje softvera");
        
        
        
        WebElement picture = driver.findElement(By.name("logo"));

        picture.sendKeys(
                "C:\\Users\\korisnik\\Desktop\\slika-astek-150x150.jpg");
        WebElement fregistration = driver.findElement(By.name("dugme_reg"));

        fregistration.click();
        String text = driver.findElement(By.name("brzaposlenih")).getAttribute("validationMessage");
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
