package com.w2a.pages.CRM;

import com.w2a.base.Page;
import com.w2a.pages.CRM.CRMAccountsPage.CRM_HOMEPAGE_AccountTopMenu;

public class ZOHO_CRMHomepage_ModuleSideMenu extends Page {

    public void goToSearch(){
        click("searchbutton_XPATH");
    }

    public void goToHome(){
        click("homebutton_XPATH");
    }

    public void goToLeads(){
        click("leadsbutton_XPATH");

    }

    public void goToContacts(){
        click("contactsbutton_XPATH");

    }

    public CRM_HOMEPAGE_AccountTopMenu goToAccounts(){
        click("accountsbutton_XPATH");
        return new CRM_HOMEPAGE_AccountTopMenu();
    }

    public void goToDeals(){
        click("dealsbutton_XPATH");

    }

    public void goToForecasts(){
        click("forecastsbutton_XPATH");

    }

    public void goToDocuments(){
        click("documentsbutton_XPATH");

    }

    public void goToCampaigns(){

    }

}
