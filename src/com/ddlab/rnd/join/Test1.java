package com.ddlab.rnd.join;

public class Test1 {
  public static void main(String[] args) {
    Common cmn = new Common();
    Thread t1 = new Thread(new TaskThread1(cmn, "Alice"));
    Thread t2 = new Thread(new TaskThread2(cmn, "Bob"));
    t1.start();
    t2.start();
  }
}
