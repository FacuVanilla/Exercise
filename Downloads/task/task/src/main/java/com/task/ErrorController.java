package com.task;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> handleRuntimeException(RuntimeException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = e.getMessage();
        if (message == null) {
            message = ErrorMessages.ERROR_500;
        } else if (message.equals("400")) {
            status = HttpStatus.BAD_REQUEST;
            message = ErrorMessages.ERROR_400;
        } else if (message.equals("401")) {
            status = HttpStatus.UNAUTHORIZED;
            message = ErrorMessages.ERROR_401;
        } else if (message.equals("403")) {
            status = HttpStatus.FORBIDDEN;
            message = ErrorMessages.ERROR_403;
        } else if (message.equals("404")) {
            status = HttpStatus.NOT_FOUND;
            message = ErrorMessages.ERROR_404;
        }
        Response response = new Response(status.value(), message);
        return ResponseEntity.status(status).body(response);
    }

}
