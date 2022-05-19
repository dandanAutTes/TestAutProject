package interactions.elements.tests;

import interactions.elements.Pages.Accounts;
import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;

public class Test_003 {

    public static void main(String[] args) throws InterruptedException {

        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Search Account
        Accounts.searchAccounts();
        Accounts.changeListAccounts();
        Accounts.openAccount();
        //close app
        BasicSetup.closeD();

    }
}
