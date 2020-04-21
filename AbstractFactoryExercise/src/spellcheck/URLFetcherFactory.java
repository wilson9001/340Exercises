package spellcheck;

public class URLFetcherFactory implements IContentRetrieverFactory
{
    @Override
    public IContentRetriever createRetriever()
    {
        return new URLFetcher();
    }
}
