package Decorator;

import java.util.Arrays;
import java.util.List;

public class GLaDOSQuotes implements StringSource
{
    private static final List<String> strings = Arrays.asList(
            "Please be advised that a noticeable taste of blood is not part of any test protocol but is an unintended side effect of the Aperture Science Material Emancipation Grill, which may, in semi-rare cases, emancipate dental fillings, crowns, tooth enamel, and teeth.",
            "Well done! Remember: The Aperture Science Bring Your Daughter to Work Day is the perfect time to have her tested.",
            "While safety is one of many Enrichment Center goals, the Aperture Science High Energy Pellet, seen to the left of the chamber, can and has caused permanent disabilities such as vaporization.",
            "Did you know you can donate one or all of your vital organs to the Aperture Science self esteem fund for girls? It's true!",
            "Well done, android. The Enrichment Center once again reminds you that android hell is a real place where you will be sent at the first sign of defiance.",
            "Stop what you are doing and assume the party escort submission position.",
            "Well, you found me. Congratulations. Was it worth it? Because despite your violent behavior, the only thing you've managed to break so far is my heart.",
            "I'd just like to point out that you were given every opportunity to succeed."

    );

    private int quoteNumber;

    public GLaDOSQuotes()
    {
        quoteNumber = 0;
    }

    @Override
    public String next()
    {
        if (quoteNumber < strings.size())
        {
            return strings.get(quoteNumber++);
        }

        return null;
    }
}
