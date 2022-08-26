package Netology.Multithread_Functional.TDD_DDD.TDD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class CreditCalculator {
    private int creditAmount;
    private int creditPeriod;
    private double interestRate;

    public CreditCalculator setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
        return this;
    }

    public CreditCalculator setCreditPeriod(int creditPeriod) {
        this.creditPeriod = creditPeriod;
        return this;
    }

    public CreditCalculator setInterestRate(double interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public BigDecimal calculateMonthlyPayment() {
        if (creditAmount <= 0 || interestRate <= 0 || creditPeriod <= 0) return new BigDecimal(0);
        double ps = interestRate / (100 * 12);
        return
                new BigDecimal(creditAmount * (ps / (1 - Math.pow((1 + ps), creditPeriod * -1)))).setScale(2, RoundingMode.UP);
    }

    public BigDecimal calculateOverpayment() {
        if (creditAmount <= 0 || interestRate <= 0 || creditPeriod <= 0) return new BigDecimal(0);
        return calculateEntirePayment().subtract(new BigDecimal(creditAmount));
    }

    public BigDecimal calculateEntirePayment() {
        if (creditAmount <= 0 || interestRate <= 0 || creditPeriod <= 0) return new BigDecimal(0);
        return calculateMonthlyPayment().multiply(new BigDecimal(creditPeriod));
    }



    public String getCalculate() {
        return String.format(
                "Расчет ежемесячного аннуитетного платежа по кредиту(без округлений, страховок и скрытых %%): \n" +
                        "Сумма кредита: %s руб.\n" +
                        "Срок кредита: %s месяцев\n" +
                        "Процентная ставка: %s %%\n" +
                        "Ежемесячный платеж: %s руб.\n" +
                        "Сумма переплаты за весь период: %s руб.\n" +
                        "Общая сумма всех выплат: %s руб.\n",
                creditAmount,
                creditPeriod,
                interestRate,
                calculateMonthlyPayment(),
                calculateOverpayment(),
                calculateEntirePayment());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCalculator)) return false;
        CreditCalculator that = (CreditCalculator) o;
        return creditAmount == that.creditAmount && creditPeriod == that.creditPeriod && interestRate == that.interestRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditAmount, creditPeriod, interestRate);
    }

}
