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
 * 成员
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@Data
public class Member extends BaseModel implements Serializable {
    private static final long serialVersionUID = 765802573135139584L;
    /**
     * 成员ID
     */
    @Null(message = "成员ID必须为空", groups = INSERT.class)
    @NotNull(message = "成员ID不能为空", groups = UPDATE.class)
    private Integer memberId;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Length(max = 50, message = "姓名不能超过50个字符")
    private String realName;
    /**
     * 身份证号
     */
    @Length(max = 18, message = "身份证号不能超过18个字符")
    private String idCard;
    /**
     * 部职级
     */
    @Length(max = 20, message = "部职级不能超过20个字符")
    private String position;
    /**
     * 手机号
     */
    @Length(max = 11, message = "手机号不能超过11个字符")
    private String phone;
    /**
     * 固定电话
     */
    @Length(max = 12, message = "固定电话不能超过12个字符")
    private String telephone;
    /**
     * 备注
     */
    @Length(max = 100, message = "备注不能超过100个字符")
    private String remark;

}


