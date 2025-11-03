package com.w2a.pages.CRM.CRMAccountsPage;

import com.w2a.base.Page;
import com.w2a.pages.CRM.CRMAccountsPage.CreateAccountPage.ZOHO_CRM_CreateAccountPage;

public class CRM_HOMEPAGE_AccountTopMenu extends Page {

    public void goToAllAccountsDropDown(){
        select("allacountsdropdown_XPATH","All Accounts");
    }

    public void goToRecordsView(){
        select("recordsviewdropdown_XPATH","List View");
    }

    public ZOHO_CRM_CreateAccountPage goToCreateAccount(){
        click("createaccountbutton_XPATH");
        return new ZOHO_CRM_CreateAccountPage();
    }

    public void goToCreateAccountDropDownImportAccounts(){
        select("createaccountdropdown_XPATH","Import Accounts");
    }

    public void goToCreateAccountDropDownImportNotes(){
        select("createaccountdropdown_XPATH", "Import Notes");
    }

}
