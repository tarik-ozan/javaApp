package financeapp.app.dataAccess.abstracts;

import financeapp.app.entities.concretes.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeDao extends JpaRepository<Income, Integer> {
    List<Income> getById(int id);
    List<Income> getByAmountAndDescription(double amount, String description);


}
