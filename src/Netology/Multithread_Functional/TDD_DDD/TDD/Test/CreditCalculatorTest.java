package Netology.Multithread_Functional.TDD_DDD.TDD.Test;

import Netology.Multithread_Functional.TDD_DDD.TDD.CreditCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

class CreditCalculatorTest {
    private final CreditCalculator creditCalculator = new CreditCalculator();

    @ParameterizedTest
    @CsvSource(value = {" 10, 10, 10 "})
    void settersTest(int amount, int period, double rate) {
        creditCalculator.setCreditAmount(amount);
        creditCalculator.setCreditPeriod(period);
        creditCalculator.setInterestRate(rate);
        Assertions.assertEquals(Objects.hash(amount, period, rate), creditCalculator.hashCode());
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0 ,0"})
    void calculateMonthlyPaymentTest(int amount, int period, double rate, double expected) {
        creditCalculator.setCreditAmount(amount)
                .setCreditPeriod(period)
                .setInterestRate(rate);
        Assertions.assertEquals(expected, creditCalculator.calculateMonthlyPayment());
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0, 0 "})
    void calculateOverpaymentTest(int amount, int period, double rate, double expected) {
        creditCalculator.setCreditAmount(amount)
                .setCreditPeriod(period)
                .setInterestRate(rate);
        Assertions.assertEquals(expected, creditCalculator.calculateOverpayment());
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 0, 0 "})
    void calculateEntirePayment(int amount, int period, double rate, double expected) {
        creditCalculator.setCreditAmount(amount)
                .setCreditPeriod(period)
                .setInterestRate(rate);
        Assertions.assertEquals(expected, creditCalculator.calculateEntirePayment());
    }
}