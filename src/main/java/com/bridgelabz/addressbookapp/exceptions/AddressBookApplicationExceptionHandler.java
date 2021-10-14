package com.bridgelabz.addressbookapp.exceptions;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AddressBookApplicationExceptionHandler {

    private static final String message = "Exception while processing REST Request";

    @ExceptionHandler(AddressBookApplicationException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookApplicationException(
            AddressBookApplicationException exception) {
        ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ObjectError> errList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message, errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}