package com.w2a.pages;

import com.w2a.base.Page;
import com.w2a.pages.CRM.CRMHomePage_SideMainMenuPage;
import org.openqa.selenium.By;

public class Zoho_HomePage extends Page {

    public void goToProfile(){
        driver.findElement(By.xpath("//img[@id='ztb-profile-image-pre']")).click();
    }
    public void goToSignOut(){
        driver.findElement(By.xpath("//a[@id='ztb-signout']")).click();
    }
    public void goToCalender(){
        driver.findElement(By.xpath("//div[contains(text(),'Calendar')]")).click();
    }
    public void goToCliq(){
        driver.findElement(By.xpath("//div[contains(text(),'Cliq')]")).click();
    }
    public CRMHomePage_SideMainMenuPage goToCRM(){
        driver.findElement(By.xpath("//div[contains(text(),'CRM')]")).click();
        return new CRMHomePage_SideMainMenuPage();
    }
    public void goToDesk(){
        driver.findElement(By.xpath("//div[contains(text(), 'Desk')]")).click();
    }
    public void goToMail(){
        driver.findElement(By.xpath("//div[contains(text(), 'Mail')]")).click();
    }
    public void goToPeople(){
        driver.findElement(By.xpath("//div[contains(text(), 'People')]")).click();
    }
}
