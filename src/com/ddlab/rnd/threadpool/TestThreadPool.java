package com.ddlab.rnd.threadpool;

public class TestThreadPool {
  public static void main(String[] args) {
    CustomThreadPool threadPool = new CustomThreadPool(3);
    for (int i = 0; i < 3; i++) {
      Thread thread = new TestThread();
      try {
        threadPool.execute(thread);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    threadPool.shutdown();
  }
}
