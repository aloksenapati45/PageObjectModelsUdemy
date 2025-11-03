package com.w2a.rough;

import com.w2a.pages.HomePage;
import com.w2a.pages.SignInPage;

public class LoginTest {
    public static void main(String[] args) {
        HomePage page = new HomePage();
        SignInPage signin = page.goToSignIn();
        signin.goToEmailAndMobileField("senapatiasish11@gmail.com");
        signin.goToNextButton();
        signin.goToPasswordField("Alok@7205767245");
        signin.goToSignInButton();
        System.out.println("Alok Alok");
    }
}
