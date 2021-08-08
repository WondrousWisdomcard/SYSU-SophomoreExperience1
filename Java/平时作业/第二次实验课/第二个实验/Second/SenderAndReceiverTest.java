package Second;

public class SenderAndReceiverTest {
 public static void main(String[] args) {
 User zhangSan = new User("ZhangSan");
 User wangWu = new User("WangWu");
 User liSi = new User("LiSi");
 User zhaoLiu = new User("zhaoLiu");
 Channel douBiFanZhiJiDi = new Channel("douBiFanZhiJiDi");
 douBiFanZhiJiDi.add(zhangSan);
 douBiFanZhiJiDi.add(wangWu);
 douBiFanZhiJiDi.add(liSi);
 
 Channel yongYuanDe308 = new Channel("yongYuanDe308");
 yongYuanDe308.add(zhaoLiu);
 yongYuanDe308.add(wangWu);
 yongYuanDe308.add(liSi);
 zhaoLiu.send(yongYuanDe308, "What did you guys do during the holidays");
 wangWu.send(yongYuanDe308, "I went to eat barbecue, haha");
 zhaoLiu.send(yongYuanDe308, "It sounds interesting, we can barbecue together next time!");
 yongYuanDe308.remove(zhaoLiu);
 zhangSan.send(douBiFanZhiJiDi, "Please help me ask what Zhao Liu likes");
 wangWu.send(douBiFanZhiJiDi, "Zhang, I was Wang. Can't help you, bro. sorry");
 zhangSan.send(douBiFanZhiJiDi, "Lisi, would you mind...");
 liSi.send(douBiFanZhiJiDi, "You know I don't like to be a matchmaker.");
 System.out.println("ZhangSan's messages list:");
 zhangSan.showMessages();
 System.out.println("\nLiSi's messages list:");
 liSi.showMessages();
 System.out.println("\nWangWu's messages list:");
 wangWu.showMessages();
 System.out.println("\nZhaoLiu's messages list:");
 zhaoLiu.showMessages();
 }
}