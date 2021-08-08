public class Game {
    private Player firstPlayer;
    private Player secondPlayer;

    public void setFirstPlayer(Player player)
    {
        firstPlayer = player;
    }
    public void setSecondPlayer(Player player)
    {
        secondPlayer = player;
    }
    public void run(int n)
    {
        firstPlayer.reset();
        secondPlayer.reset();

        for(int i = 0; i < n; i++)
        {
            boolean fIsVictory;
            boolean sIsVictory;

            int f = firstPlayer.chooseShape();
            int s = secondPlayer.chooseShape();

            if(f == 0)
            {
                System.out.print(firstPlayer.getName() + ":" + "rock");
            }
            else if(f == 1)
            {
                System.out.print(firstPlayer.getName() + ":" + "paper");
            }
            else if(f == 2)
            {
                System.out.print(firstPlayer.getName() + ":" + "scissors");
            }

            System.out.print("   ");

            if(s == 0)
            {
                System.out.print(secondPlayer.getName() + ":" + "rock");
            }
            else if(s == 1)
            {
                System.out.print(secondPlayer.getName() + ":" + "paper");
            }
            else if(s == 2)
            {
                System.out.print(secondPlayer.getName() + ":" + "scissors");
            }
            
            if(f == 2 && s == 1 || f == 0 && s == 2 || f == 1 && s == 0)
            {
                fIsVictory = true;
                sIsVictory = false;
                System.out.println("   result:" + firstPlayer.getName() + " wins");
            }
            else if(f == 1 && s == 2 || f == 2 && s == 0 || f == 0 && s == 1)
            {
                fIsVictory = false;
                sIsVictory = true;
                System.out.println("   result:" + secondPlayer.getName() + " wins");
            }
            else 
            {
                fIsVictory = false;
                sIsVictory = false;
                System.out.println("   result: Draw");
            }

            firstPlayer.recordGame(fIsVictory);
            secondPlayer.recordGame(sIsVictory);
        }
    
        firstPlayer.showMetrics();
        secondPlayer.showMetrics();
    }
}
