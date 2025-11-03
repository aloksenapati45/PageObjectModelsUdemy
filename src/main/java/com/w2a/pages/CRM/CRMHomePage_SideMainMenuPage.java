package com.w2a.pages.CRM;

import com.w2a.base.Page;

public class CRMHomePage_SideMainMenuPage extends Page {

    public ZOHO_CRMHomepage_ModuleSideMenu goToModles(){
        click("modulebutton_CSS");
        return new ZOHO_CRMHomepage_ModuleSideMenu();
    }

    public void goToReports(){
        click("reportbutton_CSS");

    }

    public void goToAnalytics(){
        click("analyticsbutton_CSS");
    }

    public void goToMyRequests(){
        click("myrequestbutton_CSS");
    }

    public void goToMarketplace(){
        click("marketplacebutton_CSS");

    }

    public void goToSearchaRecord(){
        click("searchrecordbutton_CSS");

    }

    public void goToAskZIA(){

    }

    public void goToAddNew(){

    }

    public void goToCalender(){

    }

    public void goToSignals(){

    }

    public void goToSettings(){

    }

    public void goToProfiles(){

    }

    public void goToZOHOApp(){

    }

}
