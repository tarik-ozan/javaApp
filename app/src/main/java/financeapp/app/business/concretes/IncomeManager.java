package financeapp.app.business.concretes;

import financeapp.app.business.abstracts.IncomeService;
import financeapp.app.core.entities.Users;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.core.utilities.results.Result;
import financeapp.app.core.utilities.results.SuccessDataResult;
import financeapp.app.core.utilities.results.SuccessResult;
import financeapp.app.dataAccess.abstracts.IncomeDao;
import financeapp.app.entities.concretes.Income;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeManager implements IncomeService {


    private IncomeDao incomeDao;

    public IncomeManager(IncomeDao incomeDao) {
        this.incomeDao = incomeDao;
    }

    @Override
    public DataResult<List<Income>> getAll() {
        return new SuccessDataResult<List<Income>>(this.incomeDao.findAll(),"Gelirler listelendi");
    }

    @Override
    public Result add(Income income) {
        this.incomeDao.save(income);
        return new SuccessResult("Yeni gelir eklendi");
    }

    @Override
    public Result delete(Income income) {
        this.incomeDao.delete(income);
        return new SuccessResult("Gelir silindi");
    }

    @Override
    public DataResult<List<Income>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Income>>(this.incomeDao.findAll(pageable).getContent());
    }
}



