package com.shnu.eshop;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class CheckActionForm extends ActionForm {
	private String shipping_addr;
	private String shipping_name;
	private String shipping_tel;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getShipping_addr() {
		return shipping_addr;
	}
	public void setShipping_addr(String shipping_addr) {
		this.shipping_addr = shipping_addr;
	}
	public String getShipping_name() {
		return shipping_name;
	}
	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}
	public String getShipping_tel() {
		return shipping_tel;
	}
	public void setShipping_tel(String shipping_tel) {
		this.shipping_tel = shipping_tel;
	}
	
}
