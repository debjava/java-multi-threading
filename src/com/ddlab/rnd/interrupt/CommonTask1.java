package com.ddlab.rnd.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CommonTask1 {
  private ReentrantLock lock = new ReentrantLock();

  public void perform() {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println(currentThreadName + " started ...");
    try {
      lock.lockInterruptibly();
      System.out.println(currentThreadName + " holds lock " + lock.isHeldByCurrentThread());
      System.out.println(
          "Is " + currentThreadName + " interrupted ? " + Thread.currentThread().isInterrupted());
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (lock.isHeldByCurrentThread()) {
        lock.unlock();
      }
    }
    System.out.println(Thread.currentThread().getName() + " completed ...");
  }
}
