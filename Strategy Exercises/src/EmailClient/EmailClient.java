package EmailClient;

import java.util.List;

public class EmailClient
{
    private CredentialGetter credentialGetter;
    private List<String> credentials;

    public EmailClient(CredentialGetter credentialGetter)
    {
        this.credentialGetter = credentialGetter;
        credentials = null;
    }

    public boolean sendEmail(String rawEmailHTML)
    {
        //perform any necessary checking on RawEmailHTML
        //create connection to email server and check if login is necessary
        boolean loginRequired = true;

        if (loginRequired && credentials == null)
        {
           credentials = credentialGetter.getCredentials();
        }

        //send email with or without credentials

        //return results of sending email
        return false;
    }
}
