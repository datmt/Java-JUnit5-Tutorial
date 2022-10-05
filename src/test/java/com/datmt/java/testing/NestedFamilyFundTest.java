package com.datmt.java.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NestedFamilyFundTest {


    @Nested
    class TestWithdraw {

        private FamilyFund fund = new FamilyFund(100f);

        @Test
        @DisplayName("Test withdrawal")
        void testWithdrawInNestedClass() {
            fund.withdraw(10f, WithdrawReason.MOVIE_TICKET);
            assertEquals(90f, fund.getFund());
        }

    }

    @Nested
    class TestDeposit {

        private FamilyFund fund = new FamilyFund(100f);
        @Test
        @DisplayName("Test deposit")
        void testDepositInNestedClass() {
            fund.deposit(10f);
            assertEquals(110f, fund.getFund());
        }
    }

}