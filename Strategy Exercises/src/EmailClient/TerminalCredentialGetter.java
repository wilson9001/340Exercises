package EmailClient;

import java.util.ArrayList;
import java.util.List;

public class TerminalCredentialGetter implements CredentialGetter
{
    @Override
    public List<String> getCredentials()
    {
        //look for login credentials in command line arguments or ask for login credentials from terminal if necessary.

        return new ArrayList<>();
    }
}
