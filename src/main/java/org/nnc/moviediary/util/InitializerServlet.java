package org.nnc.moviediary.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class InitializerServlet extends HttpServlet {
	private static final long serialVersionUID = -212133147566075373L;

	@Override
	public void init() throws ServletException {
		ApplicationContextLoader.loadSpring();
	}
}
