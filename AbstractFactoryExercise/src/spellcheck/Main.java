
package spellcheck;

import java.io.IOException;
import java.util.SortedMap;


public class Main
{

    public static void main(String[] args)
    {

        try
        {
            String reference = args[0];

            IContentRetrieverFactory contentRetrieverFactory = IContentRetrieverFactory.createFactory(IContentRetrieverFactory.RetrieverType.URLFetcher);
            IParserFactory parserFactory = IParserFactory.createFactory(IParserFactory.ParserType.PlainText);
            IValidWordProviderFactory validWordProviderFactory = IValidWordProviderFactory.createFactory(IValidWordProviderFactory.ValidWordProviderType.LocalTextFileDictionary);

            assert(contentRetrieverFactory instanceof URLFetcherFactory);
            assert(parserFactory instanceof PlainTextFactory);
            assert(validWordProviderFactory instanceof LocalTextFileDictionaryFactory);

            ISpellChecker checker = new SpellingChecker(contentRetrieverFactory, parserFactory, validWordProviderFactory, "dict.txt");
            SortedMap<String, Integer> mistakes = checker.check(reference);
            System.out.println(mistakes);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

