package com.tommonkey.utils.http.handler.sh;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Map;

/**
 * Created by LIUQ on 2015/7/23.
 */
class RequestBean {

	@JsonProperty("BusiCode")
	private String BusiCode;

	@JsonProperty("BusiParams")
	private Map<String, Object> BusiParams;

    @JsonIgnore
	public String getBusiCode() {
		return BusiCode;
	}

	@JsonIgnore
	public void setBusiCode(String busiCode) {
		BusiCode = busiCode;
	}

	@JsonIgnore
	public Map<String, Object> getBusiParams() {
		return BusiParams;
	}

	@JsonIgnore
	public void setBusiParams(Map<String, Object> busiParams) {
		BusiParams = busiParams;
	}

}