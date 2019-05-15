package com.ddlab.rnd.threadlocal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
  public static void main(String[] args) throws Exception {
    List<String> list =
        new ArrayList<>(Arrays.asList("Elephant", "Tiger", "Lion", "Rat", "Deer", "Zebra"));
    ThreadLocaList thList = new ThreadLocaList(list);
//    Thread t1 = new Thread1(thList);
//    Thread t2 = new Thread2(thList);
//    Thread t3 = new Thread3(thList);
//
//    t1.start();
//    t2.start();
//    t3.start();
//
//    t1.join();
//    t2.join();
//    t3.join();
    System.out.println("All threads completed operations ...");
  }
}
