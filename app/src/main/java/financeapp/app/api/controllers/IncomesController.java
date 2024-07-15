package financeapp.app.api.controllers;

import financeapp.app.business.abstracts.IncomeService;
import financeapp.app.core.utilities.results.DataResult;
import financeapp.app.entities.concretes.Income;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/incomes")
@CrossOrigin
public class IncomesController {


    private IncomeService incomeService;


    @Autowired
    public IncomesController(IncomeService incomeService) {
        super();
        this.incomeService = incomeService;
    }
    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Income income) {

        return ResponseEntity.ok(this.incomeService.add(income)) ;
    }

    @DeleteMapping(path = "/delete")
    ResponseEntity<?> delete(@Valid @RequestBody Income income) {
        return ResponseEntity.ok(this.incomeService.delete(income));
    }

    @GetMapping(path = "/getall")
    public DataResult<List<Income>> getAll() {
        return this.incomeService.getAll();
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Income>> getAll(int pageNo, int pageSize){
        return this.incomeService.getAll(pageNo, pageSize);
    }
}
