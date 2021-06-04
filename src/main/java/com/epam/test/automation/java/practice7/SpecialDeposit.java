package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit {
    public SpecialDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal currentAmount = this.amount;
        for (int month = 1; month <= this.period; month++) {
            currentAmount = currentAmount.multiply(BigDecimal.valueOf(month / 100d)).add(currentAmount);
        }
        return currentAmount.subtract(this.amount).setScale(2, RoundingMode.HALF_EVEN);
    }
}

