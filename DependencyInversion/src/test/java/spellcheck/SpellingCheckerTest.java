package spellcheck;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeAll;

import java.util.SortedMap;

class SpellingCheckerTest
{
    private static ISpellChecker checker;
    private static final String url = "https://pastebin.com/raw/t6AZ5kx3";

    @BeforeAll
    static void setup()
    {
        Injector injector = Guice.createInjector(new MockProviderModule(), new MockRetrieverModule(), new MockParserModule());
        checker = injector.getInstance(SpellingChecker.class);
    }

    @org.junit.jupiter.api.Test
    void check()
    {
        SortedMap<String, Integer> mistakes = checker.check(url);
        System.out.println(mistakes);
    }
}