package interactions.elements.testNG;

import interactions.elements.Pages.Accounts;
import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.Contacts;
import interactions.elements.Pages.LogIn;
import interactions.elements.data.TestData;
import interactions.elements.dataprovider.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_005 {
    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        BasicSetup.setUp();
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
    }
    @Test
    public void OpenAccount() throws InterruptedException {
        //Search Account
        Accounts.searchAccounts();
        Accounts.changeListAccounts();
        Accounts.openAccount();

    }
    @AfterMethod
    public void afterTest()
    {
        BasicSetup.closeD();
    }
}
