import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    double loan = 10000;
    double months = 360;
    double approximateSumToPay = 1500;

    @Test
    public void credit() {
        AnnuityCredit calculation = new AnnuityCredit();

        calculation.annuityCreditCalculation();
        Assertions.assertEquals(approximateSumToPay, calculation.totalSumToPay, "This is not true!");
    }
}