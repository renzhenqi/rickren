package com.rickren.mpinaction.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rickren.mpinaction.user.entity.User;
import com.rickren.mpinaction.user.service.IUserService;
import com.rickren.mpinaction.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public boolean save(@RequestBody UserVo vo) {
        boolean b = userService.saveOrUpdate(vo);
        return b;
    }

    @PostMapping("/page")
    public IPage<User> getPage(@RequestBody UserVo vo) {
        IPage<User> page = userService.getPage(vo);
        return  page;
    }


}
