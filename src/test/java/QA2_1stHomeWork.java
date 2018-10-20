import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QA2_1stHomeWork {

    @Test
    public void credit() {

        AnuitetCredit aprekins = new AnuitetCredit();
        Methods loan = new Methods();

        double result[] = aprekins.Aprekins_10();
        double result8[] = aprekins.Aprekins_8();
        double result6[] = aprekins.Aprekins_6();
        System.out.format("\n AveragePayment %.2f\n\n", aprekins.averagePaymentTotal);

        Assertions.assertEquals(100000.0, loan.getLoan(), "this is true!");
        Assertions.assertEquals(755.33, Math.round(aprekins.averagePaymentTotal * 100) / 100D, "this is true!");

    }
}