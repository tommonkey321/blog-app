package com.tommonkey.common.comment.entity;

import com.tommonkey.common.persistence.entity.BaseEntity;
import com.tommonkey.common.persistence.annotation.Id;

import java.util.Date;

public class CfgCmtInstEntity extends BaseEntity {
	private String ext2;//null

	private Long ext1;//null

	private Integer groupId;//1、同组每一项都必填；	2、同组间必填且只能填一项；	3、其他

	private String cmtTargetName;//业务评论对象名

	private Date createDate;//创建时间

	private String creatorName;//创建人名

	private Long creator;//创建人

	private Integer moduleId;//评论来源

	private Integer cmtState;//评论状态

	private Long outNbrId;//关联评论编号

	private String itemText;//评论显示值

	private String itemValue;//评论值

	private Long itemId;//评论类型编号

	private String cmtTargetId;//业务评论对象

	@Id
	private Long cmtInstId;//评论编号

	public String getExt2() {return ext2;}

	public void setExt2(String ext2) {this.ext2 = ext2;}

	public Long getExt1() {return ext1;}

	public void setExt1(Long ext1) {this.ext1 = ext1;}

	public Integer getGroupId() {return groupId;}

	public void setGroupId(Integer groupId) {this.groupId = groupId;}

	public String getCmtTargetName() {return cmtTargetName;}

	public void setCmtTargetName(String cmtTargetName) {this.cmtTargetName = cmtTargetName;}

	public Date getCreateDate() {return createDate;}

	public void setCreateDate(Date createDate) {this.createDate = createDate;}

	public String getCreatorName() {return creatorName;}

	public void setCreatorName(String creatorName) {this.creatorName = creatorName;}

	public Long getCreator() {return creator;}

	public void setCreator(Long creator) {this.creator = creator;}

	public Integer getModuleId() {return moduleId;}

	public void setModuleId(Integer moduleId) {this.moduleId = moduleId;}

	public Integer getCmtState() {return cmtState;}

	public void setCmtState(Integer cmtState) {this.cmtState = cmtState;}

	public Long getOutNbrId() {return outNbrId;}

	public void setOutNbrId(Long outNbrId) {this.outNbrId = outNbrId;}

	public String getItemText() {return itemText;}

	public void setItemText(String itemText) {this.itemText = itemText;}

	public String getItemValue() {return itemValue;}

	public void setItemValue(String itemValue) {this.itemValue = itemValue;}

	public Long getItemId() {return itemId;}

	public void setItemId(Long itemId) {this.itemId = itemId;}

	public String getCmtTargetId() {return cmtTargetId;}

	public void setCmtTargetId(String cmtTargetId) {this.cmtTargetId = cmtTargetId;}

	public Long getCmtInstId() {return cmtInstId;}

	public void setCmtInstId(Long cmtInstId) {this.cmtInstId = cmtInstId;}

}