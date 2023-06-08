package com.gcash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountRepositoryTest {

    @Test
    void successfulAccountCreation() {
        AccountRepository repository = new AccountRepository();

        String accountId = repository.createAccount("serafin", 90.0);
        Assertions.assertEquals(1, repository.getNumberOfAccounts());
        Assertions.assertEquals("serafin", repository.getAccount(accountId).name());
    }

    @Test
    void successfulGetAccount() {
        AccountRepository repository = new AccountRepository();
        String accountId = repository.createAccount("serafin", 90.0);

        Assertions.assertEquals("serafin", repository.getAccount(accountId).name());
        Assertions.assertEquals(90.0, repository.getAccount(accountId).balance());
        Assertions.assertNull(repository.getAccount("randomid"));
    }

    @Test
    void successfulDelete() {
        AccountRepository repository = new AccountRepository();
        String accountId = repository.createAccount("serafin", 90.0);

        repository.deleteAccount(accountId);
        Assertions.assertEquals(0, repository.getNumberOfAccounts());
    }

}