package com.kmax.example.param.req;

import com.kmax.example.common.Pageable;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 任务成员分页参数
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@Data
public class TaskMemberQuery extends Pageable implements Serializable {
    private static final long serialVersionUID = 498048833065574195L;
    /**
     * 任务成员主键
     */
    private Integer taskMemberId;
    /**
     * 任务ID
     */
    private Integer taskId;
    /**
     * 成员ID
     */
    private Integer memberId;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 创建人id
     */
    private Integer createdBy;
    /**
     * 更新人id
     */
    private Integer updatedBy;
}

