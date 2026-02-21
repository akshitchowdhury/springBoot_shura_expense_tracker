package com.example.expenses.tracker.service;


import com.example.expenses.tracker.dto.ExpenseDto;
import com.example.expenses.tracker.model.Expense;
import com.example.expenses.tracker.repository.ExpenseRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepo;

    // Spring sees this constructor and automatically injects the BookRepository bean
    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    @PostConstruct
    public void seedDatabase() {
        System.out.println("🌱 Bean Lifecycle: ExpenseService is initialized. Seeding data...");
        expenseRepo.save(new Expense(null, 299, "Movie ticket", 1345678 , LocalDate.now()));
        expenseRepo.save(new Expense(null, 3000, "Travel ticket", 114590078 , LocalDate.now()));
        expenseRepo.save(new Expense(null, 7000, "Shopping ", 12458790 , LocalDate.now()));

    }

    public List<ExpenseDto> getAllExpenses() {
        return expenseRepo.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    private ExpenseDto convertToDTO(Expense expense) {
        ExpenseDto dto = new ExpenseDto();
        dto.setId(expense.getId());
        dto.setAmount(expense.getAmount());
        dto.setDescription(expense.getDescription());

        if(expense.getAmount()> 1000){
            dto.setExpense_category("Luxury item");
        }
        else{
            dto.setExpense_category("Essential item");
        }
        dto.setDate(expense.getDate());
        return dto;
    }

}
