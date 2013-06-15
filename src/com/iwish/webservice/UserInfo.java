package com.iwish.webservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserInfo {

	
	public UserInfo(){}
	
	private String userId;

	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
