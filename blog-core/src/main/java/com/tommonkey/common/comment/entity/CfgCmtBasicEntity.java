package com.tommonkey.common.comment.entity;

import com.tommonkey.common.persistence.entity.BaseEntity;
import com.tommonkey.common.persistence.annotation.Id;

import java.util.Date;

public class CfgCmtBasicEntity extends BaseEntity {
	private Integer groupId;//1、同组每一项都必填；	2、同组间必填且只能填一项；	3、其他

	private String ext3;//null

	private String ext2;//null

	private Long ext1;//null

	private Date createDate;//创建时间

	private Long orgId;//组织编号

	private Long opId;//操作人

	private Integer state;//状态

	private Integer cmtAble;//是否可评论

	private String defaultVal;//默认值

	private Integer nullAble;//评论是否可空

	private Integer itemValueLenth;//评论值的长度

	private Integer showOrder;//展示顺序

	private String itemName;//评论类型名称

	private Long itemId;//评论类型编号

	private Integer moduleId;//数据来源

	private String cmtTargetId;//业务评论对象

	@Id
	private Long cmtId;//评论配置编号

	public Integer getGroupId() {return groupId;}

	public void setGroupId(Integer groupId) {this.groupId = groupId;}

	public String getExt3() {return ext3;}

	public void setExt3(String ext3) {this.ext3 = ext3;}

	public String getExt2() {return ext2;}

	public void setExt2(String ext2) {this.ext2 = ext2;}

	public Long getExt1() {return ext1;}

	public void setExt1(Long ext1) {this.ext1 = ext1;}

	public Date getCreateDate() {return createDate;}

	public void setCreateDate(Date createDate) {this.createDate = createDate;}

	public Long getOrgId() {return orgId;}

	public void setOrgId(Long orgId) {this.orgId = orgId;}

	public Long getOpId() {return opId;}

	public void setOpId(Long opId) {this.opId = opId;}

	public Integer getState() {return state;}

	public void setState(Integer state) {this.state = state;}

	public Integer getCmtAble() {return cmtAble;}

	public void setCmtAble(Integer cmtAble) {this.cmtAble = cmtAble;}

	public String getDefaultVal() {return defaultVal;}

	public void setDefaultVal(String defaultVal) {this.defaultVal = defaultVal;}

	public Integer getNullAble() {return nullAble;}

	public void setNullAble(Integer nullAble) {this.nullAble = nullAble;}

	public Integer getItemValueLenth() {return itemValueLenth;}

	public void setItemValueLenth(Integer itemValueLenth) {this.itemValueLenth = itemValueLenth;}

	public Integer getShowOrder() {return showOrder;}

	public void setShowOrder(Integer showOrder) {this.showOrder = showOrder;}

	public String getItemName() {return itemName;}

	public void setItemName(String itemName) {this.itemName = itemName;}

	public Long getItemId() {return itemId;}

	public void setItemId(Long itemId) {this.itemId = itemId;}

	public Integer getModuleId() {return moduleId;}

	public void setModuleId(Integer moduleId) {this.moduleId = moduleId;}

	public String getCmtTargetId() {return cmtTargetId;}

	public void setCmtTargetId(String cmtTargetId) {this.cmtTargetId = cmtTargetId;}

	public Long getCmtId() {return cmtId;}

	public void setCmtId(Long cmtId) {this.cmtId = cmtId;}

}