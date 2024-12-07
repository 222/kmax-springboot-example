package com.kmax.example.param.req;

import com.kmax.example.common.Pageable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;


/**
 * 成员分页参数
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@Data
public class MemberQuery extends Pageable implements Serializable {
    private static final long serialVersionUID = -28346035868064072L;
    /**
     * 成员ID
     */
    private Integer memberId;
    /**
     * 姓名
     */
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

