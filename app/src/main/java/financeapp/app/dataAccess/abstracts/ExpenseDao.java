package financeapp.app.dataAccess.abstracts;

import financeapp.app.entities.concretes.Expense;
import financeapp.app.entities.concretes.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseDao extends JpaRepository<Expense, Integer> {
    List<Expense> getById(int id);
    List<Expense> getByAmountAndDescription(double amount, String description);
}
