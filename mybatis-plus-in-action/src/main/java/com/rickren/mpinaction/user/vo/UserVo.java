package com.rickren.mpinaction.user.vo;

import com.rickren.mpinaction.user.entity.User;
import lombok.Data;

@Data
public class UserVo extends User {

    private int pageNum;

    private int pageSize;
}