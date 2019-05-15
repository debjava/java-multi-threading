package com.ddlab.rnd.executorservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyTest1 {
  public static void main(String[] args) {
    //    ExecutorService executorService = Executors.newCachedThreadPool();
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    List<Callable<String>> callableList = new ArrayList<>();
    CallableTask task1 = new CallableTask("Task-1", 5);
    CallableTask task2 = new CallableTask("Task-2", 3);
    CallableTask task3 = new CallableTask("Task-3", 7);

    callableList.add(task1);
    callableList.add(task2);
    callableList.add(task3);

    try {
      String result = executorService.invokeAny(callableList);
      System.out.println("Result : " + result);
      executorService.shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("All completed ...");
  }
}
