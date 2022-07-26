package com.rickren.mpinaction.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rickren.mpinaction.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rickren.mpinaction.user.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rickren
 * @since 2022-07-22
 */
public interface IUserService extends IService<User> {

    IPage<User> getPage(UserVo vo);
}
