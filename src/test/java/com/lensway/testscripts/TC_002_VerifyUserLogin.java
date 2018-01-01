package com.lensway.testscripts;

import com.lensway.testbase.TestBase;
import com.lensway.uiPages.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_002_VerifyUserLogin extends TestBase{

    public static final Logger log=Logger.getLogger(TC_002_VerifyUserLogin.class.getName());

    HomePage homePage;

    @BeforeTest

    public void setUp()
    {
      init();

    }

  @Test

    public void VerfiyLogin()
  {
      log.info("#######################Starting test to verify login details#####################################");
      homePage=new HomePage(driver);
      homePage.login_Lensway("TEST00@TEST.com", "Test@1231");
      homePage.registrationSuccess();
      Assert.assertEquals(true,homePage.registrationSuccess());
      log.info("#######################Finished test to verify login details#####################################");
  }

  @AfterClass

    public void endTest()
  {
      driver.close();

  }

}
