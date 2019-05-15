package com.ddlab.rnd.semaphore;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CashDispenser {
  private Lock lock = new ReentrantLock();

  public int getDispensedCash(int amount) throws InterruptedException {
    lock.lock();
    System.out.println("-------- Cash Dispenser --------");
    System.out.println("Cash is getting dispensed for " + Thread.currentThread().getName());
    TimeUnit.SECONDS.sleep(3);
    lock.unlock();
    System.out.println("-------- Cash Dispenser --------");
    return amount;
  }
}
