package com.liujinchai.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * shop_user
 * @author 
 */
@Data
public class ShopUser implements Serializable {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private static final long serialVersionUID = 1L;
}