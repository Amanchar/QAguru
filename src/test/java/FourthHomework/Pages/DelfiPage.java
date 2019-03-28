package FourthHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.*;

public class DelfiPage {
    private BaseFunc baseFunc;

    private final By DATE = By.xpath(".//*[@class='d-flex']/section/time");
    private final By NAMES = By.xpath(".//*[@class='d-flex']/section/a");

    public DelfiPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getDelfiDate() {
        WebElement dateElement = baseFunc.getElement(DATE);
        return dateElement.getAttribute("datetime");
    }

    public String getLocalDate() {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dtf.format(date);
    }

    public List<String> getDelfiNames() {
        WebElement namesDelfiElement = baseFunc.getElement(NAMES);
        String namesString = namesDelfiElement.getText();
        List<String> splitedDelfiNames = new ArrayList<String>(Arrays.asList(namesString.split(", ")));

        Collections.sort(splitedDelfiNames);
        return splitedDelfiNames;
    }

}