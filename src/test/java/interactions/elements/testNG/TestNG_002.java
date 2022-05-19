package interactions.elements.testNG;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Products;
import interactions.elements.data.TestData;
import interactions.elements.dataprovider.TestDataProvider;
import org.testng.annotations.*;

public class TestNG_002 {


    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        BasicSetup.setUp();
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
    }
    @Test(dataProvider = "getData" , dataProviderClass = TestDataProvider.class)
    public void CreateProduct(TestData data) throws InterruptedException {
        //Search product
        Products.searchProduct();
        //chage to all products
        Products.changeListProduct();
        //Create product
     //  Products.createProduct("Test Product 124","124");
        Products.createProduct(data.firstvalue,data.secondvalue);
    }
    @AfterMethod
    public void afterTest()
    {
        BasicSetup.closeD();
    }
}
