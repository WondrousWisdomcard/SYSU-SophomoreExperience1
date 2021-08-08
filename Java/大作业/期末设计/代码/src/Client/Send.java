package Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import Database.PurchaseCuisines;

public class Send implements Runnable {
    // 管道输出流
    private ObjectOutputStream oos;
    private String name;

    private PurchaseCuisines pcc;

    public Send(Socket client, PurchaseCuisines pcc) {
        this.pcc = pcc;
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 发送数据
    public void send(PurchaseCuisines pcc) {
        try {
            oos.writeObject(pcc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        send(pcc);
        pcc = new PurchaseCuisines();
    }
}
