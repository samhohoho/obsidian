---
id: 13-transactions
aliases: []
tags: []
---
# Transactions
- The set of mutable operations (operations that change data) that can either correctly execute them altogether or not at all, **atomicity**.
- The **commit** opration happens when transactions ends and are executed successfully.
```java
// Controller
@PostMapping
public void transferMoney() {
    service.transferMoney();
}

// Spring transaction aspect
try {
    // start transaction
    // call intercepted method
    // commit transaction
} catch (RuntimeE xception e) {
    // rollback transaction
}

// Service
@Transactional
public void transferMoney() {
    // 1. withdraw money from the source account
    // 2. deposit money in the destination account
}
```
## Throwing a runtime exception
- The transactional method should throw the exception further so that the aspect knows it should rollback the changes.
# Using transactions
- Spring configures an aspect that intercepts the methods you annotated with `@Transactional`.
- This aspect either commits the method's changes or rolls back the changes.
```java
@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender,
                            long idReceiver,
                            BigDecimal amount) {
        Account sender =
            accountRepository.findAccountById(idSender);
        Account receiver =
            accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount =
            sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount =
            receiver.getAmount().add(amount);

        accountRepository
            .changeAmount(idSender, senderNewAmount);

        accountRepository
            .changeAmount(idReceiver, receiverNewAmount);
    }
}
```
- Right after Account Controller calls the service method,
the Spring transaction aspect intercepts the call and starts the transaction.
- The transaction starts just before the service method execution and ends just after the method successfully ended.
## Using `@Transactional` on class.
- The annotation applies to all the class methods.
- When using it on both the class and the method, the method's level configuration overrides.
```java
@Service
@Transactional
public class TransferService {
    // Omitted code
    public void transferMoney(long idSender,
                            long idReceiver,
                            BigDecimal amount) {
        // Omitted code
    }
}
```
