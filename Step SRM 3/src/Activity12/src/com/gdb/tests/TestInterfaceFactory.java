package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestInterfaceFactory {
    public static void main(String[] args) {
        System.out.println("=== Activity 12: Factory-Driven System Suite ===");

        boolean test1Pass = false;
        boolean test2Pass = false;
        boolean test3Pass = false;
        boolean test4Pass = false;

        IAccount savings = AccountFactory.createAccount("SAVINGS", "SA1001", "Aarav", 25, 5000.0, "ACTIVE", "1111");
        IAccount current = AccountFactory.createAccount("CURRENT", "CA1001", "Ishita", 30, 2000.0, "ACTIVE", "2222");
        IAccount fd = AccountFactory.createAccount("FD", "FD1001", "Rohan", 40, 100000.0, "ACTIVE", "3333");

        try {
            savings.deposit(1000.0);
            test1Pass = Math.abs(savings.getBalance() - 6000.0) < 0.0001;
        } catch (AccountException e) {
            test1Pass = false;
        }
        System.out.println("[Test 1] Savings Account Creation & Deposit: " + (test1Pass ? "[PASS]" : "[FAIL]"));

        try {
            current.withdraw(20000.0, "2222");
            test2Pass = Math.abs(current.getBalance() - (-18000.0)) < 0.0001;
        } catch (AccountException e) {
            test2Pass = false;
        }
        System.out.println("[Test 2] Current Account Overdraft Withdrawal: " + (test2Pass ? "[PASS]" : "[FAIL]"));

        try {
            fd.withdraw(1000.0, "3333");
            test3Pass = false;
        } catch (AccountException e) {
            test3Pass = true;
        }
        System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: " + (test3Pass ? "[PASS]" : "[FAIL]"));

        try {
            AccountFactory.createAccount("CRYPTO", "XX1001", "User", 20, 1000.0, "ACTIVE", "4444");
            test4Pass = false;
        } catch (IllegalArgumentException e) {
            test4Pass = true;
        }
        System.out.println("[Test 4] Invalid Type Rejection: " + (test4Pass ? "[PASS]" : "[FAIL]"));

        if (test1Pass && test2Pass && test3Pass && test4Pass) {
            System.out.println("Factory-driven architecture successfully verified!");
        } else {
            System.out.println("Factory-driven architecture verification failed.");
        }
    }
}
