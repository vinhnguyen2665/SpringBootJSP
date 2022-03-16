package vn.com.nsmv.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.nsmv.common.CommonConst;
import vn.com.nsmv.common.URLConst;


@Controller
public class UsersController extends BaseController {

	@RequestMapping(value = URLConst.PROFILE, method = RequestMethod.GET)
	public String reportIndex(Model model) {

		return "gateway-demo";
	}
}
