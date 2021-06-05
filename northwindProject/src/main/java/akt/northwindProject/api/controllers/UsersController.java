package akt.northwindProject.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import akt.northwindProject.business.abstracts.UserService;
import akt.northwindProject.core.utilities.entitites.User;
import akt.northwindProject.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception){
		
		//sistemde bir hata olusurda buraya gelir
		Map<String, String> validationErrors=new HashMap<String, String>();
		
		for(FieldError fieldError:exception.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Dogrulama hatalari");
		return errors;
	}

}
