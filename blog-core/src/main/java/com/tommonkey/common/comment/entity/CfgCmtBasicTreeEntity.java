/**
 * $Id: CfgCmtBasicTreeEntity.java,v 1.0 2016/9/13 20:26 Administrator Exp $
 * <p/>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.common.comment.entity;

import com.tommonkey.common.persistence.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RaoXb
 * @version $Id: CfgCmtBasicTreeEntity.java,v 1.1 2016/9/13 20:26 RaoXb Exp $
 * Created on 2016/9/13 20:26
 */
public class CfgCmtBasicTreeEntity extends BaseEntity {

    private String cmtTargetId;//业务评论对象

    private Integer moduleId;//数据来源

    private Long itemId;//评论类型编号

    private String itemName;//评论类型名称

    private Integer showOrder;//展示顺序

    private Integer itemValueLenth;//评论值的长度

    private Integer nullAble;//评论是否可空

    private String defaultVal;//默认值

    private Integer cmtAble;//是否可评论

    private Integer groupId;//1、同组每一项都必填；	2、同组间必填且只能填一项；	3、其他

    private Long ext1;//undefined

    private String ext2;//undefined

    private String ext3;//undefined

    //评论的评论配置信息
    private List<CfgCmtBasicEntity> children = new ArrayList<>();

    public List<CfgCmtBasicEntity> getChildren() {
        return children;
    }

    public void setChildren(List<CfgCmtBasicEntity> children) {
        this.children = children;
    }

    public String getCmtTargetId() {
        return cmtTargetId;
    }

    public void setCmtTargetId(String cmtTargetId) {
        this.cmtTargetId = cmtTargetId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public Integer getItemValueLenth() {
        return itemValueLenth;
    }

    public void setItemValueLenth(Integer itemValueLenth) {
        this.itemValueLenth = itemValueLenth;
    }

    public Integer getNullAble() {
        return nullAble;
    }

    public void setNullAble(Integer nullAble) {
        this.nullAble = nullAble;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public Integer getCmtAble() {
        return cmtAble;
    }

    public void setCmtAble(Integer cmtAble) {
        this.cmtAble = cmtAble;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Long getExt1() {
        return ext1;
    }

    public void setExt1(Long ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }
}