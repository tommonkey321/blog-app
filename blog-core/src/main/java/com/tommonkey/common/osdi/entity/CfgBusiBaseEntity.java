package com.tommonkey.common.osdi.entity;

import com.tommonkey.common.persistence.entity.BaseEntity;
import com.tommonkey.common.persistence.annotation.Id;

public class CfgBusiBaseEntity extends BaseEntity{
	@Id
	private String busiId;//null

	private String busiName;//null

	private String des;//null

	private Integer state;//null

	private Integer busiType;//1.顺序调用，2.合值调用

	public String getBusiId() {return busiId;}

	public void setBusiId(String busiId) {this.busiId = busiId;}

	public String getBusiName() {return busiName;}

	public void setBusiName(String busiName) {this.busiName = busiName;}

	public String getDes() {return des;}

	public void setDes(String des) {this.des = des;}

	public Integer getState() {return state;}

	public void setState(Integer state) {this.state = state;}

	public Integer getBusiType() {
		return busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

}