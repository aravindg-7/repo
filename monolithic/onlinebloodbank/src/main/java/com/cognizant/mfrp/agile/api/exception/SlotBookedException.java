package com.cognizant.mfrp.agile.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Slot already booked ")
public class SlotBookedException extends Exception {

	private static final long serialVersionUID = 1L;

	public SlotBookedException() {
		super("Slot already booked");
	}
	
}	