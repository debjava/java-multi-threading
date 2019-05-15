package com.ddlab.rnd.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnableTaskWithT {
  public static void main(String[] args) throws Exception {
    String response1 = "Done";
    String threadResponse = null;
    StringBuilder builder = new StringBuilder();
    ExecutorService executorService = Executors.newCachedThreadPool();
    Runnable runnable = new RunnableTask(3, threadResponse, builder);
    Future<String> future = executorService.submit(runnable, response1);
    System.out.println("Final Result : " + future.get());
    System.out.println("Response from Thread : " + threadResponse);
    System.out.println("Response from Thread using StringBuilder: " + builder.toString());
    executorService.shutdown();
  }
}
