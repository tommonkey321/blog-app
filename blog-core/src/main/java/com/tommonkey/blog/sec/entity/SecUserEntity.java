package com.tommonkey.blog.sec.entity;

import com.tommonkey.common.persistence.entity.BaseEntity;
import com.tommonkey.common.persistence.annotation.Id;

public class SecUserEntity extends BaseEntity{
	private Integer int_3;//null

	private Integer int_2;//null

	private Integer int_1;//null

	private String str_5;//null

	private String str_4;//null

	private String str_3;//null

	private String str_2;//null

	private String str_1;//null

	private String headImage;//上传的头像

	private Integer state;//用户状态（0：锁定，1：正常）

	private String sayHello;//介绍自己的一句话

	private String blogAddress;//个人博客地址

	private String qq;//QQ

	private String email;//邮箱

	private String billid;//联系电话

	private String realName;//真实姓名

	private String nikeName;//昵称

	private String password;//密码

	private String userName;//用户名

	@Id
	private Integer userId;//用户id

	public Integer getInt_3() {return int_3;}

	public void setInt_3(Integer int_3) {this.int_3 = int_3;}

	public Integer getInt_2() {return int_2;}

	public void setInt_2(Integer int_2) {this.int_2 = int_2;}

	public Integer getInt_1() {return int_1;}

	public void setInt_1(Integer int_1) {this.int_1 = int_1;}

	public String getStr_5() {return str_5;}

	public void setStr_5(String str_5) {this.str_5 = str_5;}

	public String getStr_4() {return str_4;}

	public void setStr_4(String str_4) {this.str_4 = str_4;}

	public String getStr_3() {return str_3;}

	public void setStr_3(String str_3) {this.str_3 = str_3;}

	public String getStr_2() {return str_2;}

	public void setStr_2(String str_2) {this.str_2 = str_2;}

	public String getStr_1() {return str_1;}

	public void setStr_1(String str_1) {this.str_1 = str_1;}

	public String getHeadImage() {return headImage;}

	public void setHeadImage(String headImage) {this.headImage = headImage;}

	public Integer getState() {return state;}

	public void setState(Integer state) {this.state = state;}

	public String getSayHello() {return sayHello;}

	public void setSayHello(String sayHello) {this.sayHello = sayHello;}

	public String getBlogAddress() {return blogAddress;}

	public void setBlogAddress(String blogAddress) {this.blogAddress = blogAddress;}

	public String getQq() {return qq;}

	public void setQq(String qq) {this.qq = qq;}

	public String getEmail() {return email;}

	public void setEmail(String email) {this.email = email;}

	public String getBillid() {return billid;}

	public void setBillid(String billid) {this.billid = billid;}

	public String getRealName() {return realName;}

	public void setRealName(String realName) {this.realName = realName;}

	public String getNikeName() {return nikeName;}

	public void setNikeName(String nikeName) {this.nikeName = nikeName;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public String getUserName() {return userName;}

	public void setUserName(String userName) {this.userName = userName;}

	public Integer getUserId() {return userId;}

	public void setUserId(Integer userId) {this.userId = userId;}

}