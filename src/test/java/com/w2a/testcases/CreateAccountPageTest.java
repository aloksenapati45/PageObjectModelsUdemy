package com.w2a.testcases;

import com.w2a.base.Page;
import com.w2a.pages.CRM.CRMAccountsPage.CRM_HOMEPAGE_AccountTopMenu;
import com.w2a.pages.CRM.CRMAccountsPage.CreateAccountPage.ZOHO_CRM_CreateAccountPage;
import com.w2a.pages.CRM.CRMHomePage_SideMainMenuPage;
import com.w2a.pages.CRM.ZOHO_CRMHomepage_ModuleSideMenu;
import com.w2a.pages.Zoho_HomePage;
import com.w2a.utilites.Utilites;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Test(dataProviderClass = Utilites.class , dataProvider = "dp")
public class CreateAccountPageTest extends Page {

    public void createAccount(Hashtable<String,String> data){
        Zoho_HomePage zoho = new Zoho_HomePage();
        CRMHomePage_SideMainMenuPage crm = zoho.goToCRM();
        ZOHO_CRMHomepage_ModuleSideMenu crm1 = crm.goToModles();
        CRM_HOMEPAGE_AccountTopMenu topmeu = crm1.goToAccounts();
        ZOHO_CRM_CreateAccountPage create = topmeu.goToCreateAccount();
        create.accountName(data.get("accountName"));
        create.phone(data.get("phone"));
        create.accountSite(data.get("accountSite"));
        create.fax(data.get("fax"));
        create.parrentAccount(data.get("parrentAccount"));
        create.website(data.get("website"));
        create.accountNumber(data.get("accountNumber"));
        create.tickersymbol(data.get("tickersymbol"));
        create.employees(data.get("employees"));
        create.annualrevenue(data.get("annualrevenue"));
        create.siccode(data.get("siccode"));
    }

}
