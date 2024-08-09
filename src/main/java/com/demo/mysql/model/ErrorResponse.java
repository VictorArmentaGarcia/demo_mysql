package com.demo.mysql.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.mysql.enums.EnumHttpStatus;
import com.demo.mysql.utils.Constantes;

import lombok.Data;

/**
 * The Class ErrorResponse.
 */
@Data
public class ErrorResponse {

	/** The code. */
	// HTTP Status code
	private String code;
	
	/** The contact email. */
	// contact email first aids
	private String contactEmail;
	
	/** The description. */
	// HTTP Status description
	private String description;
	
	/** The business message. */
	// Business message for frontend
	private String businessMessage;
	
	/** The reason phrase. */
	// Real message exception
	private String reasonPhrase;
	
	/** The uri. */
	// URI for help (future use)
	private String uri;
	
	/** The time stamp. */
	// time stamp Exception
	private String timeStamp;

	/**
	 * Instantiates a new error response.
	 *
	 * @param statusC the status C
	 * @param businessMessageC the business message C
	 * @param reasonPhraseC the reason phrase C
	 */
	public ErrorResponse(EnumHttpStatus statusC, String businessMessageC, String reasonPhraseC) {
		this.setContactEmail("generico@email.com");
		this.setCode(statusC.getCode().toString()); 
		this.setBusinessMessage(businessMessageC);
		this.setReasonPhrase(reasonPhraseC);
		this.setDescription(statusC.getDescription());
		this.setUri("http://localhost");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		this.setTimeStamp(dateFormat.format(new Date()));

	}
	
	/**
	 * Instantiates a new error response.
	 *
	 * @param statusC the status C
	 * @param businessMessageC the business message C
	 */
	public ErrorResponse(EnumHttpStatus statusC, String businessMessageC) {
		this.setContactEmail("generico@email.com");
		this.setCode(statusC.getCode().toString()); 
		this.setBusinessMessage(businessMessageC);
		this.setReasonPhrase(Constantes.ERROR_GENERICO);
		this.setDescription(statusC.getDescription());
		this.setUri("http://localhost");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		this.setTimeStamp(dateFormat.format(new Date()));
	}
}