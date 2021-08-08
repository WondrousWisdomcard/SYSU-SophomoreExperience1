public class RockPaperScissors {     
    public static void main(String[] args) {         
        Player youwei = new Player("youwei");         
        Player Chenninghao = new Player("Chenninghao");         
        Player Zhengyouwei = new Player("Zhengyouwei");         
        Game game = new Game(); 
 
        System.out.println("Game.run Test");         
        game.setFirstPlayer(Zhengyouwei);         
        game.setSecondPlayer(Chenninghao);         
        game.run(1000); 
 
        System.out.println("\nPlayer.reset test");         
        System.out.println("before reset:");         
        System.out.printf("victoryTimes : %d\n", Chenninghao.getVictoryTimes());         
        System.out.printf("gameTimes : %d\n", Chenninghao.getGameTimes());         
        Chenninghao.reset();         System.out.println("after reset:");         
        System.out.printf("victoryTimes : %d\n", Chenninghao.getVictoryTimes());         
        System.out.printf("gameTimes : %d\n", Chenninghao.getGameTimes()); 
 
        System.out.println("\nGame.setFirstPlayer test");         
        game.setFirstPlayer(Zhengyouwei); 
        game.run(5);     
    }
}