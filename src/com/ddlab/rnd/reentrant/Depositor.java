package com.ddlab.rnd.reentrant;

public class Depositor implements Runnable {
  private Bank bank;
  private int amount;

  public Depositor(Bank bank, int amount) {
    this.bank = bank;
    this.amount = amount;
  }

  @Override
  public void run() {
    bank.depositMoney(amount);
  }
}
