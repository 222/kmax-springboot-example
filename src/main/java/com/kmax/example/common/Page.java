package com.kmax.example.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author youping.tan
 * @date 2024/12/1 16:02
 */
@Data
public class Page<T> implements Serializable {
    private List<T> list;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Long total = 0L;

    public Page() {
    }

    public Page(List list) {
        if (list instanceof com.github.pagehelper.Page<?>) {
            this.pageNum = ((com.github.pagehelper.Page<?>) list).getPageNum();
            this.pageSize = ((com.github.pagehelper.Page<?>) list).getPageSize();
            this.total = ((com.github.pagehelper.Page<?>) list).getTotal();
            this.list = list;
        }
    }
}
