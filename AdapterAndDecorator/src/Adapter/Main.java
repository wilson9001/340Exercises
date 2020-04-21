package Adapter;

import java.io.IOException;
import java.io.PrintWriter;

public class Main
{
    public static void main(String[] args)
    {
        ContactManager contactManager = new ContactManager();

        for (int i = 0; i < 10; i++)
        {
            contactManager.addContact(new Contact("Contact", String.valueOf(i), String.format("%d%d%d-%d%d%d-%d%d%d%d", i, i, i, i, i, i, i, i, i, i), String.format("contact%d@fakemail.com", i)));
        }

        ContactManagerTableAdapter contactManagerTableAdapter = new ContactManagerTableAdapter(contactManager, '-', 2, 1);

        PrintWriter systemOut = new PrintWriter(System.out);

        try (systemOut)
        {
            Table table = new Table(systemOut, contactManagerTableAdapter);
            table.display();
        } catch (IOException e)
        {
            System.err.println("IOException occurred");
            e.printStackTrace();
        }
    }
}
