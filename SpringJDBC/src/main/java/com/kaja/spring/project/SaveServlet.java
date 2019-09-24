package com.kaja.spring.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SaveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String n = req.getParameter("proName");
		String d = req.getParameter("proDescription");
		
		ApplicationContext cox = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Project pt = (Project)cox.getBean("proj");
		pt.setProjName(n);
		pt.setProjDescription(d);
		
		ProDao dao = (ProDao)cox.getBean("pdao");
			
		int status = dao.savePro(pt);
		if(status>0) {
			out.print("<p>Details Successfully Saved!</p>");
			req.getRequestDispatcher("index.jsp").include(req, resp);
		}
		else{
			out.print("Sorry! Failed To Save Details!");
		}
		
		out.close();
		
	}

	
}
