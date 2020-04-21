package TextEditor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class UndoRedoManager
{
    private List<Command> commands;
    private ListIterator<Command> currentCommandListLocation;

    public UndoRedoManager()
    {
        commands = new ArrayList<Command>();
        currentCommandListLocation = commands.listIterator();
    }

    public void addCommandToList(Command command)
    {
        commands.subList(currentCommandListLocation.nextIndex(), commands.size()).clear();

        currentCommandListLocation = commands.isEmpty() ? commands.listIterator() : commands.listIterator(commands.size()-1);

        currentCommandListLocation.add(command);
    }

    public void undo()
    {
        if(canUndo())
        {
            currentCommandListLocation.previous().restorePriorState();
        }
        else
        {
            System.out.println("Cannot undo");
        }
    }

    public void redo()
    {
        if(canRedo())
        {
            currentCommandListLocation.next().execute();
        }
        else
        {
            System.out.println("Cannot redo");
        }
    }

    public boolean canUndo()
    {
        return currentCommandListLocation.hasPrevious();
    }

    public boolean canRedo()
    {
        return currentCommandListLocation.hasNext();
    }
}
