package com.rickren.jdk17inaction.user.service.impl;

import com.rickren.jdk17inaction.user.entity.User;
import com.rickren.jdk17inaction.user.mapper.UserMapper;
import com.rickren.jdk17inaction.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rickren
 * @since 2022-07-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
