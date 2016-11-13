package com.shnu.eshop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class AddToCartAction extends Action {

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		AddToCartActionForm atcaf = (AddToCartActionForm)form;
		HttpSession session = request.getSession();
		List<ProductLineItem> cart;
		ProductLineItem pli = new ProductLineItem();
		cart = (List<ProductLineItem>) session.getAttribute("cart");
		if(cart==null)
			cart = new ArrayList();
		if(atcaf.getQuantity()>atcaf.getStock())
			return mapping.findForward("addtocart_error");
		pli.setId(atcaf.getId());
		pli.setName(atcaf.getName());
		pli.setPrice(atcaf.getPrice());
		pli.setQuantity(atcaf.getQuantity());
		cart.add(pli);
		session.setAttribute("cart", cart);
		// TODO Auto-generated method stub
		return mapping.findForward("addtocart_success");
	}

}
