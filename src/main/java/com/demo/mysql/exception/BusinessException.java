package com.demo.mysql.exception;


import com.demo.mysql.enums.EnumHttpStatus;
import com.demo.mysql.model.ErrorResponse;

import lombok.Data;

/**
 * The Class BusinessException.
 */
@Data
public class BusinessException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -872483897865904849L;

	/** The error response. */
	private ErrorResponse errorResponse;
	
	/**
	 * Instantiates a new business exception.
	 *
	 * @param e the e
	 */
	public BusinessException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param status the status
	 * @param businessMessage the business message
	 * @param reasonPhrase the reason phrase
	 */
	public BusinessException(EnumHttpStatus status, String businessMessage, String reasonPhrase) {
		super(reasonPhrase);
		errorResponse = new ErrorResponse(status, businessMessage, reasonPhrase);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param status the status
	 * @param businessMessage the business message
	 */
	public BusinessException(EnumHttpStatus status, String businessMessage) {
		super(businessMessage);
		errorResponse = new ErrorResponse(status, businessMessage);
	}
	
	/**
	 * Instantiates a new business exception.
	 *
	 * @param errorResponse the error response
	 */
	public BusinessException(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	/**
	 * Gets the error response.
	 *
	 * @return the error response
	 */
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	/**
	 * Sets the error response.
	 *
	 * @param errorResponse the new error response
	 */
	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
}
