package com.example.expenses.tracker.repository;

import com.example.expenses.tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long > {
}
