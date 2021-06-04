package com.epam.test.automation.java.practice7;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class DepositTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionWhenDepositIsNull() {
        new BaseDeposit(null, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionWhenPeriodIs0() {
        new BaseDeposit(new BigDecimal(1000), 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionWhenPeriodIsLessThan0() {
        new BaseDeposit(new BigDecimal(1000), -1);
    }

    @Test
    public void testGetAmount(){
        Deposit deposit = new BaseDeposit(new BigDecimal(1000), 2);
        Assert.assertEquals(deposit.getAmount(), new BigDecimal(1000));
    }

    @Test
    public void testGetPeriod(){
        Deposit deposit = new BaseDeposit(new BigDecimal(1000), 2);
        Assert.assertEquals(deposit.getPeriod(), 2);
    }
}