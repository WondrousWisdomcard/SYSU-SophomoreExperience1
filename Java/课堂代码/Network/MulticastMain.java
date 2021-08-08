public class MulticastMain {
    public static void main(String[] args){
        MulticastThread t1 = new MulticastThread(1);
        MulticastThread t2 = new MulticastThread(2);
        MulticastThread t3 = new MulticastThread(3);

        t1.start();
        t2.start();
        t3.start();
    }
}
