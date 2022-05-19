package interactions.elements.tests;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Products;

//Create Product
public class Test_002 {


    public static void main(String[] args) throws InterruptedException {


        //This is a test case for creating product
        //setup the properties and driver
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Search product
        Products.searchProduct();
        //chage to all products
        Products.changeListProduct();
        //Create product
        Products.createProduct("Test Product 124","124");
        //Close app
        BasicSetup.closeD();


    }
}
