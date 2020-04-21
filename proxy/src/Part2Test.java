public class Part2Test
{
    public static void main(String[] args)
    {
        Part2Array2D part1Array2D = new Part2Array2D(2,2);
        part1Array2D.set(0,0, 0);
        part1Array2D.set(0,1,1);
        part1Array2D.set(1,0,2);
        part1Array2D.set(1,1,3);

        System.out.println(part1Array2D.get(0,0));

        try
        {
            part1Array2D.save("arrayFile");
        }
        catch (Exception ex)
        {
            System.out.println("Failed to save object!");
            return;
        }

        Part2LazyProxy part2LazyProxy = new Part2LazyProxy("arrayFile");

        part2LazyProxy.set(0,0,1);

        System.out.println(part2LazyProxy.get(0,0));
    }
}
