package com.liujinchai.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * shop_good
 * @author 
 */
@Data
public class ShopGood implements Serializable {
    private Integer goodId;

    private String goodName;

    private String goodUrl;

    private BigDecimal goodPrice;

    private static final long serialVersionUID = 1L;
}