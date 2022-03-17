package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDate;
import java.util.Date;

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
@ApiModel(value = "Customer對象", description = "")
public class Customer {

    @ApiModelProperty(value = "客戶ID",required = true)
    @TableId(value = "cust_id", type = IdType.AUTO)
    private Integer custId;

    @ApiModelProperty(value = "客戶姓名")
    private String custName;

    @ApiModelProperty(value = "客戶統編",required = true)
    private String custTaxNumber;

    @ApiModelProperty(value = "客戶地址")
    private String custAddress;

    @ApiModelProperty(value = "客戶負責人")
    private String custCharge;

    @ApiModelProperty(value = "客戶信箱")
    private String custMail;

    @ApiModelProperty(value = "客戶電話")
    private String custPhone;

    @ApiModelProperty(value = "客戶聯絡人")
    private String custContact;

    @ApiModelProperty(value = "創建時間",hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改時間",hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "邏輯刪除",hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;


}
