package com.kmax.example.model;

import com.kmax.example.common.BaseModel;
import com.kmax.example.common.validation.group.INSERT;
import com.kmax.example.common.validation.group.UPDATE;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;


/**
 * 任务成员
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@Data
public class TaskMember extends BaseModel implements Serializable {
    private static final long serialVersionUID = 499694986421352657L;
    /**
     * 任务成员主键
     */
    @Null(message = "任务成员主键必须为空", groups = INSERT.class)
    @NotNull(message = "任务成员主键不能为空", groups = UPDATE.class)
    private Integer taskMemberId;
    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;
    /**
     * 成员ID
     */
    @NotNull(message = "成员ID不能为空")
    private Integer memberId;

}


