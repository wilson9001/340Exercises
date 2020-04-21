package spellcheck;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class MockParserModule extends AbstractModule
{
    @Provides
    @Parser
    static IParser provideParser()
    {
        return new MockParser();
    }
}
