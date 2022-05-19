package interactions.elements.tests;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Products;

//CLONE - Actions & Commands: Handle drop downs, checkbox, radio buttons
//2. Write 2 automation scripts for 2 different menus and/or pages in SUT where you would handle dropdown lists
//script 1
//3. Write 2 automation scripts for 2 different menus and/or pages in SUT where you would handle checkboxes
//script 1
public class Test_006 {

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
        //test dropdown and checkbox functionality
        Products.selectProductDD("Multiplay");
        Products.clickCheckBox();
        //Close app
        BasicSetup.closeD();


    }
}
