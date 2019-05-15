package com.ddlab.rnd.threadpool;

import java.util.concurrent.BlockingQueue;

public class TaskExecutor extends Thread {
  private BlockingQueue<Runnable> blockingQueue;
  private CustomThreadPool threadPool;

  public TaskExecutor(CustomThreadPool threadPool, BlockingQueue<Runnable> blockingQueue) {
    this.blockingQueue = blockingQueue;
    this.threadPool = threadPool;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Runnable runnable = blockingQueue.take();
        runnable.run();
        System.out.println(Thread.currentThread().getName() + " executed ...");

        if (blockingQueue.size() == 0 && threadPool.isShutdown()) {
          this.interrupt();
        }
      }
    } catch (InterruptedException ie) {
      System.out.println(Thread.currentThread().getName() + " has been stopped ...");
    }
  }
}
