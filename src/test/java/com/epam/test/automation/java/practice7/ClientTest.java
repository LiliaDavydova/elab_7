package com.epam.test.automation.java.practice7;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ClientTest {


    @Test
    public void testAddDepositTrue() {
        Deposit longDeposit = new LongDeposit(new BigDecimal(3200.00), 5);
        Deposit baseDeposit = new BaseDeposit(new BigDecimal(4000.00), 6);
        Client client = new Client();
        Assert.assertTrue(client.addDeposit(longDeposit));
        Assert.assertTrue(client.addDeposit(baseDeposit));
        Assert.assertEquals(client.getDeposits()[0], longDeposit);
        Assert.assertEquals(client.getDeposits()[1], baseDeposit);
    }

    @Test
    public void testAddDepositFalse() {
        Client client = new Client();
        for (int i = 0; i < 10; i++) {
            client.addDeposit(new BaseDeposit(new BigDecimal(4000.00), 2));
        }
        Assert.assertFalse(client.addDeposit(new BaseDeposit(new BigDecimal(4000.00), 2)));

    }

    @Test
    public void testAddDepositNull() {
        Client client = new Client();
        Assert.assertFalse(client.addDeposit(null));
    }

    @Test
    public void testTotalIncome() {
        Deposit longDeposit = new LongDeposit(new BigDecimal(3200.00), 7);
        Deposit baseDeposit = new BaseDeposit(new BigDecimal(4000.00), 3);
        Deposit specialDeposit = new SpecialDeposit(new BigDecimal(6000.00), 4);
        Client client = new Client();
        client.addDeposit(longDeposit);
        client.addDeposit(baseDeposit);
        client.addDeposit(specialDeposit);
        Assert.assertEquals(client.totalIncome(), new BigDecimal(1731.80).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testMaxIncome() {
        Deposit longDeposit = new LongDeposit(new BigDecimal(3200.00), 7);
        Deposit baseDeposit = new BaseDeposit(new BigDecimal(4000.00), 3);
        Deposit specialDeposit = new SpecialDeposit(new BigDecimal(6000.00), 4);
        Client client = new Client();
        client.addDeposit(longDeposit);
        client.addDeposit(baseDeposit);
        client.addDeposit(specialDeposit);
        Assert.assertEquals(client.maxIncome(), new BigDecimal(630.50).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testGetIncomeByNumber() {
        Deposit longDeposit = new LongDeposit(new BigDecimal(3200.00), 7);
        Deposit baseDeposit = new BaseDeposit(new BigDecimal(4000.00), 3);
        Deposit specialDeposit = new SpecialDeposit(new BigDecimal(6000.00), 4);
        Client client = new Client();
        client.addDeposit(longDeposit);
        client.addDeposit(baseDeposit);
        client.addDeposit(specialDeposit);
        Assert.assertEquals(client.getIncomeByNumber(2), new BigDecimal(621.30).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetIncomeByNumberWhenNumberIsMoreThanDepositLength() {
        Client client = new Client();
        for (int i = 0; i < 10; i++) {
            client.addDeposit(new BaseDeposit(new BigDecimal(4000.00), 2));
        }
        client.getIncomeByNumber(11);
    }

    @Test
    public void testGetIncomeByNumberWhenNumberIsNull() {
        Client client = new Client();
        Assert.assertEquals(client.getIncomeByNumber(1), BigDecimal.ZERO);
    }
}
