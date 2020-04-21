package TextEditor;

import java.util.Scanner;

public class InsertCommand extends CommandWithStartIndex
{
    private String sequenceToInsert;

    public InsertCommand(IDocument document, String previousString, int startIndex, String sequenceToInsert)
    {
        super(document, previousString, startIndex);
        this.sequenceToInsert = sequenceToInsert;
    }

    public InsertCommand(IDocument document, String previousString)
    {
        this(document, previousString, -1, null);
    }

    @Override
    public void execute()
    {
        super.execute();

        if(sequenceToInsert == null)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Sequence to insert: ");
            sequenceToInsert = scanner.next();
        }

        document.insert(startIndex, sequenceToInsert);
    }
}
