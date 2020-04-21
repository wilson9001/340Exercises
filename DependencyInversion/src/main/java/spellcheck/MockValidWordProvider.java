package spellcheck;

public class MockValidWordProvider implements IValidWordProvider
{
    @Override
    public boolean isValidWord(String word)
    {
        return true;
    }
}
