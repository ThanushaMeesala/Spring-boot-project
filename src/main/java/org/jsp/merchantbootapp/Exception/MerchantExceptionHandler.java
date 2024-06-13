package org.jsp.merchantbootapp.Exception;

import org.jsp.merchantbootapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MerchantExceptionHandler extends ResponseEntityExceptionHandler{
@ExceptionHandler(MerchantNotFountException.class)
public ResponseEntity<ResponseStructure<String>> handle(MerchantNotFountException exception){
	ResponseStructure<String> structure=new ResponseStructure<>();
	structure.setData("merchant not found");
	structure.setMessage(exception.getMessage());
	structure.setStatuscode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
}
}
