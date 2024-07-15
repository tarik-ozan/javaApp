package financeapp.app.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithBudgetDto {
    private int id;
    private String firstName;
    private String budgetName;
}
