package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.model.User;


@WebServlet(urlPatterns =  {"/waiting"})
public class WaitingController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2460007397275808766L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
	HttpSession session= req.getSession();
	if(session != null && session.getAttribute("account") != null) {
		User u=(User) session.getAttribute("account");
		req.setAttribute("username", u.getUserName());
		if(u.getRoleid()==1) {
			resp.sendRedirect(req.getContextPath()+"/admin/home");
		}
		else if(u.getRoleid()==2) {
		resp.sendRedirect(req.getContextPath()+"/manager/home");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/home");
		}
		}
	
	}
	
}

