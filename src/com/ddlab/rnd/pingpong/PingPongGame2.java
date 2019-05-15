package com.ddlab.rnd.pingpong;

import java.util.concurrent.Semaphore;

public class PingPongGame2 {
  private Semaphore pingSema = new Semaphore(0);
  private Semaphore pongSema = new Semaphore(1);

  public void playPing() {
    try {
      System.out.println(Thread.currentThread().getName() + " Played : Ping");
      pingSema.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      pongSema.release();
    }
  }

  public void playPong() {
    try {
      pongSema.acquire();
      System.out.println(Thread.currentThread().getName() + " Played : Pong");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      pingSema.release();
    }
  }
}
