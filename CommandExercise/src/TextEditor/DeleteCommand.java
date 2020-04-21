package TextEditor;

public class DeleteCommand extends CommandWithLength
{

    public DeleteCommand(IDocument document, String previousString, int startIndex, int length)
    {
        super(document, previousString, startIndex, length);
    }

    public DeleteCommand(IDocument document, String previousString)
    {
        super(document, previousString);
    }

    @Override
    public void execute()
    {
        super.execute();

        if (document.delete(startIndex, length) == null) {
            System.out.println("Deletion unsuccessful");
        }
    }
}
