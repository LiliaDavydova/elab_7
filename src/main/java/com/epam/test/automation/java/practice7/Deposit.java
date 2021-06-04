package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;

public abstract class Deposit {
    public final BigDecimal amount;
    public final int period;

    protected Deposit(BigDecimal amount, int period) {
        if (amount == null || period <= 0) {
            throw new IllegalArgumentException();
        }
        this.amount = amount;
        this.period = period;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract BigDecimal income();

}

