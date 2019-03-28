package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
    BaseFunc baseFunc;

    private final By WOMEN = By.xpath("(.//a[contains(@class, 'sf-with-')])[1]");
    private final By DRESSES = By.xpath("(.//a[contains(@class, 'sf-with-')])[3]");

    public MainPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public DressesPage goToDressesPage() {
        WebElement linkWomen = baseFunc.getElement(WOMEN);
        WebElement linkDresses = baseFunc.getElement(DRESSES);
        baseFunc.moveToElement(linkWomen).perform();
        baseFunc.waitTime();
        baseFunc.moveToElement(linkDresses).click().perform();

        return new DressesPage(baseFunc);
    }
}
