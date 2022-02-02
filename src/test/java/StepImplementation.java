import Driver.BaseTest;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;


public class StepImplementation extends BaseTest {
    Methods methods = new Methods();

    @Step("<time> saniye kadar bekle")
    public void waitForSeconds(int time) throws InterruptedException {
        Thread.sleep(time * 1000L);
    }

    @Step("xpath <xpath> li elemente tıkla")
    public void clickElement(String xpath) {
        methods.click(By.xpath(xpath));
    }

    @Step("id <id> li elemente tıkla")
    public void clickById(String id) {
        methods.click(By.id(id));
    }

    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void pageControlById(String id, String text) {
        String actualValue = methods.findElement(By.id(id)).getText();
        methods.assertPage("Sayfa Kontrolu Basarili degil", text, actualValue);

    }

    @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
    public void pageControlByXpath(String xpath, String text) {
        String actualValue = methods.findElement(By.xpath(xpath)).getText();
        methods.assertPage("Sayfa Kontrolu Basarili degil", actualValue, text);
    }

    @Step("Sayfayı aşağı kaydır")
    public void swipeDown() {
        methods.swipeDown();
    }
    @Step("Sayfayı biraz aşağı kaydır")
    public void swipeDownPage() {
        methods.swipeDownPage();
    }
    @Step("Elementler <xpath> arasından rastgele bir tanesini seç ve tıkla")
    public void clickRandomelement(String xpath) {
        methods.clickRandomelementByXpath(xpath);
    }

    @Step("id <name> li ementi bul ve <value> değerini yaz")
    public void sendkeysByid(String id, String text) {
        methods.sendKeys(By.id(id), text);
    }
}
