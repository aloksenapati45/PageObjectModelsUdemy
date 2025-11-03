package com.w2a.pages.CRM.CRMAccountsPage.CreateAccountPage;

import com.w2a.base.Page;

public class ZOHO_CRM_CreateAccountPage extends Page {

    public void accountName(String accountname) {
        type("accountnamefield_Xpath",accountname);
    }

    public void phone(String phone) {
        type("phonefield_XPATH", phone);
    }

    public void accountSite(String accountsite) {
        type("accountsitefield_XPATH", accountsite);
    }

    public void fax(String fax) {
        type("faxfield_XPATH", fax);
    }

    public void parrentAccount(String parrentaccount) {
        type("parrentaccountfield_XPATH", parrentaccount);
    }

    public void website(String website) {
        type("websitefield_XPATH", website);
    }

    public void accountNumber(String accountnumber) {
        type("accounnumberfield_Xpath", accountnumber);
    }

    public void tickersymbol(String tickersymbol) {
        type("tickersymbolfield_XPATH", tickersymbol);
    }

    public void accounttype(String accounttype) {
        select("accounttypedropdown_XPATH", accounttype);
    }

    public void ownerships(String ownerships) {
        select("ownershipdropdown_XPATH", ownerships);
    }

    public void industry(String industry) {
        select("industrydropdown_XPATH", industry);
    }

    public void employees(String employees) {
        type("employeesfield_XPATH", employees);
    }

    public void annualrevenue(String annualrevenue) {
        type("annualrevenufield_XPATH", annualrevenue);
    }

    public void siccode(String siccode) {
        type("siccodefield_XPATH", siccode);
    }

}
