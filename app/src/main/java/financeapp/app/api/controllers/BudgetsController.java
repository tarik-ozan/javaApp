package financeapp.app.api.controllers;

import financeapp.app.business.abstracts.BudgetService;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.entities.concretes.Budget;
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
@RequestMapping(value = "/api/budgets")
@CrossOrigin
public class BudgetsController {

    private BudgetService budgetService;


    @Autowired
    public BudgetsController(BudgetService budgetService) {
        super();
        this.budgetService = budgetService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Budget budget) {

        return ResponseEntity.ok(this.budgetService.add(budget)) ;
    }

    @DeleteMapping(path = "/delete")
    ResponseEntity<?> delete(@Valid @RequestBody Budget budget) {
        return ResponseEntity.ok(this.budgetService.delete(budget));
    }

    @GetMapping(path = "/getall")
    public DataResult<List<Budget>> getAll() {
        return this.budgetService.getAll();
    }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
//
//        Map<String, String> validationErrors = new HashMap<String, String>();
//        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
//
//            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
//
//        }
//
//        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
//        return errors;
//    }
}
