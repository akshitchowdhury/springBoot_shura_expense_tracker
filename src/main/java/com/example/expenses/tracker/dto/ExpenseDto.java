package com.example.expenses.tracker.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDto {

    private Long id;

    @Positive(message = "AMount must be greater than 0")
    private double amount;

    @NotBlank(message= "Description cannot be empty")
    private String description;


    private String expense_category;

    private double total_amount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
