package com.example.assignment4.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data @AllArgsConstructor
public class Employee {
    @NotNull(message = "Please do write something!")
    @Size(min = 2, message = "Your Id can't be less than two ")
    private String id;
    @NotNull(message = "Please do write something!")
    @Size(min = 4, message = "Name should consists of at least 4 letters")
    private String name;
    @NotNull(message = "Type something!")
    @Min(message = "Your Age Must Be More Than 25, Sorry!", value = 25)
    private String age;
    @AssertFalse
    private boolean onLeave;
    @NotNull
    @Range(max =2023, min = 1990)
    private String employmentYear;
    @NotNull
    @PositiveOrZero
    private String annualLeave;

}
