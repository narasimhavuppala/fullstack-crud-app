package com.example.coding.demo.api;

import com.example.coding.demo.model.Employee;
import com.example.coding.demo.service.EmployeeService;
import com.example.coding.demo.util.ObjectNotFound;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@Tag(name = "Employee Controller", description = "this would provide the means to operate on employee domain object")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> findByEmpId(@PathVariable Integer id) {
        Optional<Employee> optionalEmployee = this.employeeService.getEmployee(id);
        if (optionalEmployee.isPresent()) {
            return new ResponseEntity<>(optionalEmployee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody @Valid Employee employee) {
        return this.employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable Integer id) throws ObjectNotFound {
        return new ResponseEntity<>(this.employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server"),
            @ApiResponse(responseCode = "404", description = "Service not found"),
            @ApiResponse(responseCode = "200", description = "Successful retrieval")})
    public ResponseEntity<String> deleteByEmpId(@PathVariable Integer id) {
        Optional<Employee> optionalEmployee = this.employeeService.getEmployee(id);
        if (optionalEmployee.isPresent()) {
            this.employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee does not exist with the id:" + id, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<String> handleObjectNotFound(ObjectNotFound objectNotFound) {
        return new ResponseEntity(objectNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }
}
