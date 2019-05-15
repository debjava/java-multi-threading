package com.ddlab.rnd.type2;

public class Data {
  private String packet;

  // True if receiver should wait
  // False if sender should wait
  private boolean transfer = true;

  public synchronized void send(String packet) {
    while (!transfer) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    transfer = false;
    this.packet = packet;
    System.out.println("Packet : " + packet + " sent...");
    notifyAll();
  }

  public synchronized String receive() {
    while (transfer) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    transfer = true;
    System.out.println("Packet : " + packet + " received...");
    notifyAll();
    return packet;
  }
}
