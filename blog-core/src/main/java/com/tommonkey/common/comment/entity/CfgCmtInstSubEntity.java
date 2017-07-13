package com.tommonkey.common.comment.entity;

import com.tommonkey.common.persistence.entity.BaseEntity;
import com.tommonkey.common.persistence.annotation.Id;

import java.util.Date;

public class CfgCmtInstSubEntity extends BaseEntity {
	private String subCmtTargetId;//null

	private String ext2;//null

	private String ext1;//null

	private Integer cmtState;//评论状态

	private Long relatSubCmiInstId;//父评论编号

	private String cmtName;//被评论人名

	private Long cmtor;//被评论人

	private Date createDate;//创建时间

	private String creatorName;//创建人名

	private Long creator;//创建人

	private Integer moduleId;//评论来源 1 PC 2 APP

	private String itemValue;//评论值

	private Integer groupId;//评论组号

	private Long itemId;//评论类型编号

	private Long cmtInstId;//关联评论编号

	@Id
	private Long subCmtInstId;//子评论编号

	public String getSubCmtTargetId() {return subCmtTargetId;}

	public void setSubCmtTargetId(String subCmtTargetId) {this.subCmtTargetId = subCmtTargetId;}

	public String getExt2() {return ext2;}

	public void setExt2(String ext2) {this.ext2 = ext2;}

	public String getExt1() {return ext1;}

	public void setExt1(String ext1) {this.ext1 = ext1;}

	public Integer getCmtState() {return cmtState;}

	public void setCmtState(Integer cmtState) {this.cmtState = cmtState;}

	public Long getRelatSubCmiInstId() {return relatSubCmiInstId;}

	public void setRelatSubCmiInstId(Long relatSubCmiInstId) {this.relatSubCmiInstId = relatSubCmiInstId;}

	public String getCmtName() {return cmtName;}

	public void setCmtName(String cmtName) {this.cmtName = cmtName;}

	public Long getCmtor() {return cmtor;}

	public void setCmtor(Long cmtor) {this.cmtor = cmtor;}

	public Date getCreateDate() {return createDate;}

	public void setCreateDate(Date createDate) {this.createDate = createDate;}

	public String getCreatorName() {return creatorName;}

	public void setCreatorName(String creatorName) {this.creatorName = creatorName;}

	public Long getCreator() {return creator;}

	public void setCreator(Long creator) {this.creator = creator;}

	public Integer getModuleId() {return moduleId;}

	public void setModuleId(Integer moduleId) {this.moduleId = moduleId;}

	public String getItemValue() {return itemValue;}

	public void setItemValue(String itemValue) {this.itemValue = itemValue;}

	public Integer getGroupId() {return groupId;}

	public void setGroupId(Integer groupId) {this.groupId = groupId;}

	public Long getItemId() {return itemId;}

	public void setItemId(Long itemId) {this.itemId = itemId;}

	public Long getCmtInstId() {return cmtInstId;}

	public void setCmtInstId(Long cmtInstId) {this.cmtInstId = cmtInstId;}

	public Long getSubCmtInstId() {return subCmtInstId;}

	public void setSubCmtInstId(Long subCmtInstId) {this.subCmtInstId = subCmtInstId;}

}