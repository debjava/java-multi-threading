package com.ddlab.rnd.completionservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestInOrder {
  public static void main(String[] args) throws Exception {

    Callable a1 = new CallableTask("A1", 9);
    Callable b1 = new CallableTask("B1", 7);
    Callable c1 = new CallableTask("C1", 5);
    Callable d1 = new CallableTask("D1", 3);
    Callable e1 = new CallableTask("E1", 1);

    List<Future<String>> futureList = new ArrayList<>();

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    futureList.add(executorService.submit(a1));
    futureList.add(executorService.submit(b1));
    futureList.add(executorService.submit(c1));
    futureList.add(executorService.submit(d1));
    futureList.add(executorService.submit(e1));

    // Display the data in the order of submission
    // Interview Question : I want to run all threads in Parallel but I want response
    // in the order of submission

    futureList.forEach(
        future -> {
          try {
            System.out.println("Result : " + future.get());
          } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
          }
        });

    executorService.shutdown();
  }
}
