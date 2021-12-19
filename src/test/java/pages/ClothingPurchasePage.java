package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ClothingPurchasePage extends BasePage {
    public ClothingPurchasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[2]")
    private WebElement discountInfo;

    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement sizeInput;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantityInput;

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addToCartButton;

    public void chooseSweaterSize(String size) {
        Select drpSize = new Select(sizeInput);
        drpSize.selectByVisibleText(size);
    }

    public void chooseSweaterQuantity(String quantity) {
        quantityInput.click();
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys(quantity);
    }

    public void addSweaterToCart(){
        addToCartButton.click();
    }

    public String getDiscountInfo() {
        return discountInfo.getText();
    }
}

