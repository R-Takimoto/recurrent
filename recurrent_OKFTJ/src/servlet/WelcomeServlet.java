package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//QRコードログイン
		//		String qrCode = request.getParameter("store");
		//		System.out.println(qrCode);

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
		disp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


//		WelcomeMenuLogic menuL = new WelcomeMenuLogic();
//		Map<String, Products> menu = menuL.execute();
////セッションスコープにメニューを保存
//		HttpSession session = request.getSession();
//		session.setAttribute("menu", menu);

//フォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		disp.forward(request, response);

	}
}

