package com.kmax.example.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 统一实体类基类(Long型主键)
 *
 * @author tanyp
 * @since 2023/2/21
 */
@Getter
@Setter
public abstract class BaseModel {
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 状态
     * 0-启用
     * 1-禁用
     */
    private Integer status;
    /**
     * 删除
     */
    private Boolean deleted;
    /**
     * 创建者
     */
    private Integer createdBy;
    /**
     * 更新者
     */
    private Integer updatedBy;
}
