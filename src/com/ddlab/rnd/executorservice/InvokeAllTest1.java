package com.ddlab.rnd.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllTest1 {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    List<Callable<String>> callableList = new ArrayList<>();
    CallableTask task1 = new CallableTask("Task-1", 5);
    CallableTask task2 = new CallableTask("Task-2", 3);
    CallableTask task3 = new CallableTask("Task-3", 7);

    callableList.add(task1);
    callableList.add(task2);
    callableList.add(task3);

    try {
      List<Future<String>> futureList = executorService.invokeAll(callableList);
      futureList.forEach(
          futureObj -> {
            try {
              System.out.println("Actual Result : " + futureObj.get());
            } catch (InterruptedException e) {
              e.printStackTrace();
            } catch (ExecutionException e) {
              e.printStackTrace();
            }
          });
      executorService.shutdown();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("All completed ...");
  }
}
