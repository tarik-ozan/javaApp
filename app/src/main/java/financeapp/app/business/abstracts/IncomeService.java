package financeapp.app.business.abstracts;
import financeapp.app.core.utilities.results.Result;
import financeapp.app.entities.concretes.Income;

import financeapp.app.core.utilities.results.DataResult;

import java.util.List;

public interface IncomeService {
    DataResult<List<Income>> getAll();
    Result add(Income income);
    //Result update(Income income);
    Result delete(Income income);
    DataResult<List<Income>> getAll(int pageNo, int pageSize);

}
