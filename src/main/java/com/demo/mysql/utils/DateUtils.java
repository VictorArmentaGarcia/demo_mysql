package com.demo.mysql.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.mysql.enums.EnumHttpStatus;
import com.demo.mysql.exception.BusinessException;

/**
 * The Class DateUtils.
 */
public class DateUtils {

	/**
	 * Instantiates a new date utils.
	 */
	public DateUtils() {}
	
	/**
	 * Parser from string.
	 *
	 * @param fecha the fecha
	 * @param formato the formato
	 * @return the date
	 * @throws Exception the exception
	 */
	public static Date parserFromString(String fecha, String formato) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat(formato);

		Date date = null;
		try {
			date = formatter.parse(fecha);
		} catch (Exception e) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, Constantes.FALLA_STR_DATE);
		}
		return date;
	}
	
	/**
	 * Parser dateto string.
	 *
	 * @param fecha the fecha
	 * @param patron the patron
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String parserDatetoString(Date fecha, String patron) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat(patron);

		String date = "";
		if (fecha != null) {
			try {
				date = formatter.format(fecha);
			} catch (Exception e) {
				throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, Constantes.FALLA_STR_DATE);
			}
		}
		return date;
	}
}
