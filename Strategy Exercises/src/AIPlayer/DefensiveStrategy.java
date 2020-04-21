package AIPlayer;

public class DefensiveStrategy implements MoveMaker
{
    private int difficulty;

    public DefensiveStrategy(int difficulty)
    {
        this.difficulty = difficulty;
    }

    @Override
    public void makeMove()
    {
        //make move based on strategy and board context here
    }

    @Override
    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }
}
