package com.shnu.eshop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CheckAction extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CheckProcess cp = new CheckProcess();
		CheckActionForm caf = new CheckActionForm();
		HttpSession session = request.getSession();
		String curUsername = (String)session.getAttribute("curUsername");
		List<ProductLineItem> cart = (List<ProductLineItem>)session.getAttribute("cart");
		if(curUsername==null){
			request.setAttribute("msg", "YOU ARE NOT LOG IN!");
			return mapping.findForward("check_error");
		}else if(cart==null){
			request.setAttribute("msg", "YOU CART IS EMPTY!");
			return mapping.findForward("check_error");
		}else if(cp.isCheckSuccess(caf, session)){
			return mapping.findForward("check_success");
		}
		request.setAttribute("msg", "UNKNOWN ERROR!TRANSACTION NOT COMPLETED!");
		return mapping.findForward("check_error");
	}

}
