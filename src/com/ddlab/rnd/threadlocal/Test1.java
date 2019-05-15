package com.ddlab.rnd.threadlocal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
  public static void main(String[] args) throws Exception {
    List<String> list =
        new ArrayList<>(Arrays.asList("Elephant", "Tiger", "Lion", "Rat", "Deer", "Zebra"));
    Thread t1 = new Thread1(new ArrayList(list));
    Thread t2 = new Thread2(new ArrayList(list));
    Thread t3 = new Thread3(new ArrayList(list));

    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();
    System.out.println("All threads completed operations ...");
  }
}
