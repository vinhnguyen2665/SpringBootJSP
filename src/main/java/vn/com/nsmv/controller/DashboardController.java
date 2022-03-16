package vn.com.nsmv.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.nsmv.common.CommonConst;
import vn.com.nsmv.common.URLConst;


@Controller
public class DashboardController extends BaseController {

	@RequestMapping(value = URLConst.DASHBOARD.CONTROLLER.HOME, method = RequestMethod.GET)
	public String dashboard(Model model) {

		model.addAttribute(CommonConst.PAGE_CODE.attributeName, CommonConst.PAGE_CODE.dashboard);
		return "dashboard";
	}

}
