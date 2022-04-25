package com.company.exception;

import com.company.model.ErrorObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalEmployeeException {

    @Autowired
    private ErrorObject errorObject;

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        this.errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        this.errorObject.setMessage(employeeNotFoundException.getMessage());
        this.errorObject.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(this.errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleDepartmentNotFoundException(DepartmentNotFoundException departmentNotFoundException){
        this.errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        this.errorObject.setMessage(departmentNotFoundException.getMessage());
        this.errorObject.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(this.errorObject, HttpStatus.NOT_FOUND);
    }
}
