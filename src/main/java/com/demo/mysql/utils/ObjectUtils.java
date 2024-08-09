package com.demo.mysql.utils;

/**
 * The Class ObjectUtils.
 */
public class ObjectUtils {

	/**
	 * Instantiates a new object utils.
	 */
	public ObjectUtils() {}
	
	/**
	 * Valida object.
	 *
	 * @param object the object
	 * @return true, if successful
	 */
	public static boolean validaObject(Object object) {
		if(object == null) {
			return false;			
		}
		
		return true;
	}
	
	/**
	 * Valida string.
	 *
	 * @param str the str
	 * @return true, if successful
	 */
	public static boolean validaString(String str) {
		if(str == null) {
			return false;
		}
		
		if(str.isBlank() || str.isEmpty()){
			return false;
		}
		
		return validaSimple(str);
	}
	
	/**
	 * Valida simple.
	 *
	 * @param str the str
	 * @return true, if successful
	 */
	public static boolean validaSimple(String str) {
		if(str.equals(Constantes.STR_VACIO) || str.equals(Constantes.STR_NULL_ONE) ||
				str.equals(Constantes.STR_NULL_TWO) || str.equals(Constantes.STR_NULL_THREE)) {
			return false;
		}
		
		return true;
	}
}
