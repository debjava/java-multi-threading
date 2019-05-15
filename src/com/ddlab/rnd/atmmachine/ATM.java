package com.ddlab.rnd.atmmachine;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {
  private Lock lock = new ReentrantLock();

  @Deprecated
  public int withdrawAmount(int amount) {
    int withdrawnAmt = 0;
    lock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + " trying to withdraw amount " + amount);
      TimeUnit.SECONDS.sleep(5);
      withdrawnAmt = amount;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return withdrawnAmt;
  }

  @Deprecated
  public int withdrawCash(int amount) {
    int withdrawnAmt = 0;
    boolean tryLockFlag = lock.tryLock();
    if (tryLockFlag) {
      try {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw cash " + amount);
        TimeUnit.SECONDS.sleep(5);
        withdrawnAmt = amount;
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
    return withdrawnAmt;
  }

  public int withdrawMoney(int amount) {
    int withdrawnAmt = 0;
    try {
      boolean flag =
          lock.tryLock(
              2, TimeUnit.SECONDS); // If you increase time to 5, probably 2 persons may get money
      System.out.println("What is the value of flag ? " + flag);
      if (flag) {
        try {
          System.out.println(Thread.currentThread().getName() + " trying to withdraw " + amount);
          TimeUnit.SECONDS.sleep(5);
          withdrawnAmt = amount;
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return withdrawnAmt;
  }
}
