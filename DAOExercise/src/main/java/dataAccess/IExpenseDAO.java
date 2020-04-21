package dataAccess;

import model.Expense;

import java.util.List;

public interface IExpenseDAO
{
    public List<Expense> getAllExpenses(String budgetId);
    public boolean createExpense(Expense expense);
    public boolean updateExpense(Expense expense);
    public boolean deleteExpense(String id);
}