package com.volvo.vehiclemgmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {
	@ExceptionHandler(BusinessExceptionError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object processValidationError(BusinessExceptionError ex) {
        String result = ex.getErrorMessage();
        System.out.println("###########" + result);
        return ex;
    }
}
