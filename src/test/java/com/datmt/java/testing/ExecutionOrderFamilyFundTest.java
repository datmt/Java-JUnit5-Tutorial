package com.datmt.java.testing;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExecutionOrderFamilyFundTest {

    private static final FamilyFund fund = new FamilyFund(200f);
    @Test
    @Order(2)
    void test_withdraw_on_shared_fund() {
        fund.withdraw(250f, WithdrawReason.EMERGENCY);
        assertEquals(50f, fund.getFund());
    }
    @Test
    @Order(1)
    void test_deposit_on_shared_fund() {
        fund.deposit(100f);
        assertEquals(300f, fund.getFund());
    }

    @Test
    @Order(3)
    void test_withdraw_small_amount() {
       fund.withdraw(10f, WithdrawReason.MOVIE_TICKET);

       assertEquals(40f, fund.getFund());
    }

}