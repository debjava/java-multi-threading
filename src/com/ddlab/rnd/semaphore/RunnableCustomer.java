package com.ddlab.rnd.semaphore;

public class RunnableCustomer implements Runnable {
  private BankATM bankATM;
  private int amount;

  public RunnableCustomer(BankATM bankATM, int amount) {
    this.bankATM = bankATM;
    this.amount = amount;
  }

  @Override
  public void run() {
    int value = bankATM.withdrawAmount(amount);
    System.out.println(Thread.currentThread().getName() + " got cash of Rs " + amount);
  }
}
