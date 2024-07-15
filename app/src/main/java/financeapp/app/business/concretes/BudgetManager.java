package financeapp.app.business.concretes;

import financeapp.app.business.abstracts.BudgetService;
import financeapp.app.core.entities.Users;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.core.utilities.results.Result;
import financeapp.app.core.utilities.results.SuccessDataResult;
import financeapp.app.core.utilities.results.SuccessResult;
import financeapp.app.dataAccess.abstracts.BudgetDao;
import financeapp.app.entities.concretes.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetManager implements BudgetService {

    private BudgetDao budgetDao;

    @Autowired
    public BudgetManager(BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }

    @Override
    public DataResult<List<Budget>> getAll() {
        return new SuccessDataResult<List<Budget>>(this.budgetDao.findAll(),"Bütçeler listelendi");
    }



    @Override
    public Result add(Budget budget) {
        this.budgetDao.save(budget);
        return new SuccessResult("Yeni bütçe eklendi") ;
    }


    @Override
    public Result delete(Budget budget) {
        return new SuccessResult("Bütçe silindi");
    }


    @Override
    public DataResult<List<Budget>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Budget>>(this.budgetDao.findAll(pageable).getContent());
    }
}
