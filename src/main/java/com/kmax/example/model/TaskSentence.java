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


/**
 * 任务文本
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:25
 */
@Data
public class TaskSentence extends BaseModel implements Serializable {
    private static final long serialVersionUID = 780150240430633973L;
    /**
     * 句子主键
     */
    @Null(message = "句子主键必须为空", groups = INSERT.class)
    @NotNull(message = "句子主键不能为空", groups = UPDATE.class)
    private Integer sentenceId;
    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;
    /**
     * 成员ID
     */
    private Integer memberId;
    /**
     * 句子内容
     */
    @NotBlank(message = "句子内容不能为空")
    @Length(max = 255, message = "句子内容不能超过255个字符")
    private String textContent;
    /**
     * 修改后的句子
     */
    @NotBlank(message = "修改后的句子不能为空")
    @Length(max = 255, message = "修改后的句子不能超过255个字符")
    private String changedContent;
    /**
     * 序号
     */
    @NotNull(message = "序号不能为空")
    private Integer sort;
    /**
     * 是否修改(0是 1否)
     */
    @NotNull(message = "是否修改(0是 1否)不能为空")
    private Integer changed;
    /**
     * 开始时间(毫秒)
     */
    @NotNull(message = "开始时间(毫秒)不能为空")
    private Integer startTime;
    /**
     * 结束时间(毫秒)
     */
    @NotNull(message = "结束时间(毫秒)不能为空")
    private Integer endTime;
    /**
     * 句子音频源文件地址
     */
    @NotBlank(message = "句子音频源文件地址不能为空")
    @Length(max = 150, message = "句子音频源文件地址不能超过150个字符")
    private String audioFile;

}


