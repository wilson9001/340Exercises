package Decorator;

public abstract class Decorator implements StringSource
{
    protected StringSource stringSource;

    public Decorator(StringSource stringSource)
    {
        this.stringSource = stringSource;
    }

    @Override
    public abstract String next();
}
