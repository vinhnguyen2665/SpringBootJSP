package com.vinhnq.repository;

import com.vinhnq.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email = :email AND u.deleteFlg = '0'")
    User findUserByEmailAndDeleteFlg(@Param("email") String email);

    User findUserById(Long id);
    /**
     * @param username
     * @return
     */
    User findByUserName(String username);

    List<User> findAllByDeleteFlg(String deleteFlg);

    /**
     * @param user
     * @return
     */
    User save(User user);

}
