package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a/img")
    private WebElement mainStoreMenuButton;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/article[2]/div/div[1]/h3/a")
    private WebElement sweaterPick;

    public void redirectToMainPage() {
        mainStoreMenuButton.click();
    }

    public void chooseProduct() {
        sweaterPick.click();
    }
}




