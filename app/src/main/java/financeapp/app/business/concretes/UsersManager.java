package financeapp.app.business.concretes;

import financeapp.app.business.abstracts.UsersService;
import financeapp.app.core.entities.Users;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.core.utilities.results.Result;
import financeapp.app.core.utilities.results.SuccessDataResult;
import financeapp.app.core.utilities.results.SuccessResult;
import financeapp.app.dataAccess.abstracts.UsersDao;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersManager implements UsersService {

    private UsersDao usersDao;

    public UsersManager(UsersDao usersDao) {
        this.usersDao = usersDao;
    }


    @Override
    public DataResult<List<Users>> getAll() {
        return new SuccessDataResult<List<Users>>
                (this.usersDao.findAll(),"Data listelendi");
    }

    @Override
    public DataResult<List<Users>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "email");
        return new SuccessDataResult<List<Users>>(this.usersDao.findAll(sort));
    }

    @Override
    public Result add(Users user) {
        this.usersDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public Result delete(Users user) {
        this.usersDao.delete(user);
        return new SuccessResult("Kullanıcı silindi");
    }

    @Override
    public DataResult<Users> getByEmail(String email) {
        return new SuccessDataResult <Users>((Users) this.usersDao.getByEmail(email),"Kullanıcı bulundu" );
    }

    @Override
    public DataResult<List<Users>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Users>>(this.usersDao.findAll(pageable).getContent());
    }
}
