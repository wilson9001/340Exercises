package dataAccess;

public interface IDAOFactory
{
    public static IExpenseDAOFactory createExpenseDAOFactory()
    {
        return new ExpenseDAOFactory();
    }

    public static IDBInitializerFactory createDBInitializerFactory()
    {
        return new DBInitializerFactory();
    }
}