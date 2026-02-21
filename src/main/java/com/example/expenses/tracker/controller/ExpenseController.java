package com.example.expenses.tracker.controller;


import com.example.expenses.tracker.dto.ExpenseDto;
import com.example.expenses.tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
