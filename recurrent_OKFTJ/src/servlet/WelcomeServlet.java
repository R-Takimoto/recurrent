package servlet;

import java.io.IOException;
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
import model.Products;
import model.Terminal;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

// フォワード先
		String forwardPath = null;
		String action = request.getParameter("action");
		if(action == null){
		//店舗＿席情報登録、注文ＩＤ取得(滝本)
			String store_seatId = request.getParameter("store_seatId");

			if(!(store_seatId == null)) {
				Terminal terminal = new Terminal(store_seatId);
				WelcomeLogic welcomeL = new WelcomeLogic();
				welcomeL.execute(terminal);

				HttpSession session = request.getSession();
				session.setAttribute("terminal", terminal);
			}

			forwardPath="/WEB-INF/jsp/welcome.jsp";

		}else if(action.equals("done")) {
			String key = request.getParameter("key");
			HttpSession session = request.getSession();
			session.setAttribute("key", key);
//			System.out.println("key");

			forwardPath="/WEB-INF/jsp/top.jsp";
		}

		RequestDispatcher disp = request.getRequestDispatcher(forwardPath);
		disp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

			Integer orderTypeId = Integer.parseInt(request.getParameter("orderTypeId"));
			String key = request.getParameter("key");
//			System.out.println(orderTypeId);
//			System.out.println(key);

			if(!(orderTypeId == null)) {

				WelcomeMenuLogic menuL = new WelcomeMenuLogic();
				Map<String, Products> menu = menuL.execute();
//				ArrayList<Product> list = menu.get(key).getProducts();
				//セッションスコープにメニューを保存
				HttpSession session = request.getSession();
				session.setAttribute("menu", menu);
				session.setAttribute("orderTypeId", orderTypeId);
				session.setAttribute("key", key);
//				System.out.println(menu.get("s").getProducts().get(0).getProductName());
			}

			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
			disp.forward(request, response);

	}
}

