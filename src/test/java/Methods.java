import Driver.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Methods extends BaseTest {

    WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {

    }

    public MobileElement findElement(By by) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void assertPage(String message, String expectedValue, String actual) {

        Assert.assertEquals(message, expectedValue, actual);
        logger.info("Sayfa Kontrol Basarili Beklenen Deger :" + actual);

    }

    public void swipeDown() {
        Dimension size = appiumDriver.manage().window().getSize();
        int startY = (int) (size.height * 0.90);
        int endY = (int) (size.height * 0.10);
        int startX = (size.width / 2);
        for (int i = 0; i < 2; i++) {
            new TouchAction(appiumDriver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.
                            waitOptions(java.time
                                    .Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();
        }
    }
    public void swipeDownPage() {
        Dimension size = appiumDriver.manage().window().getSize();
        int startY = (int) (size.height * 0.80);
        int endY = (int) (size.height * 0.20);
        int startX = (size.width / 2);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.
                            waitOptions(java.time
                                    .Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();
            }


    public void clickRandomelementByXpath(String xpath) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        if (products.get(index).isDisplayed()) {
            products.get(index).click();
        }
    }
}
