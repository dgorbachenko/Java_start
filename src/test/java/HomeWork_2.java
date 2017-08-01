import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by gdv on 31.07.2017.
 */
public class HomeWork_2 {
    public static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        File classPathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classPathRoot, "/app/Android");
        File app = new File(appDir, "Contacts.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "NEXUS");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
        desiredCapabilities.setCapability("appPackage", "com.jayway.contacts");
        desiredCapabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
        desiredCapabilities.setCapability("newCommandTimeout", 300);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



        /**Home_work 1 test**/
//        List<MobileElement> contacsNameFirst = driver.findElements(By.id("name"));
//        for (MobileElement element : contacsNameFirst) {
//            element.click();
//        }

        /**Home_work 2 test. Проверить что информация отображена корректно, использовав className, id и xpath.*/


        /**Home_work 3 test. Протестировать поле поиска - один позитивный и один негативный сценарии.*/

        MobileElement search = driver.findElement(By.id("main_search")); // негативный кейс
        search.setValue("12345");
        driver.findElement(By.id("main_text"));
        System.out.println("Ошибка");

    }

}
