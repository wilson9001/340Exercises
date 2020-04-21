package spellcheck;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ParserModule extends AbstractModule
{
    @Provides
    @Parser
    static IParser provideParser()
    {
        return new PlainTextWordExtractor();
    }
}
