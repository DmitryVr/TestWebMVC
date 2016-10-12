package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Shape;


@WebServlet(name = "/MainServlet", urlPatterns = "/messageServlet")
//@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicationContext context;

	
	
	
	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext("context.xml");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Shape rect = (Shape) context.getBean("shape");
//		rect.setHeight(10);
//		rect.setWidth(22);
		
		request.setAttribute("message", rect.square());
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/message.jsp");
        requestDispatcher.forward(request, response); // данные можно передать на вьюшку
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
