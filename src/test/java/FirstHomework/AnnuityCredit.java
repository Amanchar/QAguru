package FirstHomework;

public class AnnuityCredit {
    Main values = new Main();

    double interest[] = {10, 8, 6};
    double totalPaymentPerMonth;
    double paymentInterest;
    double paymentBody;
    double periods = values.months;

    double totalSumToPay = 0;
    double roundedTotalSumToPay;
    int interestSelector;

    double balance = values.loan;

    public void annuityCreditCalculation() {
        for (int x = 0; x < values.months; x++) {
            if (x < values.months * 1 / 3) {
                interestSelector = 0;

            } else if (x >= values.months * 1 / 3 && x < values.months * 2 / 3) {
                interestSelector = 1;
                if (x == values.months * 1 / 3) {
                    periods = periods - (values.months * 1 / 3);
                    balance = values.loan;
                }
            } else if (x >= values.months * 2 / 3) {
                interestSelector = 2;
                if (x == values.months * 2 / 3) {
                    periods = periods - (values.months * 1 / 3);
                    balance = values.loan;
                }
            }
            double valueOfPercentPerMonth = Math.pow((100 + interest[interestSelector]) / 100, (1.0 / 12)) - 1;
            double valueOfAnnuity = (valueOfPercentPerMonth * (Math.pow((1 + valueOfPercentPerMonth), periods)) / ((Math.pow((1 + valueOfPercentPerMonth), periods) - 1)));

            totalPaymentPerMonth = valueOfAnnuity * balance;
            paymentInterest = valueOfPercentPerMonth * values.loan;

            paymentBody = totalPaymentPerMonth - paymentInterest;
            totalSumToPay = totalSumToPay + totalPaymentPerMonth;
            roundedTotalSumToPay = Math.round(totalSumToPay * 100)/100.0;
            values.loan = values.loan - paymentBody;
        }
    }
}
