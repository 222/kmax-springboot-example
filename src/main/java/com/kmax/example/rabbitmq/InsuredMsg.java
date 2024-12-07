package com.kmax.example.rabbitmq;

import lombok.Data;

/**
 * @author youping.tan
 * @date 2024/12/6 14:19
 */
@Data
public class InsuredMsg {
    private Long orderId;
    private String insuranceId;
    private String insuranceName;
}
