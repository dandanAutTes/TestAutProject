package xpathpackage;

import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.LogIn;
import interactions.elements.Pages.Products;

public class FindXpath {

    public static void main(String[] args) throws InterruptedException {
        BasicSetup.setUp();
        //Login to saleceforce
        LogIn.LogSalesforce("team.seavus@partner-prod.com.vlocitysbx","seavusQA123!");
        //Search product
        Products.searchProduct();
        Products.changeListProduct();
        XpathClass.xpathfinder();
        BasicSetup.closeD();



    }
}
