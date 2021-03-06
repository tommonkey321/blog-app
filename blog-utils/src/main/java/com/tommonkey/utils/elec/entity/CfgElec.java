/**
 * $Id: CfgElec.java,v 1.0 16/9/12 上午10:46 zhangruiping Exp $
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package com.tommonkey.utils.elec.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangruiping
 * @version $Id: CfgElec.java,v 1.1 16/9/12 上午10:46 zhangruiping Exp $
 *          Created on 16/9/12 上午10:46
 */
public class CfgElec implements Serializable {

    private Long fileTypeId;//null

    private String fileTypeName;//null

    private Long parentFileTypeId;//null

    private String fileSuffixes;//null

    private Long fileMaxSize;//null

    private String showStyle;//null

    private String imgUrl;//null

    private String transferAddress;//传输地址

    private String transferParam;//null

    private String transferHandle;//null

    private Integer hasExpireDate;//null

    private Integer state;//null

    private Date createDate;//null

    private Long creator;//null

    private String remark;//null

    private Boolean hasChildren;

    public Long getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public String getFileTypeName() {
        return fileTypeName;
    }

    public void setFileTypeName(String fileTypeName) {
        this.fileTypeName = fileTypeName;
    }

    public Long getParentFileTypeId() {
        return parentFileTypeId;
    }

    public void setParentFileTypeId(Long parentFileTypeId) {
        this.parentFileTypeId = parentFileTypeId;
    }

    public String getFileSuffixes() {
        return fileSuffixes;
    }

    public void setFileSuffixes(String fileSuffixes) {
        this.fileSuffixes = fileSuffixes;
    }

    public Long getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(Long fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }

    public String getShowStyle() {
        return showStyle;
    }

    public void setShowStyle(String showStyle) {
        this.showStyle = showStyle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTransferAddress() {
        return transferAddress;
    }

    public void setTransferAddress(String transferAddress) {
        this.transferAddress = transferAddress;
    }

    public String getTransferParam() {
        return transferParam;
    }

    public void setTransferParam(String transferParam) {
        this.transferParam = transferParam;
    }

    public String getTransferHandle() {
        return transferHandle;
    }

    public void setTransferHandle(String transferHandle) {
        this.transferHandle = transferHandle;
    }

    public Integer getHasExpireDate() {
        return hasExpireDate;
    }

    public void setHasExpireDate(Integer hasExpireDate) {
        this.hasExpireDate = hasExpireDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}