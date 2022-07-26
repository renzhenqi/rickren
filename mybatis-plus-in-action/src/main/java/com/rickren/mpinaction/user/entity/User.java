package com.rickren.mpinaction.user.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author rickren
 * @since 2022-07-22
 */
@ApiModel(value = "User对象", description = "")
@Data
public class User implements Serializable, IPage<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @TableLogic
    private Integer deleted = 0;

    @Version
    private Integer version = 0;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("邮箱")
    private String email;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
            ", email=" + email +
        "}";
    }

    @Override
    public List<OrderItem> orders() {
        return null;
    }

    @Override
    public List<User> getRecords() {
        return null;
    }

    @Override
    public IPage<User> setRecords(List<User> records) {
        return null;
    }

    @Override
    public long getTotal() {
        return 0;
    }

    @Override
    public IPage<User> setTotal(long total) {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public IPage<User> setSize(long size) {
        return null;
    }

    @Override
    public long getCurrent() {
        return 0;
    }

    @Override
    public IPage<User> setCurrent(long current) {
        return null;
    }
}
