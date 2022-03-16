package com.vinhnq.controller.api;

import com.google.gson.Gson;
import com.vinhnq.beans.ExceptionResponse;
import com.vinhnq.beans.ResponseAPI;
import com.vinhnq.beans.UserBeans;
import com.vinhnq.common.CommonConst;
import com.vinhnq.controller.BaseController;
import com.vinhnq.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginControllerAPI extends BaseController {

	private static final Logger logger = LogManager.getLogger(LoginControllerAPI.class);


	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;

	@PostMapping(value = "/api/login" , consumes = "application/json;charset=UTF-8")
	public @ResponseBody
	ResponseAPI<Object> authenticateUserBody(@RequestBody UserBeans user) {
		ResponseAPI<Object> result = new ResponseAPI<Object>();
		System.out.println(new Gson().toJson(user));
		try {
			result.setStatus(CommonConst.COMMON_RESPONSE.OK);
			result.setMessage(messageSource.getMessage(CommonConst.COMMON_MESSAGE.LOGIN_SUCCESS, null, null));
			result.setData(userService.authenticateUserHandler(user.getUsername(), user.getPassword()));
		} catch (BadCredentialsException e) {
			result.setStatus(CommonConst.COMMON_RESPONSE.EXCEPTION);
			result.setMessage(messageSource.getMessage(CommonConst.COMMON_MESSAGE.PASSWORD_INCORRECT, null, null));
			result.setData(
					new ExceptionResponse(messageSource.getMessage(CommonConst.COMMON_MESSAGE.PASSWORD_INCORRECT, null, null)));
		} catch (NullPointerException ex) {
			result.setStatus(CommonConst.COMMON_RESPONSE.EXCEPTION);
			result.setMessage(messageSource.getMessage(CommonConst.COMMON_MESSAGE.DATA_NOT_VALID, null, null));
			result.setData(new ExceptionResponse(messageSource.getMessage(CommonConst.COMMON_MESSAGE.DATA_NOT_VALID, null, null)));
			logger.error(ex.getMessage(), ex);
		} catch (Exception ex) {
			result.setStatus(CommonConst.COMMON_RESPONSE.EXCEPTION);
			result.setMessage(ex.getMessage());
			result.setData(new ExceptionResponse(ex.getMessage()));
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	@RequestMapping(value = { "/api/refresh-tokens`"}, method = RequestMethod.POST)
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	public @ResponseBody ResponseAPI<Object> refreshTokens() {
		ResponseAPI<Object> result = new ResponseAPI<Object>();
		try {
			Authentication authen = SecurityContextHolder.getContext().getAuthentication();
			if (null != authen && !authen.getPrincipal().equals("anonymousUser")) {
				org.springframework.security.core.userdetails.User authenUser = (org.springframework.security.core.userdetails.User) authen
						.getPrincipal();
				result.setStatus(CommonConst.COMMON_RESPONSE.OK);
				result.setData(userService.getUserInfoByName(authenUser.getUsername()));
			} else {
				result.setStatus(CommonConst.COMMON_RESPONSE.NON_AUTH);
				result.setData(messageSource.getMessage(CommonConst.COMMON_MESSAGE.USER_NOT_LOGIN, null, null));
			}
		} catch (Exception e) {
			result.setStatus(CommonConst.COMMON_RESPONSE.EXCEPTION);
			result.setData(new ExceptionResponse(e.getMessage()));
			logger.error(e.getMessage(), e);
		}
		return result;
	}

}
