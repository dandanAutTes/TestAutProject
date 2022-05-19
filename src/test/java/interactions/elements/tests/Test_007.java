package interactions.elements.tests;

import interactions.elements.Pages.Accounts;
import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;

//combo box x1
//check box x1
public class Test_007 {

    public static void main(String[] args) throws InterruptedException {

        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Search Account
        Accounts.searchAccounts();
        Accounts.changeListAccounts();
        //test checkbox and combobox functionality
        Accounts.accountInteract();


        //close app
        BasicSetup.closeD();

    }
}
