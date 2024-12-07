package com.kmax.example.common;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 统一分页入参
 *
 * @author tanyp
 * @since 2023/2/21
 */
public abstract class Pageable {
    /**
     * 开始记录数
     */
    @NotNull(message = "当前页数不能为空")
    @Min(value = 1,message = "页数不能小于1")
    private Integer pageNum = 1;
    /**
     * 每页条数
     */
    @NotNull(message = "每页显示条数不能为空")
    @Range(min = 1, max = 100, message = "条数范围在1-100之间")
    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
