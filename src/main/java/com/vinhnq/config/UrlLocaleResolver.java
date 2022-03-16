package com.vinhnq.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

public class UrlLocaleResolver implements LocaleResolver {

    private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // ==> /SomeContextPath/en/...
        // ==> /SomeContextPath/fr/...
        // ==> /SomeContextPath/WEB-INF/pages/...
        String uri = request.getRequestURI();

        String prefixEn = request.getServletContext().getContextPath() + "/en/";
        String prefixFr = request.getServletContext().getContextPath() + "/ja/";
        String prefixVi = request.getServletContext().getContextPath() + "/vi/";

        Locale locale = null;

        // English
        if (uri.startsWith(prefixEn)) {
            locale = Locale.ENGLISH;
        }
        // JAPAN
        else if (uri.startsWith(prefixFr)) {
            locale = Locale.JAPAN;
        }
        // Vietnamese
        else if (uri.startsWith(prefixVi)) {
            locale = new Locale("vi", "VN");
        }
        if (locale != null) {
            request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
        }
        if (locale == null) {
            locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
            if (locale == null) {
                //locale = Locale.ENGLISH;
                request.getLocale();
                locale = request.getLocale();
                if (null == locale) {
                    locale = Locale.ENGLISH;
                } else {
                    //locale = Locale.JAPAN;
                    //Comment for demo
                    String[] localeString = locale.toString().split("_");
                    if(localeString.length > 1) {
                        Locale.setDefault(Locale.forLanguageTag(localeString[0]));
                        locale = Locale.forLanguageTag(localeString[0]);
                    }
                }
                request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
            }
        }
        LocaleContextHolder.setDefaultLocale(locale);
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // Nothing
    }

}