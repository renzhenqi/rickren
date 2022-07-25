package com.rickren.jdk17inaction.user.controller;


import com.rickren.jdk17inaction.user.entity.User;
import com.rickren.jdk17inaction.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

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
}
