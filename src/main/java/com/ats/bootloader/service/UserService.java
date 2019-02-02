package com.ats.bootloader.service;

import com.ats.bootloader.dao.UserMapper;
import com.ats.bootloader.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userDao;//这里可能会报错，但是并不会影响

    // 按照userId查找
    public User getUserById(Integer userId) {
        return userDao.selectByPrimaryKey(userId);
    }
    // 查找所有
    public List findAllUser(){
        return userDao.findAllUser();
    }
    // 插入数据
    public int insertUser(User user) {
        return userDao.insert(user);
    }

    // 插入数据2
    public int insertUserSelective(User user) {
        return userDao.insertSelective(user);
    }


}