import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;


public class FirstTest {

    public static AppiumDriver<MobileElement> driver;
    protected static Platform platform = Platform.ANDROID;
    protected static MobileElement searchField;


    enum Platform {
        ANDROID,
        IOS
    }

    public static void main(String[] args) throws MalformedURLException {

        if (platform.equals(Platform.IOS)) {
            File classPathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classPathRoot, "/app/iOS");
            File app = new File(appDir, "ContactsSimulator.app");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Simulator");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "51FE988D-80C8-4963-8E39-B6672489190D");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
            desiredCapabilities.setCapability("newCommandTimeout", 300);

            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(5, SECONDS); // implicit wait
        } else if (platform.equals(Platform.ANDROID)) {
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
        }


        if (platform.equals(Platform.ANDROID)) {
            searchField = driver.findElement(By.id("main_search"));
        } else {
            searchField = driver.findElement(By.id("ID_ON_IOS"));
        }
        searchField.setValue("Joy S");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // my code
        }

        List<MobileElement> name = driver.findElements(By.id("name"));
        Assert.assertEquals(name.size(), 1);

        for (MobileElement element : name) {
            if (element.getText().equals("Joy Stclair")) {

                element.click();
            }
        }

        driver.findElement(By.xpath("//*[@resource-id='android:id/content']//android.widget.ImageView"));
        driver.findElement(By.className("android.widget.ImageView"));
    }
}

// CTRL/CMD + ALT + L  - formatting code