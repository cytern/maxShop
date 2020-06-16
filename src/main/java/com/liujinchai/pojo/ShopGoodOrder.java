package com.liujinchai.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * shop_good_order
 * @author 
 */
@Data
public class ShopGoodOrder implements Serializable {
    private Integer goodOrderId;

    private Integer goodNum;

    private Integer goodId;

    private Integer userId;

    private String goodUrl;

    private String goodName;

    private BigDecimal goodPrice;

    private Integer orderId;

    private static final long serialVersionUID = 1L;
}