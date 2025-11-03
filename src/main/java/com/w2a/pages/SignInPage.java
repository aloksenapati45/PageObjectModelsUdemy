package com.w2a.pages;

import com.w2a.base.Page;
import org.openqa.selenium.By;

public class SignInPage extends Page {

    public void goToEmailAndMobileField(String Email){
        type("emailfield_XPATH",Email);
    }

    public void goToNextButton(){
        click("nextbuttonlink_XPATH");
    }

    public void goToPasswordField(String Password){
        type("passwordfield_XPATH",Password);
    }

    public Zoho_HomePage goToSignInButton(){
        click("signinbuttonlink_XPATH");
        return new Zoho_HomePage();
    }

    public void goToSignInUsingEmailOTP(){
        driver.findElement(By.xpath("//div[@id='enablemore']//span[@class='bluetext_action showmoresigininoption'][normalize-space()='Sign in using email OTP']")).click();
    }

    public void goToForgotPassword(){
        driver.findElement(By.xpath("//form[@id='login']//div[@id='enablemore']//span[@id='blueforgotpassword']")).click();
    }

    public void goToChangeEmail(){
        driver.findElement(By.xpath("//div[@id='password_container']//span[@class='Notyou bluetext'][normalize-space()='Change']")).click();
    }

    public void goToSignUpNow(){
        driver.findElement(By.xpath("//span[@class='blue_link signuptrigger']")).click();
    }
}
