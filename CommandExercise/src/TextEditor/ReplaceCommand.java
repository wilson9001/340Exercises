package TextEditor;

import java.util.Scanner;

public class ReplaceCommand extends CommandWithLength
{
    public ReplaceCommand(IDocument document, String previousString, int startIndex, int length)
    {
        super(document, previousString, startIndex, length);
    }

    public ReplaceCommand(IDocument document, String previousString)
    {
        super(document, previousString);
    }

    @Override
    public void execute()
    {
        super.execute();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Replacement string: ");
        String replacementString = scanner.next();
        document.delete(startIndex, length);
        document.insert(startIndex, replacementString);
    }
}
