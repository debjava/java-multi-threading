package com.ddlab.rnd.completionservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestCompletionService {
  public static void main(String[] args) {
    Callable a1 = new CallableTask("A1", 9);
    Callable b1 = new CallableTask("B1", 7);
    Callable c1 = new CallableTask("C1", 5);
    Callable d1 = new CallableTask("D1", 3);
    Callable e1 = new CallableTask("E1", 1);

    List<Future<String>> futureList = new ArrayList<>();

    ExecutorService executorService = Executors.newFixedThreadPool(5);
    CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

    futureList.add(completionService.submit(a1));
    futureList.add(completionService.submit(b1));
    futureList.add(completionService.submit(c1));
    futureList.add(completionService.submit(d1));
    futureList.add(completionService.submit(e1));

    //    for (int i = 0; i < futureList.size(); i++) {
    //      try {
    //        Future<String> future = completionService.take();
    //        System.out.println("Result : " + future.get());
    //      } catch (InterruptedException | ExecutionException e) {
    //        e.printStackTrace();
    //      }
    //    }

    futureList.forEach(
        a -> {

          try {
            Future<String> future = completionService.take();
            System.out.println("Result : " + future.get());
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (ExecutionException e) {
            e.printStackTrace();
          }
        });

    executorService.shutdown();
  }
}
