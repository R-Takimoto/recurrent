<<<<<<< HEAD
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

=======
package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.WelcomeLogic;
import model.Product;
import model.Products;
import model.Terminal;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//店舗＿席情報登録、注文ＩＤ取得(滝本)
		{
			String store_seatId = request.getParameter("store_seatId");
			if(store_seatId != null) {
				Terminal terminal = new Terminal(store_seatId);
				WelcomeLogic welcomeL = new WelcomeLogic();
				welcomeL.execute(terminal);

				HttpSession session = request.getSession();
				session.setAttribute("terminal", terminal);
			}

		}

		//mode_navから通常メニュー表示へ切り替え(滝本)
		{
			String orderType = request.getParameter("orderTypeId");
			if(orderType != null) {
				Integer orderTypeId = Integer.parseInt(orderType);
				HttpSession session = request.getSession();
				session.setAttribute("orderTypeId", orderTypeId);
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
				disp.forward(request, response);
			}
		}

		//menu_navからの遷移、各メニュー表示
		{
			String key = request.getParameter("key");
			if(key != null) {
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
				disp.forward(request, response);
			}
		}

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
		disp.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Integer orderTypeId = Integer.parseInt(request.getParameter("orderTypeId"));

//		WelcomeMenuLogic menuL = new WelcomeMenuLogic();
//		Map<String, Products> menu = menuL.execute();
//		//セッションスコープにメニューを保存
		HttpSession session = request.getSession();
//		session.setAttribute("menu", menu);
		session.setAttribute("orderTypeId", orderTypeId);

		/////////////////////////////////

		Product product1 = new Product();
		product1.setTypeCode("w-005");
		product1.setProductName("だし巻きたまご中こく");
		product1.setPrice(100);
		product1.setCalorie(120);
		product1.setImage("wasyoku-005.jpg");
		Products setproducts1 = new Products();
		setproducts1.getProducts().add(product1);
		Map<String, Products> productsM = new HashMap<String, Products>();
		productsM.put("w", setproducts1);

		Product product2 = new Product();
		product2.setTypeCode("a-001");
		product2.setProductName("ごはん");
		product2.setPrice(110);
		product2.setCalorie(150);
		product2.setImage("sonota-001.jpg");
		Products setproducts2 = new Products();
		setproducts2.getProducts().add(product2);
		productsM.put("a", setproducts2);

		session.setAttribute("menu", productsM);

		//フォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		disp.forward(request, response);

	}
}

>>>>>>> 3ea5ce325bd1e006a0b2d3bca4822f9e48c36b00
