
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
            ISpellChecker checker = new SpellingChecker(new URLFetcher(), new PlainTextWordExtractor(), new LocalTextFileDictionary("dict.txt"));
            SortedMap<String, Integer> mistakes = checker.check(reference);
            System.out.println(mistakes);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

