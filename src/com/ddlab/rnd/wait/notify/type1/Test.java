package com.ddlab.rnd.wait.notify.type1;

public class Test {
  public static void main(String[] args) {
    Common common = new Common();
    Thread producer = new Producer(common);
    Thread consumer = new Consumer(common);

    producer.start();
    consumer.start();
  }
}
