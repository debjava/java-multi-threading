package com.ddlab.rnd.pingpong;

import java.util.concurrent.SynchronousQueue;

public class PingPongGame1 {
  private SynchronousQueue<String> synQ = new SynchronousQueue<>();

  public void playPing() {
    try {
      synQ.put("Ping");
      System.out.println(Thread.currentThread().getName() + " Played : Ping");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void playPong() {
    try {
      System.out.println(Thread.currentThread().getName() + " Played : Pong");
      synQ.take();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
