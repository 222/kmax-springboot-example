package com.kmax.example.param.req;

import com.kmax.example.common.Pageable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;


/**
 * 登录日志分页参数
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:23
 */
@Data
public class LoginLogQuery extends Pageable implements Serializable {
    private static final long serialVersionUID = -29352026585116983L;
    /**
     * 日志主键
     */
    private Integer id;
    /**
     * 登录用户名
     */
    @Length(max = 50, message = "登录用户名不能超过50个字符")
    private String loginName;
    /**
     * 登录时间
     */
    private Date loginTime;
}

