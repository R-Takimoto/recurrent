package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.SlipLogic;
import model.Slips;
import model.Terminal;

@WebServlet("/SlipServlet")
public class SlipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//    	request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		SlipLogic sl = new SlipLogic();
		Terminal terminal = new Terminal(50);

		SlipLogic lo = new SlipLogic();

		Slips slips = lo.execute(terminal);
		request.setAttribute("kaikei", slips);
		//		request.setAttribute("Product", slips.getSlips().get(0).getProduct());
		//		request.setAttribute("Quantity", slips.getSlips().get(0).getQuantity());
		//		request.setAttribute("Price", slips.getSlips().get(0).getPrice());
		//		request.setAttribute("Calorie", slips.getSlips().get(0).getCalorie());
		//		ArrayList<String> kaikei = new ArrayList<String>();
		//		kaikei.add("Product");
		//		kaikei.add("Quantity");
		//		kaikei.add("Price");
		//		kaikei.add("Calorie");

		//		System.out.println(kaikei.get(0));

		if (action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/slip.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/end.jsp");
			dispatcher.forward(request, response);

		}
	}
}
