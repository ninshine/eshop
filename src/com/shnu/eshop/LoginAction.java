package com.shnu.eshop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		LoginActionForm laf = (LoginActionForm) form;
		String username = laf.getUsername();
		String password = laf.getPassword();
		UserManager userMngr = new UserManager();
		try{
			userMngr.login(username,password,request);
			return mapping.findForward("login_success");
		}catch(PasswordWrongException e){
			e.printStackTrace();
			request.setAttribute("msg", "PASSWORD WRONG!");
			return mapping.findForward("login_error");
		}catch(UserNotFoundException e){
			e.printStackTrace();
			request.setAttribute("msg", "USER \""+username+"\" NOT FOUND!");
			return mapping.findForward("login_error");
		}
		
	}

	

}
