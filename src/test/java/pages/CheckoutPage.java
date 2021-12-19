package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckoutButtonPopOut;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = ".address-item.selected")
    private WebElement chooseAddress;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddresses;

    @FindBy(css = "#delivery_option_1")
    private WebElement shippingMethod;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmShippingMethod;

    @FindBy(id = "payment-option-1")
    private WebElement paymentMethod;

    @FindBy(name = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsAgreement;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement orderConfirm;

    public void proceedToCheckoutButtonClick() {
        proceedToCheckoutButtonPopOut.click();
        proceedToCheckoutButton.click();
    }

    public void chooseAvailableAddress() {
        if (chooseAddress.isSelected()) {
            confirmAddresses.click();
        } else {
            chooseAddress.click();
            confirmAddresses.click();
        }
    }

    public void chooseShippingMethod() {
        if (shippingMethod.isSelected()) {
            confirmShippingMethod.click();
        } else {
            shippingMethod.click();
            confirmShippingMethod.click();
        }
    }

    public void choosePaymentMethod() {
        if (paymentMethod.isSelected()) {
            termsAgreement.click();
        } else {
            paymentMethod.click();
            termsAgreement.click();
        }
    }

    public void confirmOrder () {
        orderConfirm.click();
    }

    public void takeOrderScreenShot () throws Exception {
        TakesScreenshot ts = ((TakesScreenshot) driver);
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./src/test/screenshots/screenshot.png"));
    }

    }
