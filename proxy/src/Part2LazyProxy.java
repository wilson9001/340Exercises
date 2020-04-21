import java.io.IOException;

public class Part2LazyProxy implements Part2Array2DInterface
{
    private Part2Array2D array;
    private String fileName;
    private int rows, cols;

    public Part2LazyProxy(int rows, int cols)
    {
        array = null;
        this.rows = rows;
        this.cols = cols;
    }

    public Part2LazyProxy(String fileName)
    {
        array = null;
        this.fileName = fileName;
        rows = -1;
        cols = -1;
    }

    private void loadIfNecessary() throws IOException, ClassNotFoundException
    {
        if (array == null)
        {
            if (fileName != null)
            {
                array = new Part2Array2D(fileName);
            }

            else
            {
                array = new Part2Array2D(rows, cols);
            }
        }
    }

    public void set(int row, int col, int value)
    {
        try
        {
            loadIfNecessary();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return;
        }

        array.set(row, col, value);
    }

    public int get(int row, int col)
    {
        try
        {
            loadIfNecessary();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }

        return array.get(row, col);
    }
}
