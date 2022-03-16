package com.vinhnq.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vinhnq.beans.LoginResponse;
import com.vinhnq.beans.MailContentBeans;
import com.vinhnq.beans.UserBeans;
import com.vinhnq.common.CommonCode;
import com.vinhnq.common.CommonConst;
import com.vinhnq.common.EntityUtils;
import com.vinhnq.config.security.JwtTokenProvider;
import com.vinhnq.config.security.SecurityConfig;
import com.vinhnq.entity.User;
import com.vinhnq.repository.UserRepository;
import com.vinhnq.service.MailService;
import com.vinhnq.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
//@Repository
//@Transactional(rollbackOn = Exception.class)
//@EnableTransactionManagement(proxyTargetClass = true)
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final SecurityConfig securityConfig;

    private final MailService mailService;

    final
    AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;

    public UserServiceImpl(UserRepository userRepository, SecurityConfig securityConfig, MailService mailService, AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
        this.mailService = mailService;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public User getUserInfoByName(String username) {
        try {
            User result = userRepository.findByUserName(username);
            if (result == null || (null != result && null == result.getUserName())) {
                //throw new RuntimeException("username not exist!");
                return null;
            } else {
                return result;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<User> getAllUser() {
        try {
            List<User> result = userRepository.findAllByDeleteFlg(CommonConst.COMMON_STRING.NUMBER_0);
            if (result == null) {
                //throw new RuntimeException("username not exist!");
                return null;
            } else {
                return result;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }


    @Override
    public User register(User user) {
        try {
            if (!isUserNameExist(user.getUserName())) {
                User u = new User();
                u.setUserName(user.getUserName());
                u.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
                u.setEmail(user.getEmail());
                u.setDeleteFlg(CommonConst.DELETE_FLG.NON_DELETE);
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                userRepository.save(u);
                return u;
            } else {
                throw new RuntimeException(CommonConst.COMMON_MESSAGE.USER_EXIST);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User userAuthenticated(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isUserNameExist(String username) {
        try {
            User result = userRepository.findByUserName(username);
            if (result == null || (null != result && null == result.getUserName())) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User forgotPassword(User user) {
        try {
            User data = getUserInfoByName(user.getUserName());
            if (data != null) {
                if (null != user.getEmail() && null != user.getUserName() && data.getEmail() != null && data.getEmail().equalsIgnoreCase(user.getEmail())) {
                    String generatedString = CommonCode.generatePassword();//RandomStringUtils.randomAlphanumeric(10).toUpperCase();
                    data.setPassword(securityConfig.passwordEncoder().encode(generatedString));
                    userRepository.save(data);
                    mailService.alertForgotPassword(data, new MailContentBeans());
                    data.setPassword(null);
                } else {
                    throw new RuntimeException(CommonConst.COMMON_MESSAGE.DATA_NOT_VALID);
                }
            } else {
                throw new RuntimeException(CommonConst.COMMON_MESSAGE.USER_EXIST);
            }
            return data;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }


    @Override
    public LoginResponse authenticateUserHandler(String username, String password) {
        LoginResponse result = new LoginResponse(null, null);
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            // Nếu không xảy ra exception tức là thông tin hợp lệ
            // Set thông tin authentication vào Security Context
            SecurityContextHolder.getContext().setAuthentication(authentication);
            org.springframework.security.core.userdetails.User authenUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            User user = this.getUserInfoByName(authenUser.getUsername());
            // Trả về jwt cho người dùng.
            String jwt = tokenProvider.generateToken(user);
            logger.info("Login on: " + new Date() + " username: " + username);
            result = new LoginResponse(username, jwt);
        } catch (BadCredentialsException e) {
            logger.error(e.getMessage(), e);
            throw new BadCredentialsException(e.getMessage(), e);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new BadCredentialsException(ex.getMessage(), ex);
        }
        return result;
    }

    @Override
    public Map<Long, UserBeans> getUsersBeansMap() {
        Map<Long, UserBeans> result = new HashMap<>();
        try {
            List<User> lstUsers = this.getAllUser();
            if (null != lstUsers) {
                for (User user : lstUsers ) {
                    UserBeans userBeans = EntityUtils.convertUserToUserBeans(user);
                    userBeans.setPassword(null);
                    result.put(userBeans.getId(), userBeans);
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public LoginResponse authenticateUserActive(String username) {
        LoginResponse result = new LoginResponse(null, null);
        try {
            User user = this.getUserInfoByName(username);
            // Trả về jwt cho người dùng.
            String jwt = tokenProvider.generateToken(user);
            logger.info("Login on: " + new Date() + " username: " + username);
            result = new LoginResponse(username, jwt);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}
