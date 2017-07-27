import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;


public class FirstTest {

    public static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {
        File classPathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classPathRoot, "/app/Android");
        File app = new File(appDir, "Contacts.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Any Device Name");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
        desiredCapabilities.setCapability("appPackage", "com.jayway.contacts");
        desiredCapabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
        desiredCapabilities.setCapability("newCommandTimeout", 300);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.findElement(By.id(""));

        driver.manage().timeouts().implicitlyWait(5, SECONDS); // implicit wait

        WebDriverWait explicitWait = new WebDriverWait(driver, 30); // explicit wait
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("some_id")));

        // fluent wait
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = fluentWait.until(new com.google.common.base.Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.id("some_id"));
            }
        });
    }
}

// CTRL/CMD + ALT + L  - formatting code