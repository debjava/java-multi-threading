package com.ddlab.rnd.executorservice;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyTest {
  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Set<Callable<String>> callables = new HashSet<Callable<String>>();

    callables.add(
        new Callable<String>() {
          public String call() throws Exception {
            return "Task 1";
          }
        });
    callables.add(
        new Callable<String>() {
          public String call() throws Exception {
            return "Task 2";
          }
        });
    callables.add(
        new Callable<String>() {
          public String call() throws Exception {
            return "Task 3";
          }
        });

    String result = executorService.invokeAny(callables);
    System.out.println("result = " + result);
    executorService.shutdown();
  }
}
