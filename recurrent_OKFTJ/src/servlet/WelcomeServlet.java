package servlet;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> takimoto/brach
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.WelcomeLogic;
import bo.WelcomeMenuLogic;
<<<<<<< HEAD
import model.Product;
=======
import model.Products;
>>>>>>> takimoto/brach
import model.Terminal;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//店舗＿席情報登録、注文ＩＤ取得(滝本)
		{
			String store_seatId = request.getParameter("store_seatId");
			if(!(store_seatId == null)) {
				Terminal terminal = new Terminal(store_seatId);
				WelcomeLogic welcomeL = new WelcomeLogic();
				welcomeL.execute(terminal);

				HttpSession session = request.getSession();
				session.setAttribute("terminal", terminal);
			}

		}

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
		disp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Integer orderTypeId = Integer.parseInt(request.getParameter("orderTypeId"));


		WelcomeMenuLogic menuL = new WelcomeMenuLogic();
<<<<<<< HEAD
		Map<String, ArrayList<Product>> menu = menuL.execute();
=======
		Map<String, Products> menu = menuL.execute();
>>>>>>> takimoto/brach
		//セッションスコープにメニューを保存
		HttpSession session = request.getSession();
		session.setAttribute("menu", menu);
		session.setAttribute("orderTypeId", orderTypeId);

		//フォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		disp.forward(request, response);

	}
}

