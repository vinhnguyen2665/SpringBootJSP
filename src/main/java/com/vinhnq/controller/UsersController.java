package com.vinhnq.controller;

import com.vinhnq.common.URLConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UsersController extends BaseController {

	@RequestMapping(value = URLConst.PROFILE, method = RequestMethod.GET)
	public String reportIndex(Model model) {

		return "gateway-demo";
	}
}
