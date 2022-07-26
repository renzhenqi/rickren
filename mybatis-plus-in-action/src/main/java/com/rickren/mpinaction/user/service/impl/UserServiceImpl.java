package com.rickren.mpinaction.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rickren.mpinaction.user.entity.User;
import com.rickren.mpinaction.user.mapper.UserMapper;
import com.rickren.mpinaction.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rickren.mpinaction.user.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rickren
 * @since 2022-07-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage<User> getPage(UserVo vo) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(User::getAge, 18);
        IPage<User> iPage = new Page<>(vo.getCurrent(), vo.getPageSize());
        IPage<User> pageResult = page(iPage, queryWrapper);
        //todo 封装分页待实现
        List<User> records = pageResult.getRecords();

        return new Page<>();
    }
}
