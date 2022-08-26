package Netology.Multithread_Functional.TDD_DDD.TDD;

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

    public double calculateMonthlyPayment() {
        return 0;
    }

    public double calculateOverpayment() {
        return 0;
    }

    public double calculateEntirePayment() {
        return 0;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
