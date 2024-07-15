package financeapp.app.business.abstracts;

import financeapp.app.core.entities.Users;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.core.utilities.results.Result;


import java.util.List;

public interface UsersService {
    DataResult<List<Users>> getAll();
    DataResult<List<Users>> getAll(int pageNo, int pageSize);
    DataResult<List<Users>> getAllSorted();
    Result add(Users user);
    Result delete(Users user);
    DataResult<Users> getByEmail(String email);

    //DataResult<List<Users>> getAll(int pageNo, int pageSize);

}
