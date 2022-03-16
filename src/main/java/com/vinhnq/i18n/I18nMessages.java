package com.vinhnq.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
public class I18nMessages {

	private static final ExposedResourceBundleMessageSource messageSource = new ExposedResourceBundleMessageSource();

	public static String getMessage(String messageId, Locale locale){
		Object[] args = {};
		return I18nMessages.messageSource.getMessage(messageId, args, locale);
	}
	
	public static String getMessage(String messageId){
		Object[] args = {};
		return I18nMessages.messageSource.getMessage(messageId, args, LocaleContextHolder.getLocale());
	}

	public static String getMessage(String key, String ...params) {
		return I18nMessages.messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
	}


	public static String getMessage(String key, Object[] params) {
		return I18nMessages.messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
	}
	public static List<String> getMapMessageForJS(List<String> messageId){
		List<String> lst = new ArrayList<String>();
		Object[] args = {};
		for (String id : messageId) {
			lst.add("['"+ id +"'" + ", '" + I18nMessages.messageSource.getMessage(id, args, LocaleContextHolder.getLocale()) +"']");
		}
		return lst;
	}

}