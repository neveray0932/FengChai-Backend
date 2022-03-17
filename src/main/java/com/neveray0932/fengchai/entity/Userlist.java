package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Getter
@Setter
@Data
@ApiModel(value = "Userlist對象", description = "")
public class Userlist {

    @ApiModelProperty(value = "用戶帳號",required = true)
    @TableId(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "用戶密碼",required = true)
    private String userPassword;

    @ApiModelProperty(value = "員工ID")
    private String userEmpid;


}
