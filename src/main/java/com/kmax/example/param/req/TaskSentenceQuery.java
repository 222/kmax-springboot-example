package com.kmax.example.param.req;

import com.kmax.example.common.Pageable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;


/**
 * 任务文本分页参数
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:25
 */
@Data
public class TaskSentenceQuery extends Pageable implements Serializable {
    private static final long serialVersionUID = -64106722076287116L;
    /**
     * 句子主键
     */
    private Integer sentenceId;
    /**
     * 任务ID
     */
    private Integer taskId;
    /**
     * 成员ID
     */
    private Integer memberId;
    /**
     * 句子内容
     */
    @Length(max = 255, message = "句子内容不能超过255个字符")
    private String textContent;
    /**
     * 修改后的句子
     */
    @Length(max = 255, message = "修改后的句子不能超过255个字符")
    private String changedContent;
    /**
     * 序号
     */
    private Integer sort;
    /**
     * 是否修改(0是 1否)
     */
    private Integer changed;
    /**
     * 开始时间(毫秒)
     */
    private Integer startTime;
    /**
     * 结束时间(毫秒)
     */
    private Integer endTime;
    /**
     * 句子音频源文件地址
     */
    @Length(max = 150, message = "句子音频源文件地址不能超过150个字符")
    private String audioFile;
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

