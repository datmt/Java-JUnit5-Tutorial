package com.datmt.java.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedFamilyFundTest {

    @ParameterizedTest
    @ValueSource(floats= {10f, 20f, 40f})
    void test_withdraw(float amount) {
        var fund = new FamilyFund(100);

        assertDoesNotThrow(() -> fund.withdraw(amount, WithdrawReason.EMERGENCY));

    }

    @ParameterizedTest
    @CsvSource({"Jane, 100", "Jack, 2000"})
    void test_using_csv(String name, float amount) {

        System.out.println(name + " has " + amount);

    }


    @ParameterizedTest
    @CsvFileSource(resources= "p1.csv")
    void test_using_csv_file(String name, float amount) {

        System.out.println(name + " has " + amount);

    }
}
