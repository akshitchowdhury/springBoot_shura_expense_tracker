package com.example.expenses.tracker.controller;


import com.example.expenses.tracker.dto.ExpenseDto;
import com.example.expenses.tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Combines @Controller and @ResponseBody
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

  @GetMapping
  public List<ExpenseDto> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/totalSum")
    public Double getTotalSum(){
        return expenseService.getTotalSum();
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@Valid @RequestBody ExpenseDto dto) {
        // We pass the DTO (Request) to the service
        ExpenseDto savedDto = expenseService.saveExpense(dto);

        // Return the saved DTO with a 201 Created status
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }


}
