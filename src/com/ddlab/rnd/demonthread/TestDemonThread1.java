package com.ddlab.rnd.demonthread;

import java.util.concurrent.TimeUnit;

public class TestDemonThread1 {
  public static void main(String[] args) throws Exception {
    Thread t1 = new Thread(new RunnableTask(), "Demon-1");
    t1.setDaemon(true);
    t1.start();

    TimeUnit.SECONDS.sleep(10);
    System.out.println("All tasks done ...");
  }
}
