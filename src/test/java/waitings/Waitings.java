package waitings;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Waitings {

    public static void main(String[] args) {

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
//
//        // Waiting 30 seconds for an element to be present on the page, checking
//        // for its presence once every 5 seconds.
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(30, SECONDS)
//                .pollingEvery(5, SECONDS)
//                .ignoring(NoSuchElementException.class);
//
//        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.id("foo"));
//            }
//        });
    }
}
