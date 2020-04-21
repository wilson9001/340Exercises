package Decorator;

public class Main
{
    private static void printAllLines(StringSource stringSource)
    {
        String nextString = stringSource.next();

        while(nextString != null)
        {
            System.out.println(nextString);
            nextString = stringSource.next();
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args)
    {
        printAllLines(new ExclamationDecorator(new GLaDOSQuotes()));
        printAllLines(new RunOnDecorator(new GLaDOSQuotes()));
        printAllLines(new AllCapsDecorator(new RunOnDecorator(new WhatIsPower1984Quote())));
    }
}
