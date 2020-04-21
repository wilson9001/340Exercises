package spellcheck;

import java.util.ArrayList;
import java.util.List;

public class MockParser implements IParser
{
    @Override
    public List<String> parseContent(String content)
    {
        List<String> returnList = new ArrayList<>(1);
        returnList.add("mockEntry");
        return returnList;
    }
}
