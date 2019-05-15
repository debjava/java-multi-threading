package com.ddlab.rnd.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class BankATM {
  private Semaphore semaphore = new Semaphore(3);
  private CashDispenser cashDispenser = new CashDispenser();

  public int withdrawAmount(int amount) {
    int withdrawalAmt = 0;
    try {
      semaphore.acquire();
      System.out.println(Thread.currentThread().getName() + " trying to withdraw " + amount);
      TimeUnit.SECONDS.sleep(5);
      System.out.println(Thread.currentThread().getName() + " entering ATM PIN");
      withdrawalAmt = cashDispenser.getDispensedCash(amount);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
    return withdrawalAmt;
  }
}
