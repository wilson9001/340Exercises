package AIPlayer;

import java.util.List;

public class AIPlayer
{
    private List<MoveMaker> strategies;

    public AIPlayer(List<MoveMaker> strategies)
    {
        this.strategies = strategies;
    }

    public void makeMove()
    {
        //traverse list of strategies and select which move or moves to make from list
    }
}
