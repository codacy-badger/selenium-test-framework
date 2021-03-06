package ensure;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public class CustomPageFactory {

  private CustomPageFactory() {
    throw new IllegalArgumentException("Custom Page Factory class");
  }

  @Inject
  public static <T> void initElements(WebDriver driver, T pageObject)
      throws IllegalAccessException {
    org.openqa.selenium.support.PageFactory.initElements(driver, pageObject);
    for (Field f : pageObject.getClass().getDeclaredFields()) {
      if (f.getType().equals(WebElement.class)) {
        boolean accessible = f.isAccessible();
        f.setAccessible(true);
        f.set(pageObject, ElementGuard.guard((WebElement) f.get(pageObject)));
        f.setAccessible(accessible);
      }
    }
  }
}
