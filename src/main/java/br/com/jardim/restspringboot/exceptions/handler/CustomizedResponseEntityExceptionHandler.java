package br.com.jardim.calculatorspringbootandjava.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.jardim.calculatorspringbootandjava.exceptions.ExceptionResponse;
import br.com.jardim.calculatorspringbootandjava.exceptions.UnsupportedMathOperationException;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity <ExceptionResponse> handleAllExceptions(
            Exception ex, WebRequest request) {
        ExceptionResponse exceptionsResponse = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity <ExceptionResponse> handleBadRequestExceptions(
            Exception ex, WebRequest request) {
        ExceptionResponse exceptionsResponse = new ExceptionResponse(
                new Date(), ex.getMessage(),  request.getDescription(false));
        return new ResponseEntity<>(exceptionsResponse, HttpStatus.BAD_REQUEST);
    }
}
