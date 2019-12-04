package com.cognizant.mfrp.agile.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You have an active slot")
public class AlreadyslotException extends Exception {

	private static final long serialVersionUID = 1L;

	public AlreadyslotException() {
		super("You have an active slot");
	}
	
}	