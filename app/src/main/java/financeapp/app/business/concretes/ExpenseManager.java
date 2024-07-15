package financeapp.app.business.concretes;

import financeapp.app.business.abstracts.ExpenseService;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.core.utilities.results.Result;
import financeapp.app.core.utilities.results.SuccessDataResult;
import financeapp.app.core.utilities.results.SuccessResult;
import financeapp.app.dataAccess.abstracts.ExpenseDao;
import financeapp.app.entities.concretes.Expense;
import financeapp.app.entities.concretes.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseManager implements ExpenseService {

    private ExpenseDao expenseDao;


    @Autowired
    public ExpenseManager(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }


    @Override
    public DataResult<List<Expense>> getAll() {
        return new SuccessDataResult<List<Expense>>(this.expenseDao.findAll(),"Giderler listelendi");
    }

    @Override
    public DataResult<List<Expense>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Expense>>(this.expenseDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Expense expense) {
        this.expenseDao.save(expense);
        return new SuccessResult("Yeni gider eklendi");
    }

    @Override
    public Result delete(Expense expense) {
        this.expenseDao.delete(expense);
        return new SuccessResult("Gider silindi");
    }
}
