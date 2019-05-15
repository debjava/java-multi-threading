package com.ddlab.rnd.completionservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InidanMissileTest {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

    List<Future> futureList = new ArrayList<>();

    Callable<String> brahmos = new Missile("Brahmos", "Karachi (Pakistan)", 11);
    Callable<String> agnee = new Missile("Agnee", "Lahore (Pakistan)", 13);
    Callable<String> nag = new Missile("Nag", "Islamabad (Pakistan)", 5);
    Callable<String> prithvi = new Missile("prithvi", "Rawalpindi (Pakistan)", 7);
    Callable<String> trishul = new Missile("Trishul", "Peshawar (Pakistan)", 9);

    futureList.add(completionService.submit(brahmos));
    futureList.add(completionService.submit(agnee));
    futureList.add(completionService.submit(nag));
    futureList.add(completionService.submit(prithvi));
    futureList.add(completionService.submit(trishul));

    executorService.shutdown();

    for (int i = 0; i < futureList.size(); i++) {
      try {
        Future<String> future = completionService.take();
        System.out.println("Missile attack result : " + future.get());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
  }
}
