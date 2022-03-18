package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.neveray0932.fengchai.common.vo.ApiMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
@ApiModel(value = "Supplier對象", description = ApiMsg.API_DESCRIPTION)
public class Supplier {

    @ApiModelProperty(value = "供應商ID",required = true)
    @TableId(value = "supplier_id", type = IdType.AUTO)
    private Integer supplierId;

    @ApiModelProperty(value = "供應商名稱",required = true)
    private String supplierName;

    @ApiModelProperty(value = "供應商統編D",required = true)
    private String supplierTaxNumber;

    @ApiModelProperty(value = "供應商地址")
    private String supplierAddress;

    @ApiModelProperty(value = "供應商負責人")
    private String supplierCharge;

    @ApiModelProperty(value = "供應商信箱")
    private String supplierMail;

    @ApiModelProperty(value = "供應商電話")
    private String supplierPhone;

    @ApiModelProperty(value = "供應商聯絡人")
    private String supplierContact;

    @ApiModelProperty(value = "創建時間",hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "編輯時間",hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "邏輯刪除",hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;


}
