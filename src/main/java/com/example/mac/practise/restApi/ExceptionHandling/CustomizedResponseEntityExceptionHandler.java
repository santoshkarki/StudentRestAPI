package com.example.mac.practise.restApi.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ErrorDetails handleStudentNotFoundException(StudentNotFoundException exp, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND,"API1_0025", exp.getCause(), exp.getMessage(),request.getDescription(true));
        return errorDetails;
    }
}
