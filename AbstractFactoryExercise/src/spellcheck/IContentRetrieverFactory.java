package spellcheck;

public interface IContentRetrieverFactory
{
    public enum RetrieverType
    {
        URLFetcher
    }

    public static IContentRetrieverFactory createFactory(RetrieverType type)
    {
        switch(type)
        {
            case URLFetcher:
                return new URLFetcherFactory();

            default:
                throw new ExceptionInInitializerError("Unknown factory type");
        }
    }

    public IContentRetriever createRetriever();
}
