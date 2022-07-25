package com.rickren.mpinaction.user.controller;


import com.rickren.mpinaction.user.entity.User;
import com.rickren.mpinaction.user.service.IUserService;
import com.rickren.mpinaction.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rickren
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/list")
    public List<User> list() {
        List<User> list = userService.list();
        return list;
    }

    @PostMapping("/save")
    public void save(UserVo vo) {
        userService.saveOrUpdate(vo);
    }
}
