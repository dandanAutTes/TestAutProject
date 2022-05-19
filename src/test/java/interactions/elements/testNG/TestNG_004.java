package interactions.elements.testNG;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.Contacts;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Orders;
import interactions.elements.data.TestData;
import interactions.elements.dataprovider.TestDataProvider;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_004 {


    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        BasicSetup.setUp();
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
    }
    @Test(enabled = true)
    public void NewContract() throws InterruptedException {

        //simulate SKIP
        boolean DataAvailable=false;
        if(!DataAvailable) {
            throw new SkipException("Skipping this exception");
        }
        //Search Contact
        Contacts.searchContacts();
        BasicSetup.waitRandom(5000);
        Contacts.changeListContacts();
        BasicSetup.waitRandom(5000);
        //Create the contact
        Contacts.createNewContact("Test db","Daniela B");
       // Contacts.createNewContact(data.User,data.User);

    }
    @AfterMethod
    public void afterTest()
    {
        BasicSetup.closeD();
    }
}
