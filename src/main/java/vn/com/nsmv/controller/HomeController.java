package vn.com.nsmv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.com.nsmv.common.CommonConst;
import vn.com.nsmv.common.URLConst;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


@Controller
public class HomeController{
	
	@RequestMapping(value = {URLConst.ROOT, URLConst.ROOT_LANG}, method = RequestMethod.GET)
	public String root(HttpServletRequest request, Model model) {
		Locale locale = request.getLocale();
		if (null == locale) {
			locale = Locale.JAPAN;
			Locale.setDefault(Locale.JAPAN);
		} else {
			String[] localeString = locale.toString().split("_");
			if(localeString.length > 1) {
				Locale.setDefault(Locale.forLanguageTag(localeString[0]));
				locale = Locale.forLanguageTag(localeString[0]);
			}
		}
		//Comment for demo
		return "redirect:" + "/" + locale.toString() + URLConst.DASHBOARD.HOME;
		//return "redirect:" + "/ja" + URLConst.DASHBOARD.HOME;
	}

	@RequestMapping(value = URLConst.LOGIN.HOME, method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, Model model) {
		return new ModelAndView("login");
	}
}
