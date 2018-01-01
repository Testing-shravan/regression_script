package com.lensway.testscripts;

import com.lensway.testbase.TestBase;
import com.lensway.uiPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TC_001_UserRegistration extends TestBase{
    HomePage homePage;

    @BeforeTest

    public void setUp()
    {
     init();
    }

    @Test
     public void Registration()
     {
       homePage =new HomePage(driver);
       homePage.registration_Lensway();
       //homePage.registrationSuccess();
      // Assert.assertEquals(true,homePage.registrationSuccess());
     }

    @AfterClass
    public void endTest()
    {
      driver.close();
    }
}
