package financeapp.app.dataAccess.abstracts;

import financeapp.app.entities.concretes.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetDao extends JpaRepository<Budget,Integer> {

    List<Budget> getById(int id);
    List<Budget> getByName(String name);
    List<Budget> getByNameAndTotalAmount(String name, double total_amount);
}
