package com.datmt.java.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatedFamilyFundTest {

    @RepeatedTest(5)
    @DisplayName("This test will run multiple time")
    void test_repeated_withdrawal() {
        var fund = new FamilyFund(10f);

        fund.withdraw(10f, WithdrawReason.MOVIE_TICKET);

        assertEquals(0f, fund.getFund());
    }
}
