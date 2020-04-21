package spellcheck;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class MockProviderModule extends AbstractModule
{
    @Provides
    @Provider
    static IValidWordProvider provideProvider()
    {
        return new MockValidWordProvider();
    }
}
