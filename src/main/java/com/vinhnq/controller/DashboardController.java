package com.vinhnq.controller;

import com.vinhnq.common.CommonConst;
import com.vinhnq.common.URLConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DashboardController extends BaseController {

	@RequestMapping(value = URLConst.DASHBOARD.CONTROLLER.HOME, method = RequestMethod.GET)
	public String dashboard(Model model) {

		model.addAttribute(CommonConst.PAGE_CODE.attributeName, CommonConst.PAGE_CODE.dashboard);
		return "dashboard";
	}

}
