package farheen.foundation.bank.commons;

import java.time.LocalDateTime;

public class CustomErrorResponse {

	String errorCode;
	String errorMessage;
	LocalDateTime timeStamp;
	String status;
	
	public CustomErrorResponse(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage= errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
