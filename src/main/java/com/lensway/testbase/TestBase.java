package com.lensway.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {

    public static final Logger log=Logger.getLogger(TestBase.class.getName());

    public WebDriver driver;
    String url="https://www.lensway.se/";
    String browser="firefox";


    public void init()

    {
        selectBrowser(browser);
        getUrl(url);
        String log4jconfpath = "log4j.properties";
        PropertyConfigurator.configure(log4jconfpath);
    }

    public  void selectBrowser(String Browser){

        if (Browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\Driver1\\geckodriver.exe");
            driver= new FirefoxDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        else if(Browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Driver1\\chromedriver.exe");
            log.info("Creating object of " +Browser);
            driver =new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        else if (Browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/driver/IEDriverServer.exe");
            driver= new InternetExplorerDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    }


    public void getUrl(String url)

    {

        log.info("Navigating to " +url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



}
