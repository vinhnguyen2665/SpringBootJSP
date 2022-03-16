package vn.com.nsmv.service;

import vn.com.nsmv.beans.LoginResponse;
import vn.com.nsmv.beans.UserBeans;
import vn.com.nsmv.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User userAuthenticated(String username, String password);

    /**
     *
     * @param username
     * @return
     */
    User getUserInfoByName(String username);

    List<User> getAllUser();

    /**
     *
     * @param username
     * @return
     */
    boolean isUserNameExist(String username);

    /**
     *
     * @param user
     * @return
     */
    User forgotPassword(User user);

    /**
     *
     * @param user
     * @return
     */
    User register(User user);

    /**
     *
     * @param username
     * @return
     */
    LoginResponse authenticateUserActive(String username);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    LoginResponse authenticateUserHandler(String username, String password);

    Map<Long, UserBeans> getUsersBeansMap();
}
