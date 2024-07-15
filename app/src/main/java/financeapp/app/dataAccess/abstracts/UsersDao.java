package financeapp.app.dataAccess.abstracts;

import financeapp.app.core.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersDao extends JpaRepository<Users, Integer> {

    List<Users> getByEmail(String email);
    List<Users> getByEmailAndPassword(String email, String password);
    List<Users> getByEmailOrPassword(String email, String password);



}
