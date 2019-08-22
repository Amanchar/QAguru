package ThirdHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
    private BaseFunc baseFunc;

    private final By DRESSES = By.xpath("(.//a[contains(@title, 'Dresses')])[5]");
    private final By SUMMER_DRESSES = By.xpath("(.//a[contains(@title, 'Summer Dresses')])[2]");
    private final By EVENING_DRESSES = By.xpath("(.//a[contains(@title, 'Evening Dresses')])[2]");

    public MainPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public SummerDressesPage goToSummerDressesPage() {
        WebElement linkDresses = baseFunc.getElement(DRESSES);
        WebElement linkSummerDresses = baseFunc.getElement(EVENING_DRESSES);

        baseFunc.moveToElement(linkDresses).perform();
        baseFunc.waitForElementToBeClickable(SUMMER_DRESSES);
        baseFunc.moveToElement(linkSummerDresses).click().perform();

        return new SummerDressesPage(baseFunc);
    }
}
