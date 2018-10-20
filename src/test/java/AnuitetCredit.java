public class AnuitetCredit {
    double interest_10 = 10;
    double interest_8 = 8;
    double interest_6 = 6;
    double rootPower = 12;
    double months = 360;
    double paymentPerMonth;
    double interestPerMonth;
    double paymentBody;
    //double loan = 100000;
    int paymentNumber = 0;
    double averagePayment=0;
    double averagePaymentTotal;

    Methods loan = new Methods();

    public double[] Aprekins_10() {
        System.out.println("Nr.:  Percent per month(i):   AnuKoef(k):   PayemtPerMonth(a):    interesPerMonth:     paymentBody:         Balance:");

        double percentPerYear_10 = Math.pow((100 + interest_10) / 100, (1 / rootPower)) - 1;
        double test11_anuKoef_10 = (percentPerYear_10 * (Math.pow((1 + percentPerYear_10), months)) / ((Math.pow((1 + percentPerYear_10), months) - 1)));

        paymentPerMonth = test11_anuKoef_10 * loan.getLoan();
        for (int x = 1; x <= months * Math.pow(3, -1); x++) {
            interestPerMonth = percentPerYear_10 * loan.getLoan();
            paymentBody = paymentPerMonth - interestPerMonth;
            averagePayment = averagePayment+paymentPerMonth;
            loan.loan = loan.loan - paymentBody;
            paymentNumber++;
            System.out.printf(" %d." + "      %.6f" + "            %.5f " + "          %.2f " + "                %.2f " + "              %.2f " + "            %.2f \n", paymentNumber, percentPerYear_10, test11_anuKoef_10, paymentPerMonth, interestPerMonth, paymentBody, loan.loan);
        }
        return new double[]{percentPerYear_10, test11_anuKoef_10, paymentPerMonth, interestPerMonth, paymentBody, loan.loan};
    }

    public double[] Aprekins_8() {
        double percentPerYear_8 = Math.pow((100 + interest_8) / 100, (1 / rootPower)) - 1;
        double test11_anuKoef_8 = (percentPerYear_8 * (Math.pow((1 + percentPerYear_8), Math.round(months * 2 / 3)) / ((Math.pow((1 + percentPerYear_8), Math.round(months * 2 / 3)) - 1))));

        paymentPerMonth = test11_anuKoef_8 * loan.loan;
        for (int x = 1; x <= months * Math.pow(3, -1); x++) {
            interestPerMonth = percentPerYear_8 * loan.loan;
            paymentBody = paymentPerMonth - interestPerMonth;
            averagePayment = averagePayment+paymentPerMonth;
            loan.loan = loan.loan - paymentBody;
            paymentNumber++;

            System.out.printf(" %d." + "      %.6f" + "            %.5f " + "           %.2f " + "                %.2f " + "              %.2f " + "            %.2f \n", paymentNumber, percentPerYear_8, test11_anuKoef_8, paymentPerMonth, interestPerMonth, paymentBody, loan.loan);
        }
        return new double[]{percentPerYear_8, test11_anuKoef_8, paymentPerMonth, interestPerMonth, paymentBody, loan.loan};

    }

    public double[] Aprekins_6() {
        double percentPerYear_6 = Math.pow((100 + interest_6) / 100, (1 / rootPower)) - 1;
        double test11_anuKoef_6 = (percentPerYear_6 * (Math.pow((1 + percentPerYear_6), Math.round(months * 1 / 3)) / ((Math.pow((1 + percentPerYear_6), Math.round(months * 1 / 3)) - 1))));

        paymentPerMonth = test11_anuKoef_6 * loan.loan;
        for (int x = 1; x <= months * Math.pow(3, -1); x++) {

            interestPerMonth = percentPerYear_6 * loan.loan;
            paymentBody = paymentPerMonth - interestPerMonth;
            averagePayment = averagePayment+paymentPerMonth;
            averagePaymentTotal= averagePayment/months;
            loan.loan = loan.loan - paymentBody;
            paymentNumber++;
            System.out.printf(" %d." + "      %.6f" + "            %.5f " + "          %.2f " + "                %.2f " + "              %.2f " + "            %.2f \n", paymentNumber, percentPerYear_6, test11_anuKoef_6, paymentPerMonth, interestPerMonth, paymentBody, loan.loan);
        }
        return new double[]{percentPerYear_6, test11_anuKoef_6, paymentPerMonth, interestPerMonth, paymentBody, loan.loan};
    }
}
