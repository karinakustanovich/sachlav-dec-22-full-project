package successTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class SuccessTests extends test.BaseTest {


    @Test(dataProvider = "getData", description = "Group of successful login tests")
    public void testSuccessLogin(String username, String password) {

        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login(username, password);
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(), "https://www.saucedemo.com/inventory.html");

    }


    
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }
}