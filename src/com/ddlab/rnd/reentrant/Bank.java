package com.ddlab.rnd.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bank {
  private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private Lock depositLock = readWriteLock.writeLock();
  private Lock withdrawLock = readWriteLock.readLock();

  public void depositMoney(int amount) {
    try {
      depositLock.lock();
      System.out.println(Thread.currentThread().getName() + " depositing money of Rs " + amount);
      TimeUnit.SECONDS.sleep(10);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      depositLock.unlock();
    }
    System.out.println(Thread.currentThread().getName() + " deposited money ...");
  }

  public void withdrawCash(int amount) {
    try {
      withdrawLock.lock();
      System.out.println(Thread.currentThread().getName() + " withdrawing money of Rs " + amount);
      TimeUnit.SECONDS.sleep(5);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      withdrawLock.unlock();
    }
    System.out.println(Thread.currentThread().getName() + " withdrew money ...");
  }
}
