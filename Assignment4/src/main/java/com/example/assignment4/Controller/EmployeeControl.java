package com.example.assignment4.Controller;

import com.example.assignment4.ApiCont;
import com.example.assignment4.Model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class EmployeeControl {
    ArrayList<Employee> employees= new ArrayList<>();
@GetMapping("/Employee")
    public ArrayList<Employee> getEmployee() {
        return employees;
    }
    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body (new ApiCont("Employee Have been added"));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity UpdateEmployee(@PathVariable int index, @RequestBody Employee employee, @Valid Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message);
        }
        employees.set(index, employee);
        return ResponseEntity.status(200).body (new ApiCont("Employee info have been updated :)"));
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable @Valid int index){
      employees.remove(index);
        return ResponseEntity.status(200).body(new ApiCont("Employee has been deleted :0"));
    }
}
