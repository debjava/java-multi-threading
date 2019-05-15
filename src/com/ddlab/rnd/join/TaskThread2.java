package com.ddlab.rnd.join;

public class TaskThread2 implements Runnable {
  private Common cmn;
  private String name;

  public TaskThread2(Common cmn,String name) {
    this.cmn = cmn;
    this.name = name;
    Thread.currentThread().setName(name);
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " executing unsynchronized method ...");
    cmn.perform();
  }
}
