package com.mr.service;

import com.mr.model.User;

import java.util.List;

/**
 * Created by ${Gjc} on 2018/6/1.
 */
public interface UserService {
    List<User> userList();

    void addUser(User user);

    void delUser(Integer id);

    User uId(Integer id);

    void update(User user);
}
