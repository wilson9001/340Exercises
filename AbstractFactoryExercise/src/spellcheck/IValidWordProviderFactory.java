package spellcheck;

public interface IValidWordProviderFactory
{
    public enum ValidWordProviderType
    {
        LocalTextFileDictionary
    }

    public static IValidWordProviderFactory createFactory(ValidWordProviderType validWordProviderType)
    {
        switch (validWordProviderType)
        {
            case LocalTextFileDictionary:
                return new LocalTextFileDictionaryFactory();

            default:
                throw new ExceptionInInitializerError("Unknown factory type");
        }
    }

    public IValidWordProvider createValidWordProvider(String sourceLocation) throws Exception;
}
