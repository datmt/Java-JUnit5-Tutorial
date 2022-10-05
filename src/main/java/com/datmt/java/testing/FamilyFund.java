package com.datmt.java.testing;

import java.util.Map;

public class FamilyFund {
    private float fund = 0f;
    private Map<WithdrawReason, Float> reasonBudget = Map.of(
            WithdrawReason.EMERGENCY, Float.MAX_VALUE,
            WithdrawReason.FOOD, 100f,
            WithdrawReason.MOVIE_TICKET, 10f,
            WithdrawReason.GAMBLING, 0f
    );

    public FamilyFund(float initialFund) {
        this.fund = initialFund;
    }


    public void setReasonBudget(Map<WithdrawReason, Float> reasonBudget) {
        this.reasonBudget = reasonBudget;
    }

    public synchronized void deposit(float amount) {
        assert amount > 0;
        this.fund += amount;
    }

    public void withdraw(float amount, WithdrawReason reason) {

        assert amount <= fund;
        assert amount <= reasonBudget.get(reason);
        if (reason.equals(WithdrawReason.GAMBLING)) {
            throw new RuntimeException("You SOB!");
        }

        fund -= amount;
    }

    public float getFund() {
        return fund;
    }
}
