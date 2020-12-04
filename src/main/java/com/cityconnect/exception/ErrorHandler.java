package com.cityconnect.exception;

import com.cityconnect.utils.CityConnectConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Error Handler for City Connect Service
 *
 * @author dedeepyavinjam
 *
 */
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CityConnectException.class)
  public ResponseEntity<Object> handleCityConnectException(
          CityConnectException ex, WebRequest request) {
    return new ResponseEntity<>(CityConnectConstants.SERVICE_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
          MissingServletRequestParameterException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest request) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
}