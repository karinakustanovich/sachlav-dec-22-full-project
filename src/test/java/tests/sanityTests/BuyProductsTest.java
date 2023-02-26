package tests.sanityTests;

import helpers.ApplicationURL;
import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

public class BuyProductsTest extends BaseTest {

    @Test
    public void buyProductsTest() {
        driver.get(ApplicationURL.BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        productsPage.validatePageTitle("PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(), ApplicationURL.BASE_URL + "/inventory.html");

        int productsAmount = productsPage.chooseProduct("Sauce Labs Backpack", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie");
        productsPage.validateNumberOfAddedItems(productsAmount);
        productsPage.goToCart();

        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.validatePageTitle("YOUR CART");
        yourCartPage.validateCartItemsAmount(productsAmount);
        yourCartPage.checkout();

        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutYourInformationPage.validatePageTitle("CHECKOUT: YOUR INFORMATION");
        checkoutYourInformationPage.fillCheckoutForm("Alex", "Komanov", "20100");
        checkoutYourInformationPage.continueToNextStep();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.validatePageTitle("CHECKOUT: OVERVIEW");
        checkoutOverviewPage.finishCheckout();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.validatePageTitle("CHECKOUT: COMPLETE!");
        checkoutCompletePage.validateCompleteHeader("THANK YOU FOR YOUR ORDER");


    }
}
