package Adapter;

import java.util.Arrays;
import java.util.List;

public class ContactManagerTableAdapter implements TableData
{
    private ContactManager contactManager;
    private static final List<String> columnNames = Arrays.asList("First Name", "Last Name", "Phone", "Email");
    private static final List<Integer> columnWidths = Arrays.asList(12, 12, 17, 32);
    private static final List<Justification> columnJustifications = Arrays.asList(Justification.Left, Justification.Left, Justification.Center, Justification.Left);
    private char headerUnderline;
    private int columnSpacing, rowSpacing;

    public ContactManagerTableAdapter(ContactManager contactManager,
                                      char headerUnderline,
                                      int columnSpacing,
                                      int rowSpacing)
    {
        this.contactManager = contactManager;
        this.headerUnderline = headerUnderline;
        this.columnSpacing = columnSpacing;
        this.rowSpacing = rowSpacing;
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.size();
    }

    @Override
    public int getRowCount()
    {
        return contactManager.getContactCount();
    }

    @Override
    public int getColumnSpacing()
    {
        return columnSpacing;
    }

    @Override
    public int getRowSpacing()
    {
        return rowSpacing;
    }

    @Override
    public char getHeaderUnderline()
    {
        return headerUnderline;
    }

    @Override
    public String getColumnHeader(int col)
    {
        return columnNames.get(col);
    }

    @Override
    public int getColumnWidth(int col)
    {
        return columnWidths.get(col);
    }

    @Override
    public Justification getColumnJustification(int col)
    {
        return columnJustifications.get(col);
    }

    @Override
    public String getCellValue(int row, int col)
    {
        Contact contact =  contactManager.getContact(row);

        switch (col)
        {
            case 0:
                return contact.getFirstName();

            case 1:
                return contact.getLastName();

            case 2:
                return contact.getPhone();

            case 3:
                return contact.getEmail();

            default:
                return "UNKNOWN COLUMN";
        }
    }
}
