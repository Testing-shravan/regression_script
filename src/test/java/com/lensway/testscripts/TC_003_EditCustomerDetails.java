package com.lensway.testscripts;

import com.lensway.testbase.TestBase;
import com.lensway.uiPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_003_EditCustomerDetails extends TestBase{

    HomePage homePage;

    @BeforeTest
    public void setUp()
    {
       init();

    }


    @Test

    public void EditCustomer()
    {
        homePage =new HomePage(driver);
        homePage.login_Lensway("uname","pwd");
        WebElement xyz=driver.findElement(By.xpath("//span[text()='Logga in']"));
        Actions action= new Actions(driver);
        action.moveToElement(xyz).build().perform();


        driver.findElement(By.linkText("Mina uppgifter"));
        driver.findElement(By.id("my-pages__change-details")).click();
        WebDriverWait wait3= new WebDriverWait(driver,30);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Personnummer']")));
        driver.findElement(By.id("addressForm__ssn")).sendKeys("850712-9792");

        //Select Gender
        Select st=new Select(driver.findElement(By.id("addressForm__gender")));
        st.selectByIndex(1);

        driver.findElement(By.id("addressForm__firstName")).sendKeys("VijayaKumar");
        driver.findElement(By.id("addressForm__lastName")).sendKeys("Kumar");
        driver.findElement(By.id(" addressForm__phone")).sendKeys("1234567890");
        driver.findElement(By.id("addressForm__street")).sendKeys("Skogas");
        driver.findElement(By.id("addressForm__careof")).sendKeys("Gopi");
        driver.findElement(By.id("addressForm__zip")).sendKeys("1234");
        driver.findElement(By.id("addressForm__city")).sendKeys("Stockholm");
        driver.findElement(By.xpath("//input[contains(@value,'Avbryt')]")).click();



    }


}
