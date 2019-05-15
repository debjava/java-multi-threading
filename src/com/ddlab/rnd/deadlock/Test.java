package com.ddlab.rnd.deadlock;

public class Test {
  public static void main(String[] args) {
    Thread t1 = new ThreadTask();
    t1.setName("Thread-1");
//    Thread t2 = new ThreadTask();
//    t2.setName("Thread-2");
    t1.start();
//    t2.start();
  }
}
