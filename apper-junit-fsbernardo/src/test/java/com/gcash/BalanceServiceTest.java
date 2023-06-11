package com.gcash;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BalanceServiceTest {

    @Test
    void successfulGetBalance() {
        BalanceService balanceService = new BalanceService();
        String accountId = balanceService.repository.createAccount("serafin", 90.0);

        Assertions.assertEquals(90.0, balanceService.getBalance(accountId));
    }

    @Test
    void successfulDebit() {
        BalanceService balanceService = new BalanceService();
        String accountId = balanceService.repository.createAccount("serafin", 90.0);
        // run a debit
        balanceService.debit(accountId,10.0);

        Assertions.assertEquals(80.0, balanceService.getBalance(accountId));
    }

    @Test
    void successfulCredit() {
        BalanceService balanceService = new BalanceService();
        String accountId = balanceService.repository.createAccount("serafin", 90.0);
        // run a credit
        balanceService.credit(accountId,10.0);

        Assertions.assertEquals(100.0, balanceService.getBalance(accountId));
    }

    @Test
    void successfulTransfer() {
        BalanceService balanceService = new BalanceService();
        String accountIdFrom = balanceService.repository.createAccount("serafin1", 100.0);
        String accountIdTo = balanceService.repository.createAccount("serafin2", 0.0);
        // run a transfer
        balanceService.transfer(accountIdFrom,accountIdTo,100.0);

        Assertions.assertEquals(0.0, balanceService.getBalance(accountIdFrom));
        Assertions.assertEquals(100.0, balanceService.getBalance(accountIdTo));
    }

}
