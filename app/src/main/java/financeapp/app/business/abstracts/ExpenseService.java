package financeapp.app.business.abstracts;

import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.core.utilities.results.Result;
import financeapp.app.entities.concretes.Expense;

import java.util.List;

public interface ExpenseService {
    DataResult<List<Expense>> getAll();
    DataResult<List<Expense>> getAll(int pageNo, int pageSize);
    Result add(Expense expense);
    //Result update(Income income);
    Result delete(Expense expense);


}
