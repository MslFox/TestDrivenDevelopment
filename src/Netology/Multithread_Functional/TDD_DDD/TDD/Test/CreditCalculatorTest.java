package Netology.Multithread_Functional.TDD_DDD.TDD.Test;

import Netology.Multithread_Functional.TDD_DDD.TDD.CreditCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Objects;

class CreditCalculatorTest {
    private final CreditCalculator creditCalculator = new CreditCalculator();

    @ParameterizedTest
    @CsvSource(value = {" 10, 10, 10 "})
    void settersTest(int creditAmount, int creditPeriod, double interestRate) {
        creditCalculator.setCreditAmount(creditAmount)
                .setInterestRate(interestRate)
                .setCreditPeriod(creditPeriod);
        Assertions.assertEquals(Objects.hash(creditAmount, creditPeriod, interestRate), creditCalculator.hashCode());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0 ,0",
            "-20000, 36, 12 , 0",
            "20000, -36, 12 , 0",
            "20000, 36, -12 , 0",
            "90_000_000, 16, 11.5, 6094124.39"
    })
    void calculateMonthlyPaymentTest(int creditAmount, int creditPeriod, double interestRate, BigDecimal expected) {
        creditCalculator.setCreditAmount(creditAmount)
                .setCreditPeriod(creditPeriod)
                .setInterestRate(interestRate);
        Assertions.assertEquals(expected, creditCalculator.calculateMonthlyPayment());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0 ,0",
            "20000, 36, 12 ,3914.44",
            "-20000, 36, 12 , 0",
            "20000, -36, 12 , 0",
            "20000, 36, -12 , 0",
            "90_000_000, 16, 11.5, 7505990.24"
    })
    void calculateOverpaymentTest(int creditAmount, int creditPeriod, double interestRate, BigDecimal expected) {
        creditCalculator.setCreditAmount(creditAmount)
                .setCreditPeriod(creditPeriod)
                .setInterestRate(interestRate);
        Assertions.assertEquals(expected, creditCalculator.calculateOverpayment());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0 ,0",
            "20000, 36, 12 , 23914.44",
            "-20000, 36, 12 , 0",
            "20000, -36, 12 , 0",
            "20000, 36, -12 , 0",
            "90_000_000, 16, 11.5, 97505990.24"
    })
    void calculateEntirePayment(int creditAmount, int creditPeriod, double interestRate, BigDecimal expected) {
        creditCalculator.setCreditAmount(creditAmount)
                .setCreditPeriod(creditPeriod)
                .setInterestRate(interestRate);
        Assertions.assertEquals(expected, creditCalculator.calculateEntirePayment());
    }
}