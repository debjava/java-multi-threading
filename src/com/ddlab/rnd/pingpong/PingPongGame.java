package com.ddlab.rnd.pingpong;

public class PingPongGame {
  private boolean hasPlayed = false;

  public synchronized void playPing() {
    while (!hasPlayed) {
      try {
        wait();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName()+" Played : Ping");
    hasPlayed = false;
    notify();
  }

  public synchronized void playPong() {
    while (hasPlayed) {
      try {
        wait();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName()+" Played : Pong");
    hasPlayed = true;
    notify();
  }
}
