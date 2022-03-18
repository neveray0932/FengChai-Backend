package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

import com.neveray0932.fengchai.common.vo.ApiMsg;
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
@ApiModel(value = "Company對象", description = ApiMsg.API_DESCRIPTION)
public class Company {

    @ApiModelProperty(value = "公司ID",required = true)
    @TableId(value = "comp_id", type = IdType.AUTO)
    private Integer compId;

    @ApiModelProperty(value = "公司名稱",required = true)
    private String compName;

    @ApiModelProperty(value = "公司統編",required = true)
    private String compTaxNumber;

    @ApiModelProperty(value = "公司地址")
    private String compAddress;

    @ApiModelProperty(value = "公司負責人")
    private String compCharge;

    @ApiModelProperty(value = "公司信箱")
    private String compMail;

    @ApiModelProperty(value = "公司電話")
    private String compPhone;

    @ApiModelProperty(value = "公司聯絡人")
    private String compContact;

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
