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
public class tp31 {
    @Test
    public void tp31() {
        
        
        String exePath = "C:\\Users\\korisnik\\Desktop\\operadriver.exe";
        System.setProperty("webdriver.opera.driver", exePath);

        WebDriver driver = new OperaDriver();


        driver.get(
                "http://localhost/projekat5/IP_projekat/");
        driver.manage()
                .window().maximize();
        WebElement registracija = driver.findElement(By.linkText("Postani korisnik"));

        registracija.click();
        ///html/body/center/form/table/tbody/tr[2]/td/input[2]
        WebElement tip = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td/input[2]"));

        tip.click();
        WebElement zapocni = driver.findElement(By.name("dugme_reg"));

        zapocni.click();
        WebElement username = driver.findElement(By.name("k_ime"));

        username.sendKeys(
                "user12367aadj89ole");
        WebElement password = driver.findElement(By.name("lozinka"));

        password.sendKeys(
                "5djolEG.5.5");
        WebElement ppassword = driver.findElement(By.name("lozinka_potvrdi"));

        ppassword.sendKeys(
                "5djolEG.5.5");
        WebElement name = driver.findElement(By.name("ime"));

        name.sendKeys(
                "Djordje");
        WebElement surname = driver.findElement(By.name("prezime"));

        surname.sendKeys(
                "Golubovic");
        WebElement phone = driver.findElement(By.name("telefon"));

        phone.sendKeys(
                "065271688");
        WebElement email = driver.findElement(By.name("eposta"));

        email.sendKeys(
                "djordjegolubovic55@gmail.com");
        WebElement year = driver.findElement(By.name("god_stud"));

        year.sendKeys(
                "3");
        WebElement diplom = driver.findElement(By.name("diploma"));

        diplom.sendKeys(
                "Da");
        WebElement picture = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[10]/td[2]/input"));

        picture.sendKeys(
                "C:\\Users\\korisnik\\Desktop\\slika-astek-150x150.jpg");
        WebElement fregistration = driver.findElement(By.name("dugme_reg"));

        fregistration.click();
        WebElement verification = driver.findElement(By.xpath("//*[contains(text(),'Lozinka nije u validnom formatu. Pokusajte ponovo.')]"));
        boolean end = verification.getText().contains("Lozinka nije u validnom formatu. Pokusajte ponovo.");


        Assert.assertTrue(end);
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
