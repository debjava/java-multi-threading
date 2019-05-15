package com.ddlab.rnd.pingpong;

public class Test {
  public static void main(String[] args) {
    PingPongGame2 game1 = new PingPongGame2();
    Thread t1 = new Thread(new PlayerThread1(game1, "Alice"));
    Thread t2 = new Thread(new PlayerThread2(game1, "Bob"));
    t1.start();
    t2.start();
  }
}
