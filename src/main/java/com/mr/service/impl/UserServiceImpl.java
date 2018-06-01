package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ${Gjc} on 2018/6/1.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "user", key="1")
    public List<User> userList() {
        return userMapper.selectByExample(null);
    }

    /**
     *
     * 新增
     *
     * @param user
     */
    @Override
    @Transactional
    @CacheEvict(value = "user",allEntries = true)
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional
    @CacheEvict(value = "user",allEntries = true)
    public void delUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param id
     * @return
     */
    @Override
    public User uId(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    @CacheEvict(value = "user",allEntries = true)
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

}
