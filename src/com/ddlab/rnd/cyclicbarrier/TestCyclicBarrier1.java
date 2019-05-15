package com.ddlab.rnd.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class TestCyclicBarrier1 {
  public static void main(String[] args) throws Exception {
    // Thread name has no impact in case of CyclicBarrier Runnable task.
    String aadharResult = null;
    String passportResult = null;
    String panNoResult = null;
    Thread endTask = new Thread(new EndTask(3, aadharResult, passportResult, panNoResult));
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3, endTask);
    // You can also write like this
    //    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    Thread aadharThread =
        new Thread(new AadharValidation(cyclicBarrier, 7, aadharResult), "Aadhar");
    Thread passportThread =
        new Thread(new PassportValidation(cyclicBarrier, 5, passportResult), "Passport");
    Thread panNoThread = new Thread(new PanNoValidation(cyclicBarrier, 3, panNoResult), "PanNo");

    aadharThread.start();
    passportThread.start();
    panNoThread.start();

    aadharThread.join();
    passportThread.join();
    panNoThread.join();

    System.out.println("All threads completed the tasks");
  }
}
