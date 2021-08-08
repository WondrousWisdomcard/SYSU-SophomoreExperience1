package Database;

import java.util.HashMap;

public class Warehouse extends HashMap<String, HashMap<String, Cuisine>> {// ��Ʒ�ֿ�

	private static final long serialVersionUID = 1L;

	public Warehouse() {
		HashMap<String, Cuisine> pot_bottom = new HashMap<String, Cuisine>();// ����keyΪ��ƷID��valueΪ��Ʒ��map
		pot_bottom.put("022", new HotPotCondiment("������֭", 100, "src/image/022.jpg", 48.0, "022"));
		pot_bottom.put("023", new HotPotCondiment("����", 100, "src/image/023.jpg", 48.0, "023"));
		pot_bottom.put("024", new HotPotCondiment("ԧ��", 100, "src/image/024.jpg", 48.0, "024"));
		pot_bottom.put("025", new HotPotCondiment("����", 100, "src/image/025.jpg", 48.0, "025"));

		HashMap<String, Cuisine> drink = new HashMap<String, Cuisine>();
		drink.put("018", new Drinks("����", 100, "src/image/018.jpg", 4, "018"));
		drink.put("019", new Drinks("���ϼ�", 100, "src/image/019.jpg", 5, "019"));
		drink.put("020", new Drinks("���ʲ�", 100, "src/image/020.jpg", 6, "020"));
		drink.put("021", new Drinks("ѩ��", 100, "src/image/021.jpg", 4, "021"));
		drink.put("034", new Drinks("�����۲�", 100, "src/image/034.jpg", 4, "034"));
		drink.put("035", new Drinks("�Ҵ�", 100, "src/image/035.jpg", 5, "035"));
		drink.put("036", new Drinks("Ҭ��Ҭ֭", 100, "src/image/036.jpg", 5, "036"));
		drink.put("037", new Drinks("�ൺơ��", 100, "src/image/037.jpg", 13, "037"));
 
		HashMap<String, Cuisine> meat = new HashMap<String, Cuisine>();
		meat.put("001", new Meat("��ţ��", 100, "src/image/001.jpg", 32.5, "001"));
		meat.put("002", new Meat("��ţ��", 100, "src/image/002.jpg", 23.0, "002"));
		meat.put("003", new Meat("ѩ��ţ��", 100, "src/image/003.jpg", 25.0, "003"));
		meat.put("004", new Meat("ţ��", 100, "src/image/004.jpg", 55.0, "004"));
		meat.put("005", new Meat("ţ��", 100, "src/image/005.jpg", 32.5, "005"));
		meat.put("006", new Meat("�ױ�", 100, "src/image/006.jpg", 45.5, "006"));
		meat.put("007", new Meat("��ţ����", 100, "src/image/007.jpg", 45.5, "007"));

		HashMap<String, Cuisine> snack = new HashMap<String, Cuisine>();
		snack.put("008", new Snack("����", 100, "src/image/008.jpg", 22.0, "008"));
		snack.put("009", new Snack("���", 100, "src/image/009.jpg", 22.0, "009"));
		snack.put("010", new Snack("���Ƕ�����", 100, "src/image/010.jpg", 5.0, "010"));
		snack.put("011", new Snack("��������", 100, "src/image/011.jpg", 12.0, "011"));
		snack.put("012", new Snack("��������", 100, "src/image/012.jpg", 15.0, "012"));
		snack.put("013", new Snack("������", 100, "src/image/013.jpg", 15.0, "013"));

		HashMap<String, Cuisine> vegetable = new HashMap<String, Cuisine>();
		vegetable.put("014", new Vegetable("��źƬ", 100, "src/image/014.jpg", 12.0, "014"));
		vegetable.put("015", new Vegetable("��Ģ��", 100, "src/image/015.jpg", 12.0, "015"));
		vegetable.put("016", new Vegetable("���ܲ�", 100, "src/image/016.jpg", 8.0, "016"));
		vegetable.put("017", new Vegetable("ľ��Ƭ", 100, "src/image/017.jpg", 12.0, "017"));
		vegetable.put("026", new Vegetable("��ײ�", 100, "src/image/026.jpg", 8.0, "026"));
		vegetable.put("027", new Vegetable("���빽", 100, "src/image/027.jpg", 12.0, "027"));
		vegetable.put("028", new Vegetable("����Ƭ", 100, "src/image/028.jpg", 12.0, "028"));
		vegetable.put("029", new Vegetable("������", 100, "src/image/029.jpg", 18.0, "029"));
		vegetable.put("030", new Vegetable("�Ͳ�", 100, "src/image/030.jpg", 8.0, "030"));
		vegetable.put("031", new Vegetable("С���", 100, "src/image/031.jpg", 8.0, "031"));
		vegetable.put("032", new Vegetable("����", 100, "src/image/032.jpg", 8.0, "032"));
		vegetable.put("033", new Vegetable("������", 100, "src/image/033.jpg", 16.0, "033"));
		
		HashMap<String, Cuisine> staplefood = new HashMap<String, Cuisine>();
		staplefood.put("038", new StapleFood("С����", 100, "src/image/038.jpg", 10, "038"));
		staplefood.put("039", new StapleFood("����", 100, "src/image/039.jpg", 4, "039"));
		staplefood.put("040", new StapleFood("����", 100, "src/image/040.jpg", 4, "040"));
		staplefood.put("041", new StapleFood("���׷�", 100, "src/image/041.jpg", 2, "041"));

		put("pot_bottom", pot_bottom);
		put("meat", meat);
		put("vegetable", vegetable);
		put("snack", snack);
		put("drink", drink);
		put("staplefood",staplefood);
	}
}
