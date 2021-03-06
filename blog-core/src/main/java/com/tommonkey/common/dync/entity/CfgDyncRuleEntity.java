package com.tommonkey.common.dync.entity;

import com.tommonkey.common.persistence.entity.BaseEntity;
import com.tommonkey.common.persistence.annotation.Id;

import java.util.Date;

public class CfgDyncRuleEntity extends BaseEntity{
	@Id
	private Long ruleId;//规则编号

	private String ruleName;//规则名称

	private Integer ruleType;//规则类型	1-js规则	2-java规则

	private String fileName;//文件名称

	private String funcName;//文件方法

	private Integer state;//状态:1有效0无效

	private String remark;//备注

	private Date createDate;//创建时间

	private Date doneDate;//操作时间

	private Long creator;//创建人

	private Long opId;//操作人


	private Integer fileType;//文件类型：1文件路径，2：文件内容

	private String fileContent;//文件内容

	public Long getRuleId() {return ruleId;}

	public void setRuleId(Long ruleId) {this.ruleId = ruleId;}

	public String getRuleName() {return ruleName;}

	public void setRuleName(String ruleName) {this.ruleName = ruleName;}

	public Integer getRuleType() {return ruleType;}

	public void setRuleType(Integer ruleType) {this.ruleType = ruleType;}

	public String getFileName() {return fileName;}

	public void setFileName(String fileName) {this.fileName = fileName;}

	public String getFuncName() {return funcName;}

	public void setFuncName(String funcName) {this.funcName = funcName;}

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


	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
}