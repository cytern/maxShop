package com.liujinchai.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * shop_order
 * @author 
 */
@Data
public class ShopOrder implements Serializable {
    private Integer orderId;

    private Integer userId;

    private String orderStatus;

    private BigDecimal totalPrice;

    private static final long serialVersionUID = 1L;
}