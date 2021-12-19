package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;
import pages.ClothingPurchasePage;
import pages.LogInPage;
import pages.MainPage;


public class SweaterPurchaseTest extends BaseTest {
    @Test
    public void shouldPurchaseSweaterAndTakeScreenshot() throws Exception {
        //logowanie
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        LogInPage loginPage = new LogInPage(driver);
        loginPage.enterEmail("kacpermalczewski@zz.com");
        loginPage.enterPassword("haslozz1");
        loginPage.logIntoAccount();

        //wybieranie swetra
        MainPage mainPage = new MainPage(driver);
        mainPage.redirectToMainPage();
        mainPage.chooseProduct();

        //sprawdzanie zniżki
        ClothingPurchasePage clothingSearchPage = new ClothingPurchasePage(driver);
        Assert.assertTrue(clothingSearchPage.getDiscountInfo().contains("20%"));

        //wybieranie parametrów zamówienia i dodanie go do koszyka
        clothingSearchPage.chooseSweaterSize("M");
        clothingSearchPage.chooseSweaterQuantity("5");
        clothingSearchPage.addSweaterToCart();

        //przechodzenie przez poszczególne kroki Checkoutu i potwierdzenie zamówienia
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckoutButtonClick();
        checkoutPage.chooseAvailableAddress();
        checkoutPage.chooseShippingMethod();
        checkoutPage.choosePaymentMethod();
        checkoutPage.confirmOrder();

        //robienie screenshota zamówienia
        checkoutPage.takeOrderScreenShot();


    }
}
