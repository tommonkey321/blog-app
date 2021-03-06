package com.tommonkey.common.dync.entity;

import com.tommonkey.common.persistence.entity.BaseEntity;
import com.tommonkey.common.persistence.annotation.Id;

import java.util.Date;

public class CfgDyncRulesetRuleEntity extends BaseEntity {
	@Id
	private Long relatId;//主键

	private Long rulesetId;//规则集编号

	private Long ruleId;//规则编号

	private String ruleTriggerType;//规则触发类型	1onload	2onchange	3submit

	private Integer sortId;//排序

	private Integer state;//状态:1有效0无效

	private String remark;//备注

	private Date createDate;//创建时间

	private Date doneDate;//操作时间

	private Long creator;//创建人

	private Long opId;//操作人

	public Long getRelatId() {return relatId;}

	public void setRelatId(Long relatId) {this.relatId = relatId;}

	public Long getRulesetId() {return rulesetId;}

	public void setRulesetId(Long rulesetId) {this.rulesetId = rulesetId;}

	public Long getRuleId() {return ruleId;}

	public void setRuleId(Long ruleId) {this.ruleId = ruleId;}

	public String getRuleTriggerType() {
		return ruleTriggerType;
	}

	public void setRuleTriggerType(String ruleTriggerType) {
		this.ruleTriggerType = ruleTriggerType;
	}

	public Integer getSortId() {return sortId;}

	public void setSortId(Integer sortId) {this.sortId = sortId;}

	public Integer getState() {return state;}

	public void setState(Integer state) {this.state = state;}

	public String getRemark() {return remark;}

	public void setRemark(String remark) {this.remark = remark;}

	public Date getCreateDate() {return createDate;}

	public void setCreateDate(Date createDate) {this.createDate = createDate;}

	public Date getDoneDate() {return doneDate;}

	public void setDoneDate(Date doneDate) {this.doneDate = doneDate;}

	public Long getCreator() {return creator;}

	public void setCreator(Long creator) {this.creator = creator;}

	public Long getOpId() {return opId;}

	public void setOpId(Long opId) {this.opId = opId;}

}