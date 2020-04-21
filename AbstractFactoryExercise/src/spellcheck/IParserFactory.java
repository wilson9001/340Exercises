package spellcheck;

public interface IParserFactory
{
    public enum ParserType
    {
        PlainText
    }

    public static IParserFactory createFactory(ParserType parserType)
    {
        switch (parserType)
        {
            case PlainText:
                return new PlainTextFactory();

            default:
                throw new ExceptionInInitializerError("Unknown factory type");
        }
    }

    public IParser createParser();
}
