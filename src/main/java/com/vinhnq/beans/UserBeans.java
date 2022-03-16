package com.vinhnq.beans;

import com.vinhnq.common.CommonConst;

import java.sql.Date;
import java.sql.Timestamp;

public class UserBeans {
    private String displayName;
    private String password;
    private String username;
    private Long id;
    private String authority;
    private String firstName;
    private String midName;
    private String lastName;
    private String fullName;
    private String sex;
    private Date dateOfBirth;
    private String department;
    private String email;
    private String deleteFlg;
    private Timestamp createDate;
    private Long createById;
    private Timestamp updateDate;
    private Long updateById;

    public UserBeans() {
    }

    public UserBeans(String displayName, String password, String username, Long id, String authority, String firstName, String midName, String lastName, String sex, Date dateOfBirth, String department, String email, String deleteFlg, Timestamp createDate, Long createById, Timestamp updateDate, Long updateById) {
        this.displayName = displayName;
        this.password = password;
        this.username = username;
        this.id = id;
        this.authority = authority;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.email = email;
        this.deleteFlg = deleteFlg;
        this.createDate = createDate;
        this.createById = createById;
        this.updateDate = updateDate;
        this.updateById = updateById;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if(null == this.fullName){
            this.fullName = firstName + CommonConst.COMMON_STRING.SPACE
                    + midName + CommonConst.COMMON_STRING.SPACE
                    + lastName + CommonConst.COMMON_STRING.SPACE ;
        }
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Long getCreateById() {
        return createById;
    }

    public void setCreateById(Long createById) {
        this.createById = createById;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateById() {
        return updateById;
    }

    public void setUpdateById(Long updateById) {
        this.updateById = updateById;
    }
}
