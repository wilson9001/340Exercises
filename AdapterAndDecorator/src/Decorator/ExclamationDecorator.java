package Decorator;

public class ExclamationDecorator extends Decorator
{
    public ExclamationDecorator(StringSource stringSource)
    {
        super(stringSource);
    }

    @Override
    public String next()
    {
        String nextString = stringSource.next();

        if (nextString != null)
        {
            nextString = nextString.replace('.', '!');
        }

        return nextString;
    }
}
