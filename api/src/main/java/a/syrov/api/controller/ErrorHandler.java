package a.syrov.api.controller;

import a.syrov.api.exceptions.ErrorResponse;
import a.syrov.api.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        return ErrorResponse
                .builder()
                .errors(getErrorsFrom(ex.getBindingResult()))
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundEx(NotFoundException ex) {
        return ErrorResponse
                .builder()
                .globalErrors(Collections.singletonList(ex.getMessage()))
                .build();
    }

    private static LinkedMultiValueMap<String, String> getErrorsFrom(BindingResult bindingResult) {
        if (bindingResult == null || !bindingResult.hasErrors()) {
            return null;
        }
        LinkedMultiValueMap<String, String> errors = new LinkedMultiValueMap<>();
        if (bindingResult.hasFieldErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getField(), error.getDefaultMessage());
            }
        }
        if (bindingResult.hasGlobalErrors()) {
            for (ObjectError error : bindingResult.getGlobalErrors()) {
                errors.add(error.getObjectName(), error.getDefaultMessage());
            }
        }
        return errors;
    }
}
