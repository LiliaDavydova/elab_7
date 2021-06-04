package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;

public class Client {
    private Deposit[] deposits;


    public Client() {
        this.deposits = new Deposit[10];
    }

    public Deposit[] getDeposits() {
        return deposits;
    }

    public boolean addDeposit(Deposit deposit) {
        boolean isAdded = false;
        if (deposit != null) {
            for (int i = 0; i < this.deposits.length; i++) {
                if (this.deposits[i] == null) {
                    this.deposits[i] = deposit;
                    isAdded = true;
                    break;
                }
            }
        }
        return isAdded;
    }

    public BigDecimal totalIncome() {
        BigDecimal totalIncome = BigDecimal.ZERO;
        for (int i = 0; i < deposits.length; i++) {
            if (this.deposits[i] != null) {
                totalIncome = deposits[i].income().add(totalIncome);
            }
        }
        return totalIncome;
    }

    public BigDecimal maxIncome() {
        BigDecimal max = BigDecimal.ZERO;
        for (int i = 0; i < deposits.length; i++) {
            if (this.deposits[i] != null) {
                BigDecimal currentIncome = this.deposits[i].income();
                if (currentIncome.compareTo(max) > 0) {
                    max = currentIncome;
                }
            }
        }
        return max;
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (number >= deposits.length) {
            throw new IllegalArgumentException("No such element in array");
        }
        Deposit deposit = this.deposits[number];
        if (deposit == null) {
            return BigDecimal.ZERO;
        }
        return deposit.income();
    }
}

