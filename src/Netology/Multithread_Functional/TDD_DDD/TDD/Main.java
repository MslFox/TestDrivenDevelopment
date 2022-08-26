package Netology.Multithread_Functional.TDD_DDD.TDD;

public class Main {
    public static void main(String[] args) {
        CreditCalculator creditCalculator = new CreditCalculator();
        System.out.println(
                creditCalculator
                        .setCreditPeriod(12)
                        .setCreditAmount(90_000_000)
                        .setInterestRate(12)
                        .getCalculate());

        System.out.println(
                creditCalculator
                        .setCreditPeriod(36)
                        .setCreditAmount(20000)
                        .setInterestRate(5.5)
                        .getCalculate());

    }
}
