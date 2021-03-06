package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import ensure.Ensure;
import ensure.Wait;
import org.openqa.selenium.JavascriptExecutor;
import webdriver.ChromeDriverManager;
import webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import webdriver.FirefoxDriverManager;
import webdriver.IEDriverManager;
import webdriver.DriverFactory;

public class DriverModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(DriverManager.class)
        .annotatedWith(Firefox.class)
        .to(FirefoxDriverManager.class)
        .in(Scopes.SINGLETON);

    bind(DriverManager.class)
        .annotatedWith(Chrome.class)
        .to(ChromeDriverManager.class)
        .in(Scopes.SINGLETON);

    bind(DriverManager.class)
        .annotatedWith(InternetExplorer.class)
        .to(IEDriverManager.class)
        .in(Scopes.SINGLETON);
  }

  @Provides
  public WebDriver getDriver() {
    return DriverFactory.getInstance().getDriver();
  }

  @Provides
  public Ensure getEnsure() {
    return new Ensure(DriverFactory.getInstance().getDriver());
  }

  @Provides
  public Wait getWait() {
    return new Wait(DriverFactory.getInstance().getDriver());
  }

  @Provides
  public JavascriptExecutor getJsExecutor() {
    return (JavascriptExecutor) DriverFactory.getInstance().getDriver();
  }

}
