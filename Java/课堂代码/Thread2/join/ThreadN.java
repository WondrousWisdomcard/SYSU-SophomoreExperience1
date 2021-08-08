package test2;

class ThreadN extends Thread {
    public void run() {
    try {
      for (int i = 0; i < 20; i++) {
        Thread.sleep(2000);
        System.out.println("ThreadN");
      }
    }
    catch(InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}


