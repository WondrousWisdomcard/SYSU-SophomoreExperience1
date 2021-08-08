import java.lang.Math;
public class Player {
    private String name;
    private int victoryTimes;
    private int gameTimes;

    public Player(String name)
    {
        this.name = name;
        victoryTimes = 0;
        gameTimes = 0;
    }
    public String getName()
    {
        return name;
    }
    public int getVictoryTimes()
    {
        return victoryTimes;
    }
    public int getGameTimes()
    {
        return gameTimes;
    }
    public void reset()
    {
        victoryTimes = 0;
        gameTimes = 0;
    }
    public void recordGame(boolean isVictory)
    {
        gameTimes++;
        if(isVictory)
        {
            victoryTimes++;
        }
    }
    public int chooseShape()
    {
        final double l = Math.random();
        final int i = (int)(l*3);
        // 0 means ROCK, 1 means PAPER, 2 means SCISSORS
        return i;
    }
    public void showMetrics() 
    {
        if(gameTimes > 0)
        System.out.println(name + " : " + (double)victoryTimes/gameTimes);
        else
        System.out.println(name + " Haven't Take Part In A Game!");
    }
}
