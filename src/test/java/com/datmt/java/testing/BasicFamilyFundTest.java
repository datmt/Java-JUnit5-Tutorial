package com.datmt.java.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicFamilyFundTest {

    @Test
    void testDepositAndWithdraw() {
        var fund = new FamilyFund(100f);
        fund.deposit(100f);

        assertEquals(200f, fund.getFund(), "Init  100 + deposit 100 should be 200");
    }

    @Test
    void test_fund_is_not_for_gambling() {
        var fund = new FamilyFund(100f);
        assertThrows(RuntimeException.class, () -> {
            fund.withdraw(0f, WithdrawReason.GAMBLING);
        });
    }

    @Test
    @DisplayName("You cannot withdraw more than the available fund")
    void test_cannot_withdraw_more_than_available_fund() {
        var fund = new FamilyFund(100f);
        assertThrows(AssertionError.class, () -> {
            fund.withdraw(200f, WithdrawReason.EMERGENCY);
        });
    }


    @Test
    @DisplayName("Withdrawals cannot exceed allowed budget")
    void test_cannot_withdraw_more_than_allowed_budget() {
        var fund = new FamilyFund(1000f);
        assertThrows(AssertionError.class, () -> {
            fund.withdraw(200f, WithdrawReason.FOOD);
        });

        assertThrows(AssertionError.class, () -> {
            fund.withdraw(20f, WithdrawReason.MOVIE_TICKET);
        });

        fund.withdraw(10f, WithdrawReason.MOVIE_TICKET);
        assertEquals(990f, fund.getFund(), "Fund should be 990f after withdrawing 10f for movies");

        fund.withdraw(90f, WithdrawReason.FOOD);
        assertEquals(900f, fund.getFund(), "Fund should be 810f after withdrawing 90f for food");
    }
}