package FourthHomework;
import FourthHomework.Pages.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class DateAndNameTest {

    private BaseFunc baseFunc = new BaseFunc();

    private final String PAGE_DELFI = "delfi.lv";
    private final String PAGE_DAVANAS = "visasdavanas.lv/vardadienas";

    @Test
    public void dateAndTimeTest() {

        baseFunc.goToPage(PAGE_DELFI);
        DelfiPage delfiPage = new DelfiPage(baseFunc);

        Assertions.assertEquals(delfiPage.getDelfiDate(), delfiPage.getLocalDate(), "THEY ARE NOT EQUAL!!!!");
        List<String> delfiNames = delfiPage.getDelfiNames();

        baseFunc.goToPage(PAGE_DAVANAS);
        DavanasPage davanasPage = new DavanasPage(baseFunc);

        Assertions.assertEquals(delfiNames, davanasPage.getDavanasNames(), "ARE NOT EQUALS!!!");
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }

}
