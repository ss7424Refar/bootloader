package com.ats.bootloader.dao;

import com.ats.bootloader.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    List findAllUser();
}