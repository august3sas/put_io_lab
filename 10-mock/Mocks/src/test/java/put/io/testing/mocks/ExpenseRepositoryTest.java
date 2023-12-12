package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void testLoadExpenses() {
        IFancyDatabase myDatabase = new MyDatabase();
        ExpenseRepository expRep = new ExpenseRepository(myDatabase);
        expRep.loadExpenses();
        assertTrue(expRep.getExpenses().isEmpty());
    }

    @Test
    void testLoadExpensesMockito(){
        IFancyDatabase myDatabase = mock(IFancyDatabase.class);
        when(myDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository expRep = new ExpenseRepository(myDatabase);
        expRep.loadExpenses();
        verify(myDatabase).connect();
        verify(myDatabase).queryAll();
        verify(myDatabase).close();
        assertTrue(expRep.getExpenses().isEmpty());
    }
    @Test
    void testLoadExpensesMockitoInOrder(){
        IFancyDatabase myDatabase = mock(IFancyDatabase.class);
        when(myDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository expRep = new ExpenseRepository(myDatabase);
        expRep.loadExpenses();
        InOrder inOrder = inOrder(myDatabase);
        inOrder.verify(myDatabase).connect();
        inOrder.verify(myDatabase).queryAll();
        inOrder.verify(myDatabase).close();
        assertTrue(expRep.getExpenses().isEmpty());
    }
    @Test
    void testLoadExpensesMockitoInOrder2(){
        IFancyDatabase myDatabase = mock(IFancyDatabase.class);
        when(myDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository expRep = new ExpenseRepository(myDatabase);
        Expense expense = new Expense();
        Expense expense1 = new Expense();
        Expense expense2 = new Expense();
        Expense expense3 = new Expense();
        Expense expense4 = new Expense();
        expRep.addExpense(expense);
        expRep.addExpense(expense1);
        expRep.addExpense(expense2);
        expRep.addExpense(expense3);
        expRep.addExpense(expense4);
        expRep.saveExpenses();

        verify(myDatabase, times(5)).persist(any(Expense.class));
        expRep.loadExpenses();
        InOrder inOrder = inOrder(myDatabase);
        inOrder.verify(myDatabase).connect();
        inOrder.verify(myDatabase).queryAll();
        inOrder.verify(myDatabase).close();
        assertTrue(expRep.getExpenses().isEmpty());
    }

}
