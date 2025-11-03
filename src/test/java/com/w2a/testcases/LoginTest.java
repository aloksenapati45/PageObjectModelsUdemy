package com.w2a.testcases;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.SignInPage;
import com.w2a.utilites.Utilites;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends Page {

    @Test(dataProviderClass = Utilites.class, dataProvider = "dp")
    public void loginTest(Hashtable<String,String> data) {
        HomePage page = new HomePage();
        SignInPage signin = page.goToSignIn();
        signin.goToEmailAndMobileField(data.get("username"));
        signin.goToNextButton();
        signin.goToPasswordField(data.get("password"));
        signin.goToSignInButton();
    }

    @AfterSuite
    public void close(){
        quit();
    }

}
