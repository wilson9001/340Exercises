
package spellcheck;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class URLFetcher implements IContentRetriever
{

    private String fetch(URL url) throws IOException
    {

        URLConnection connection = url.openConnection();

        StringBuilder contentBuffer = new StringBuilder();

        try (InputStream input = connection.getInputStream())
        {
            int c;
            while ((c = input.read()) >= 0)
            {
                contentBuffer.append((char) c);
            }
        }

        return contentBuffer.toString();
    }

    @Override
    public String getContent(String reference)
    {
        try
        {
            return fetch(new URL(reference));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
}

