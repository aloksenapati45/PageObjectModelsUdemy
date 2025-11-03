package com.w2a.pages;

import com.w2a.base.Page;
import org.openqa.selenium.By;

public class HomePage extends Page {

    public SignInPage goToSignIn(){
        click("signinlink_XPATH");
        return new SignInPage();
    }

    public void goToSignUp(){
        driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();
    }

    public void goToProducts(){
        driver.findElement(By.xpath("//li[@class='zwc-all-product']")).click();
    }

    public void goToEnterprise(){
        driver.findElement(By.xpath("(//a[contains(text(),'Enterprise')])[1]")).click();
    }

    public void goToCustomer(){
        driver.findElement(By.xpath("//div[normalize-space()='Customers']")).click();
    }

    public void goToPartners(){
        driver.findElement(By.xpath("//div[normalize-space()='Partners']")).click();
    }

    public void goToResources(){
        driver.findElement(By.xpath("//div[normalize-space()='Resources']")).click();
    }

    public void goToCRM(){
        driver.findElement(By.xpath("//span[normalize-space()='CRM']")).click();
    }

    public void goToMAil(){
        driver.findElement(By.xpath("//span[normalize-space()='Mail']")).click();
    }

    public void goToBooks(){
        driver.findElement(By.xpath("//span[normalize-space()='Books']")).click();
    }

    public void goToPeople(){
        driver.findElement(By.xpath("//span[normalize-space()='People']")).click();
    }

    public void goToDesk(){
        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
    }

    public void goToExploreAllProducts(){
        driver.findElement(By.xpath("//span[normalize-space()='Explore all products']")).click();
    }

    public void goToTryZOHOOne(){
        driver.findElement(By.xpath("//a[normalize-space()='Try zoho one']")).click();
    }

    public void goToCustomerStories(){
        driver.findElement(By.xpath("//a[@class='zwc-btn-nofill'][normalize-space()='Customer Stories']")).click();
    }

    public void goToExploreZIA(){
        driver.findElement(By.xpath("//a[normalize-space()='EXPLORE ZIA']")).click();
    }

    public void goToReadOurStory(){
        driver.findElement(By.xpath("//a[normalize-space()='Read our story']")).click();
    }
}
