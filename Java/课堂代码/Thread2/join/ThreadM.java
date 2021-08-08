package test2;

class ThreadM extends Thread {
    public void run() {
    try {
      for (int i = 0; i < 10; i++) {
        Thread.sleep(1000);
        System.out.println("ThreadM");       }
    }
    catch (InterruptedException ex) {
      ex.printStackTrace();     }
  }    }

