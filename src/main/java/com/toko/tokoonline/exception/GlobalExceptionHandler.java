package com.toko.tokoonline.exception;

import com.toko.tokoonline.response.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException){
        return ResponseHelper.error(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<?> internalError(InternalErrorException notFoundException){
        return ResponseHelper.error(notFoundException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
