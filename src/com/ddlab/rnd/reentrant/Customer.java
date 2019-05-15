package com.ddlab.rnd.reentrant;

public class Customer implements Runnable {
  private Bank bank;
  private int amount;

  public Customer(Bank bank, int amount) {
    this.bank = bank;
    this.amount = amount;
  }

  @Override
  public void run() {
    bank.withdrawCash(amount);
  }
}
