package spellcheck;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class RetrieverModule extends AbstractModule
{
    @Provides
    @Retriever
    static IContentRetriever provideRetriever()
    {
        return new URLFetcher();
    }

}
