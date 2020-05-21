package com.leyou.common.advice;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(LyException e) {
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getCode()).body(exceptionEnum.getMsg());
    }
}
