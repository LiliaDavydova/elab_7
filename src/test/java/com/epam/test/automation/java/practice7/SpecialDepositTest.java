package com.epam.test.automation.java.practice7;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDepositTest {

    @Test
    public void testSpecialDeposit1Month() {
        SpecialDeposit specialDeposit = new SpecialDeposit(new BigDecimal(1000.00), 1);
        specialDeposit.income();
        Assert.assertEquals(specialDeposit.income(), new BigDecimal(10.00).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testSpecialDeposit8Month() {
        SpecialDeposit specialDeposit = new SpecialDeposit(new BigDecimal(1000.00), 4);
        specialDeposit.income();
        Assert.assertEquals(specialDeposit.income(), new BigDecimal(103.55).setScale(2, RoundingMode.HALF_EVEN));
    }
}