
package spellcheck;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.SortedMap;

public class Main
{

    public static void main(String[] args)
    {

        try
        {
            String reference = args[0];

            //ISpellChecker checker = new SpellingChecker(new URLFetcher(), new PlainTextWordExtractor(), new LocalTextFileDictionary("src/dict.txt"));
            Injector injector = Guice.createInjector(new RetrieverModule(), new ProviderModule(), new ParserModule());
            ISpellChecker checker = injector.getInstance(SpellingChecker.class);

            SortedMap<String, Integer> mistakes = checker.check(reference);
            System.out.println(mistakes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

