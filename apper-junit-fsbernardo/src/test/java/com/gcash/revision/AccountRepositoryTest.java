package com.gcash.revision;

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
    void successfulUpdateAccount() {
        AccountRepository repository = new AccountRepository();
        String accountId = repository.createAccount("serafin", 90.0);

        repository.updateAccount(accountId,100.0);

        Assertions.assertEquals(100.0, repository.getAccount(accountId).balance());
        Assertions.assertEquals(1, repository.getNumberOfAccounts());
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

        repository.deleteAccount("randomId");

        repository.deleteAccount(accountId);
        Assertions.assertEquals(0, repository.getNumberOfAccounts());

    }

    @Test
    void successfulGetNumberOfAccounts(){
        AccountRepository repository = new AccountRepository();

        String accountId1 = repository.createAccount("serafin", 90.0);
        Assertions.assertEquals(1, repository.getNumberOfAccounts());

        String accountId2 = repository.createAccount("serafin2", 90.0);
        Assertions.assertEquals(2, repository.getNumberOfAccounts());

    }

    @Test
    void successfulNoRegisteredAccount() {
        AccountRepository repository = new AccountRepository();
        Assertions.assertTrue(repository.noRegisteredAccount());

        String accountId1 = repository.createAccount("serafin", 90.0);
        Assertions.assertFalse(repository.noRegisteredAccount());
    }

}