package com.ddlab.rnd.wait.notify.type1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBQ {
  public static void main(String[] args) {
    BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(1);
      Thread producer = new BQProducer(bq);
      Thread consumer = new BQConsumer(bq);

      producer.start();
      consumer.start();
  }
}
