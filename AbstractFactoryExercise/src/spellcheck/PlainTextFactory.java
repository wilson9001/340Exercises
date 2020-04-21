package spellcheck;

public class PlainTextFactory implements IParserFactory
{
    @Override
    public IParser createParser()
    {
        return new PlainTextWordExtractor();
    }
}
