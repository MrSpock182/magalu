package io.com.github.mrspock182.magalu.interceptor.implementation;

import io.com.github.mrspock182.magalu.domain.dto.ErrorResponse;
import io.com.github.mrspock182.magalu.exception.BadRequestException;
import io.com.github.mrspock182.magalu.exception.InternalServerErrorException;
import io.com.github.mrspock182.magalu.exception.NotFoundException;
import io.com.github.mrspock182.magalu.exception.Unauthorized;
import io.com.github.mrspock182.magalu.interceptor.StackLogger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {

    private final StackLogger stackLogger;

    public RestExceptionHandler(StackLogger stackLogger) {
        this.stackLogger = stackLogger;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(final NotFoundException notFound,
                                        final WebRequest request) {
        return new ErrorResponse(new Date(),
                request.getContextPath(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                notFound.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(final BadRequestException badRequest,
                                          final WebRequest request) {
        return new ErrorResponse(new Date(),
                request.getContextPath(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                badRequest.getMessage());
    }

    @ExceptionHandler(Unauthorized.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleUnauthorized(final Unauthorized badRequest,
                                          final WebRequest request) {
        return new ErrorResponse(new Date(),
                request.getContextPath(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                badRequest.getMessage());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternalServerError(final InternalServerErrorException internalServerError,
                                                   final WebRequest request) {
        stackLogger.log(internalServerError);
        return new ErrorResponse(new Date(),
                request.getContextPath(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                internalServerError.getMessage());
    }

}
