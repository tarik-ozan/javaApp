package financeapp.app.api.controllers;

import financeapp.app.business.abstracts.ExpenseService;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.entities.concretes.Expense;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/expenses")
@CrossOrigin
public class ExpenseController {


    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Expense>> getAll(int pageNo, int pageSize){
        return this.expenseService.getAll(pageNo, pageSize);
    }

    @GetMapping(path = "/getall")
    public DataResult<List<Expense>> getAll() {
        return this.expenseService.getAll();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Expense expense) {

        return ResponseEntity.ok(this.expenseService.add(expense)) ;
    }

    @DeleteMapping(path = "/delete")
    ResponseEntity<?> delete(@Valid @RequestBody Expense expense) {
        return ResponseEntity.ok(this.expenseService.delete(expense));
    }

}
