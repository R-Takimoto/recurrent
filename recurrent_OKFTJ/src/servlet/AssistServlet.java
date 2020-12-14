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

import model.Products;


@WebServlet("/AssistServlet")
public class AssistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//カロリー絞り込みor価格絞り込みの選択判別のための値（action属性）を受け取りリクエストスコープに保存
		request.setCharacterEncoding("utf-8");
		String orderTypeId=request.getParameter("orderTypeId");
		request.setAttribute("orderTypeId", orderTypeId);
		//絞り込み画面へフォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/assist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String orderType=request.getParameter("orderTypeId");
		Integer orderTypeId = Integer.parseInt(orderType);
		String select = request.getParameter("select");

		//セッションスコープにメニューを保存
		HttpSession session = request.getSession();
		Map<String, Products> menu = (Map<String, Products>) session.getAttribute("menu");
		session.setAttribute("orderTypeId", orderTypeId);
//		if(orderType.equals("2")) {
//			Products wasyoku = menu.get("w");
//			Products yousyoku = menu.get("y");
//			Products toping = menu.get("t");
//			Products sweets = menu.get("s");
//			Products drink = menu.get("d");
//			Products another = menu.get("a");
//
//			int n1 = Integer.parseInt(select);
//			Products selectProducts = new Products();
//			for(int i = 0 ; i < wasyoku.getProducts().size();i++) {
//				if(wasyoku.getProducts().get(i).getPrice() < n1) {
//					selectProducts.getProducts().add(wasyoku.getProducts().get(i));
//				}
//			}
//			Map<String,Products> selectMenu = new HashMap<String,Products>();
//			selectMenu.put("w",selectProducts);
//
//			int n2 = Integer.parseInt(select);
//			Products selectProducts2 = new Products();
//			for(int i = 0 ; i < yousyoku.getProducts().size();i++) {
//				if(yousyoku.getProducts().get(i).getPrice() < n2) {
//					selectProducts.getProducts().add(yousyoku.getProducts().get(i));
//				}
//			}
//			selectMenu.put("y",selectProducts);
//
//			int n3 = Integer.parseInt(select);
//			Products selectProducts3 = new Products();
//			for(int i = 0 ; i < toping.getProducts().size();i++) {
//				if(toping.getProducts().get(i).getPrice() < n3) {
//					selectProducts.getProducts().add(toping.getProducts().get(i));
//				}
//			}
//			selectMenu.put("t",selectProducts);
//
//			int n4 = Integer.parseInt(select);
//			Products selectProducts4 = new Products();
//			for(int i = 0 ; i < sweets.getProducts().size();i++) {
//				if(sweets.getProducts().get(i).getPrice() < n4) {
//					selectProducts.getProducts().add(sweets.getProducts().get(i));
//				}
//			}
//			selectMenu.put("s",selectProducts);
//
//			int n5 = Integer.parseInt(select);
//			Products selectProducts5 = new Products();
//			for(int i = 0 ; i < drink.getProducts().size();i++) {
//				if(drink.getProducts().get(i).getPrice() < n5) {
//					selectProducts.getProducts().add(drink.getProducts().get(i));
//				}
//			}
//
//			selectMenu.put("d",selectProducts);
//
//			int n6 = Integer.parseInt(select);
//			Products selectProducts6 = new Products();
//			for(int i = 0 ; i < another.getProducts().size();i++) {
//				if(another.getProducts().get(i).getPrice() < n6) {
//					selectProducts.getProducts().add(another.getProducts().get(i));
//				}
//			}
//
//			selectMenu.put("a",selectProducts);
//
//			session.setAttribute("selectMenu", selectMenu);
//
//		}
		if(orderType.equals("3")) {
			int selectPrice = Integer.parseInt(select);
			Map<String, Products> map = new HashMap<String, Products>();
			for(String key : menu.keySet()) {
				Products products = new Products();
				for(int i = 0; i  < menu.get(key).getProducts().size(); i ++) {
					if(menu.get(key).getProducts().get(i).getPrice() < selectPrice) {
						products.getProducts().add(menu.get(key).getProducts().get(i));
					}
				}
				map.put(key, products);
			}
			session.setAttribute("selectMenu", map);
		}

		if(orderType.equals("2")) {
			int selectCalorie = Integer.parseInt(select);
			Map<String, Products> map = new HashMap<String, Products>();
			for(String key : menu.keySet()) {
				Products products = new Products();
				for(int i = 0; i  < menu.get(key).getProducts().size(); i ++) {
					if(menu.get(key).getProducts().get(i).getCalorie() < selectCalorie) {
						products.getProducts().add(menu.get(key).getProducts().get(i));
					}
				}
				map.put(key, products);
			}
			session.setAttribute("selectMenu", map);
		}

		//フォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		disp.forward(request, response);

	}
}

