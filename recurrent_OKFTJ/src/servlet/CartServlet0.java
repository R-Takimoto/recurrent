package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartServlet0")
public class CartServlet0 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
		disp.forward(request, response);

		//		String cart = request.getParameter("order");
		//		System.out.println(cart);
		//		if (cart == null) {
		//			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/notcart.jsp");
		//			disp.forward(request, response);
		//		} else {
		//			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
		//			disp.forward(request, response);
		//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/product.jsp");
		disp.forward(request, response);

	}

}
