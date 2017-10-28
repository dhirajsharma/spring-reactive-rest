package com.naturalprogrammer.srr.commons.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Useful static methods
 * 
 * @author Sanjay Patel
 *
 */
@Component
public class SrUtils {
	
	private static final Log log = LogFactory.getLog(SrUtils.class);

	private static ApplicationContext applicationContext;
	private static MessageSource messageSource;
	private static ObjectMapper objectMapper;
	
	public SrUtils(ApplicationContext applicationContext,
		MessageSource messageSource,
		ObjectMapper objectMapper) {
		
		SrUtils.applicationContext = applicationContext;
		SrUtils.messageSource = messageSource;
		SrUtils.objectMapper = objectMapper;
		log.info("Created");
	}


	public static ObjectMapper getMapper() {
		
		return objectMapper;
	}
	
	/**
	 * Gets the reference to an application-context bean
	 *  
	 * @param clazz	the type of the bean
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	
	/**
	 * Gets a message from messages.properties
	 * 
	 * @param messageKey	the key of the message
	 * @param args			any arguments
	 */
	public static String getMessage(String messageKey, Object... args) {
		
		// http://stackoverflow.com/questions/10792551/how-to-obtain-a-current-user-locale-from-spring-without-passing-it-as-a-paramete
		return messageSource.getMessage(messageKey, args,
				LocaleContextHolder.getLocale());
	}
	

	/**
	 * Constructs a map of the key-value pairs,
	 * passed as parameters
	 * 
	 * @param keyValPair
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> Map<K,V> mapOf(Object... keyValPair) {
		
	    if(keyValPair.length % 2 != 0)
	        throw new IllegalArgumentException("Keys and values must be in pairs");
	
	    Map<K,V> map = new HashMap<K,V>(keyValPair.length / 2);
	
	    for(int i = 0; i < keyValPair.length; i += 2){
	        map.put((K) keyValPair[i], (V) keyValPair[i+1]);
	    }
	
	    return map;
	}
}
