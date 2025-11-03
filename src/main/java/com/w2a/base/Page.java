package com.w2a.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilites.ExcelReader;
import com.w2a.utilites.ExtentManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Page {
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static WebDriver driver;
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static ExcelReader excel = new ExcelReader("C:\\Users\\ALOK\\OneDrive\\Desktop\\Udemy\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.excel\\testdata.xlsx");
    public static WebDriverWait wait;
    public ExtentReports rep = ExtentManager.getInstance();
    public static ExtentTest test;
    public static WebElement element;

    public Page(){

        if(driver==null){
            //loading properties file
            //------------------------------
            PropertyConfigurator.configure("C:\\Users\\ALOK\\OneDrive\\Desktop\\Udemy\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.properties\\log4j.properties");
            try {
                fis = new FileInputStream("C:\\Users\\ALOK\\OneDrive\\Desktop\\Udemy\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.properties\\Config.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                config.load(fis);
                log.debug("Config file loaded");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fis = new FileInputStream("C:\\Users\\ALOK\\OneDrive\\Desktop\\Udemy\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.properties\\OR.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                OR.load(fis);
                log.debug("OR file loaded");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            //jenkins system setting browsers and lunching browsers
            //-----------------------------------------------------
            if(System.getenv("browser")!=null && System.getenv("browser").isEmpty()){
                config.setProperty("browser", System.getenv("browser"));
            }else if(config.getProperty("browser").equals("chrome")){
                Map<String,Object> prefs = new HashMap<String,Object>();
                prefs.put("profile.default_content_setting_values.notifications",2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-save-password-bubbl");
                options.addArguments("--disable-extensions");
                driver = new ChromeDriver(options);
                log.debug("Chrome launched");
            }else if(config.getProperty("browser").equals("firefox")){
                driver = new FirefoxDriver();
                log.debug("Firefox launched");
            }else if(config.getProperty("browser").equals("edge")){
                driver = new EdgeDriver();
                log.debug("Edge launched");
            }else if(config.getProperty("browser").equals("safari")){
                driver = new SafariDriver();
                log.debug("Safari launched");
            }
            driver.get(config.getProperty("testSiteUrl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
    }

    //common keywords
    //---------------------------------
    public boolean isElementDisplayed(By by){
        try{
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public static void click(String Locater){
        for(int i = 0; i < 3; i++) {
            try {
                if(Locater.endsWith("_XPATH")) {
                    driver.findElement(By.xpath(OR.getProperty(Locater))).click();
                } else if(Locater.endsWith("_CSS")){
                    driver.findElement(By.cssSelector(OR.getProperty(Locater))).click();
                } else if(Locater.endsWith("_ID")){
                    driver.findElement(By.id(OR.getProperty(Locater))).click();
                } else if(Locater.endsWith("_NAME")){
                    driver.findElement(By.name(OR.getProperty(Locater))).click();
                } else if(Locater.endsWith("_CLASSNAME")){
                    driver.findElement(By.className(OR.getProperty(Locater))).click();
                }
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                if(i == 2) throw e;
            }
        }
        log.debug("Clicking of an element "+Locater);
        test.log(LogStatus.INFO,"Clicked on "+Locater);
    }

    public static void type(String Locater, String value){
        if(Locater.endsWith("_XPATH")) {
            driver.findElement(By.xpath(OR.getProperty(Locater))).sendKeys(value);
        } else if(Locater.endsWith("_CSS")){
            driver.findElement(By.cssSelector(OR.getProperty(Locater))).sendKeys(value);
        } else if(Locater.endsWith("_ID")){
            driver.findElement(By.id(OR.getProperty(Locater))).sendKeys(value);
        } else if(Locater.endsWith("_NAME")){
            driver.findElement(By.name(OR.getProperty(Locater))).sendKeys(value);
        } else if(Locater.endsWith("_CLASSNAME")){
            driver.findElement(By.className(OR.getProperty(Locater))).sendKeys(value);
        }
        log.debug("Clicking of an element "+Locater+" and passing value as "+value);
        test.log(LogStatus.INFO, "Entered "+value+" in "+Locater);
    }

    public static void quit() {
        driver.quit();
        log.debug("Close the Browser.");
        test.log(LogStatus.INFO, "Browser closed");
    }


    public static void select( String Locater, String Value){
        if(Locater.endsWith("_XPATH")) {
            element = driver.findElement(By.xpath(OR.getProperty(Locater)));
        } else if(Locater.endsWith("_CSS")){
            element = driver.findElement(By.cssSelector(OR.getProperty(Locater)));
        } else if(Locater.endsWith("_ID")){
            element = driver.findElement(By.id(OR.getProperty(Locater)));
        } else if(Locater.endsWith("_NAME")){
            element = driver.findElement(By.name(OR.getProperty(Locater)));
        } else if(Locater.endsWith("_CLASSNAME")){
            element = driver.findElement(By.className(OR.getProperty(Locater)));
        }
        if(element.getTagName().equals("select")) {
            Select select = new Select(element);
            select.selectByVisibleText(Value);
        } else {
            // Handle custom dropdown
            element.click();
            try {
                Thread.sleep(1000); // Wait for dropdown to load
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Try multiple locator strategies
            try {
                driver.findElement(By.xpath("//lyte-drop-item[contains(text(),'" + Value + "')]")).click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                e.getStackTrace();
            }
        }
        log.debug("Select of an element "+Locater+" and choosing the value as "+Value);
        test.log(LogStatus.INFO, "Selected "+Value+" from "+Locater);
    }
}
