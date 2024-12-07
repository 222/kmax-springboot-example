package com.kmax.example.common;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author youping.tan
 * @date 2024/12/1 16:08
 */
@Data
public class DeleteIds implements Serializable {

    @NotNull(message = "编号不可为空")
    @Size(min = 1, message = "编号不可为空")
    private List<Integer> ids;
}
