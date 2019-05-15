package com.ddlab.rnd.pingpong;

public class PlayerThread1 implements Runnable {
  private PingPongGame2 game1;
  private String name;

  public PlayerThread1(PingPongGame2 game1, String name) {
    this.game1 = game1;
    this.name = name;
  }

  @Override
  public void run() {
    Thread.currentThread().setName(name);
    for (int i = 0; i < 5; i++) {
      game1.playPing();
    }
  }
}
