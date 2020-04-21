package Decorator;

public class AllCapsDecorator extends Decorator
{
    public AllCapsDecorator(StringSource stringSource)
    {
        super(stringSource);
    }

    @Override
    public String next()
    {
        String nextString = stringSource.next();

        if (nextString != null)
        {
            nextString = nextString.toUpperCase();
        }

        return nextString;
    }
}
