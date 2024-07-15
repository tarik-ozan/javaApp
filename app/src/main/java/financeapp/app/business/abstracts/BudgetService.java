package financeapp.app.business.abstracts;

import financeapp.app.core.entities.Users;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.core.utilities.results.Result;
import financeapp.app.entities.concretes.Budget;

import java.util.List;

public interface BudgetService {
    DataResult<List<Budget>> getAll();
    Result add(Budget budget);
    //Result update(Budget budget);
    Result delete(Budget budget);
    DataResult<List<Budget>> getAll(int pageNo, int pageSize);
}
