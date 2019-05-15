package com.ddlab.rnd.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
  private BlockingQueue<Runnable> blockingQueue;
  private boolean shutdown = false;

  public CustomThreadPool(int nThreads) {
    blockingQueue = new LinkedBlockingQueue<>(nThreads);
    for (int i = 0; i < nThreads; i++) {
      TaskExecutor executor = new TaskExecutor(this, blockingQueue);
      executor.setName("Thread-Pool-" + i);
      executor.start();
    }
  }

  public synchronized void execute(Runnable runnable) throws Exception {
    blockingQueue.put(runnable);
  }

  public void shutdown() {
    this.shutdown = true;
  }

  public boolean isShutdown() {
    return shutdown;
  }
}
