package com.example.emp.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class ErrorResponse {
	
		private String message;
	    private int status;
	    private LocalDateTime timestamp;
	    
		public ErrorResponse(String message, int status, LocalDateTime timestamp) {
			this.message=message;
			this.status=status;
			this.timestamp=LocalDateTime.now();
		}

}
