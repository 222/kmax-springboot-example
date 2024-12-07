package com.kmax.example.model;

import com.kmax.example.common.BaseModel;
import com.kmax.example.common.validation.group.INSERT;
import com.kmax.example.common.validation.group.UPDATE;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;


/**
 * 登录日志
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:23
 */
@Data
public class LoginLog extends BaseModel implements Serializable {
    private static final long serialVersionUID = 353474282068119967L;
    /**
     * 日志主键
     */
    @Null(message = "日志主键必须为空", groups = INSERT.class)
    @NotNull(message = "日志主键不能为空", groups = UPDATE.class)
    private Integer id;
    /**
     * 登录用户名
     */
    @NotBlank(message = "登录用户名不能为空")
    @Length(max = 50, message = "登录用户名不能超过50个字符")
    private String loginName;
    /**
     * 登录时间
     */
    @NotNull(message = "登录时间不能为空")
    private Date loginTime;

}


