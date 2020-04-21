package spellcheck;

public class MockContentRetriever implements IContentRetriever
{
    @Override
    public String getContent(String reference)
    {
        return "Mocked content";
    }
}
