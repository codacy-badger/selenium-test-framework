package pages;

import com.google.inject.Inject;
import ensure.InternalPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  @FindBy(xpath = "//*[text()='Get Started']")
  public WebElement addToCartButton;

  @Inject
  public HomePage(WebDriver driver) throws IllegalAccessException {
    super(driver);
    InternalPageFactory.initElements(driver, this);
  }
}
