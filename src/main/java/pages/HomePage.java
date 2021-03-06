package pages;

import com.google.inject.Inject;
import ensure.CustomPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div/div/a")
  public WebElement addToCartButton;

  @Inject
  public HomePage(WebDriver driver) throws IllegalAccessException {
    super(driver);
    CustomPageFactory.initElements(driver, this);
  }
}
