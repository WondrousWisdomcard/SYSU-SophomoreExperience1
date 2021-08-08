package Database;

import java.io.*;

import java.text.*;
import java.util.*;

public class PurchaseCuisines extends ArrayList<HasCuisine> implements Serializable {// �˿��ѹ����Ʒ

	private static final long serialVersionUID = 1L;
	
	public String context = new String();

	public boolean addCuisine(HasCuisine hasc) {
		return add(hasc);
	}

	public void setString(){
		String s = new String();
        for (int i = 0; i < size(); i++) {
            s += (get(i).getname() + " " + get(i).getprice() + "x" + get(i).getnum() + " "
                    + get(i).getAmountPrice()) + "\n";
        }
		context = s;
		System.out.println(context);
	}

	public void printFile(int people, double amount) {
		Date date = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyMMddHHmmss");
		SimpleDateFormat time1 = new SimpleDateFormat("yy��MM��dd��HH��mm��ss");
		try {
			FileWriter out = new FileWriter("src/bill/" + time.format(date) + ".txt");// ���µ�ʱ��Ϊ�ļ���
			BufferedWriter buf = new BufferedWriter(out);
			buf.write("��λ��" + " " + "6.0" + "x" + people + " " + people * 6.0);
			buf.newLine();
			for (int i = 0; i < size(); i++) {
				if (get(i).getname() != "") {
					buf.write(get(i).getname() + " " + get(i).getprice() + "x" + get(i).getnum() + " "
							+ get(i).getAmountPrice());
					buf.newLine();
				}
			}
			double finAmount = amount + people * 6.0;
			buf.write("�ܼƣ�" + finAmount);
			buf.newLine();
			buf.write(time1.format(date));
			buf.close();
			out.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
