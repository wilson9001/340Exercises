package Decorator;

public class RunOnDecorator extends Decorator
{
    public RunOnDecorator(StringSource stringSource)
    {
        super(stringSource);
    }

    @Override
    public String next()
    {
        String nextString = stringSource.next();

        if (nextString != null)
        {
           nextString = nextString.replaceAll("[.?!,;:–]", "");
        }

        return nextString;
    }
}
