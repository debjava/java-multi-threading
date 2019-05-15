package com.ddlab.rnd.join;

public class TaskThread1 implements Runnable {
  private Common cmn;
  private String name;

  public TaskThread1(Common cmn, String name) {
    this.cmn = cmn;
    this.name = name;
    Thread.currentThread().setName(name);
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " executing synchronized method ...");
    cmn.performSync();
  }
}
