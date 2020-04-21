
package spellcheck;

import javax.inject.Inject;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SpellingChecker implements ISpellChecker
{
    private IContentRetriever contentRetriever;
    private IParser parser;
    private IValidWordProvider validWordProvider;

    @Inject
    public SpellingChecker(@Retriever IContentRetriever contentRetriever, @Parser IParser parser, @Provider IValidWordProvider validWordProvider)
    {
        this.contentRetriever = contentRetriever;
        this.parser = parser;
        this.validWordProvider = validWordProvider;
    }

    public SortedMap<String, Integer> check(String reference)
    {

        String content = contentRetriever.getContent(reference);

        List<String> words = parser.parseContent(content);

        SortedMap<String, Integer> mistakes = new TreeMap<>();

        for (String word : words)
        {
            if (!validWordProvider.isValidWord(word))
            {
                if (mistakes.containsKey(word))
                {
                    int oldCount = mistakes.get(word);
                    mistakes.put(word, oldCount + 1);
                } else
                {
                    mistakes.put(word, 1);
                }
            }
        }

        return mistakes;
    }
}

