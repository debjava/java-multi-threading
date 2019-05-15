package com.ddlab.rnd.executorservice;

import java.util.concurrent.*;

public class SubmitCallable1 {
  public static void main(String[] args) {
    Callable<String> callableTask = new CallableTask("Task-1", 3);
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> future = executorService.submit(callableTask);
    try {
      System.out.println("Final Result : " + future.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    executorService.shutdown();
  }
}
