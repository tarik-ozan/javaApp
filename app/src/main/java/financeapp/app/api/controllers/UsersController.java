package financeapp.app.api.controllers;

import financeapp.app.business.abstracts.UsersService;
import financeapp.app.core.entities.Users;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.core.utilities.results.ErrorDataResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {




    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/getall")
    public DataResult<List<Users>> getAll() {
        return this.usersService.getAll();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Users user) {

        return ResponseEntity.ok(this.usersService.add(user));

    }
        //public Result add(@RequestBody Users user) {
        //return this.usersService.add(user);}


    @DeleteMapping(path = "/delete")
    ResponseEntity<?> delete(@Valid @RequestBody Users user) {
        return ResponseEntity.ok(this.usersService.delete(user));
    }
    //public Result delete(@RequestBody Users user) {
    //  return this.usersService.delete(user);}

    @GetMapping("/getAllByPage")
    DataResult<List<Users>> getAll(int pageNo, int pageSize){
        return this.usersService.getAll(pageNo, pageSize);
    }


    @GetMapping("/getAllAsc")
    DataResult<List<Users>> getAllSorted(){
        return this.usersService.getAllSorted();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {

            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());

        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
        return errors;
    }

}
