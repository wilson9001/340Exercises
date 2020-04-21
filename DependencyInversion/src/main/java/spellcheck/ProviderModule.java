package spellcheck;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.IOException;

public class ProviderModule extends AbstractModule
{
    @Provides
    @Provider
    static IValidWordProvider provideProvider()
    {
        try
        {
            return new LocalTextFileDictionary("src/dict.txt");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
