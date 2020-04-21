package TextEditor;

import java.util.Scanner;

public abstract class Command
{
    private String previousString;
    protected IDocument document;

    public Command(IDocument document, String previousString)
    {
        this.document = document;
        this.previousString = previousString;
    }

    public void restorePriorState()
    {
        document.clear();
        document.insert(0, previousString);
    }

    public abstract void execute();

    protected int getAndValidateNumberInput(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);
        String input = scanner.next();

        int selection = -1;
        try {
            selection = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }

        return selection;
    }
}
