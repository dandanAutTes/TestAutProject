package interactions.elements.testNG;

import interactions.elements.Pages.*;
import interactions.elements.data.TestData;
import interactions.elements.dataprovider.TestDataProvider;
import org.testng.annotations.*;

public class TestNG_003 {


    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        BasicSetup.setUp();
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
    }
    @Test(dataProvider = "getData1" , dataProviderClass = TestDataProvider.class)
    public void CreateOrder(TestData data) throws InterruptedException {
        //Search Order
        Orders.searchOrders();
        //Change list to all
        Orders.changeListAccounts();
        //Create the order
      // Orders.createNewOrder("Daniela B","27.1.2022");
       Orders.createNewOrder(data.firstvalue,data.secondvalue);

    }
    @AfterMethod
    public void afterTest()
    {
        BasicSetup.closeD();
    }
}
