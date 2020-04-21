import java.io.*;

public class Part2Array2D implements Part2Array2DInterface, Serializable
{
    private int[][] array;

    public Part2Array2D(int rows, int cols)
    {
        array = new int[rows][cols];
    }

    public Part2Array2D(String fileName) throws IOException, ClassNotFoundException
    {
        array = load(fileName).array;
    }

    public void set(int row, int col, int value)
    {
        array[row][col] = value;
    }

    public int get(int row, int col)
    {
        return array[row][col];
    }

    public void save(String FileName) throws IOException
    {
        FileOutputStream fs = new FileOutputStream(FileName);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(this);
    }

    public static Part2Array2D load(String FileName) throws IOException, ClassNotFoundException
    {
        FileInputStream fs = new FileInputStream(FileName);
        ObjectInputStream os = new ObjectInputStream(fs);
        return (Part2Array2D)os.readObject();
    }
}
