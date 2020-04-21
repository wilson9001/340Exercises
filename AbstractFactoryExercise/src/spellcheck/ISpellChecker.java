package spellcheck;

import java.util.SortedMap;

public interface ISpellChecker
{
    public SortedMap<String, Integer> check(String reference);
}
