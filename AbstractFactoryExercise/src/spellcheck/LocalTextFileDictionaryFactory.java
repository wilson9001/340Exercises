package spellcheck;

public class LocalTextFileDictionaryFactory implements IValidWordProviderFactory
{
    @Override
    public IValidWordProvider createValidWordProvider(String sourceLocation) throws Exception
    {
        return new LocalTextFileDictionary(sourceLocation);
    }
}
