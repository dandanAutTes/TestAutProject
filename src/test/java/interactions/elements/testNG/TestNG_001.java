package interactions.elements.testNG;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Products;
import interactions.elements.dataprovider.TestDataProvider;
import org.testng.annotations.*;

public class TestNG_001 {


    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        BasicSetup.setUp();
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
    }
    @Test(enabled = true)
    public void OpenProduct() throws InterruptedException {
        //Search product
        Products.searchProduct();
        Products.changeListProduct();
        //open product
        Products.openProduct();
    }
    @AfterMethod
    public void afterTest()
    {
        BasicSetup.closeD();
    }
}
