package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.SlipLogic;
import model.Slips;
import model.Terminal;

@WebServlet("/SlipServlet")
public class SlipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action == null) {
//			Terminal terminal = new Terminal(50);
			Terminal terminal = (Terminal) session.getAttribute("terminal");

			SlipLogic lo = new SlipLogic();

			Slips slips = lo.execute(terminal);
			if(slips.getSlips().size() == 0) {

			}

			session.setAttribute("kaikei", slips);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/slip.jsp");
			dispatcher.forward(request, response);
		}else if(action.equals("bye")) {
			String bye = "bye";
			request.setAttribute("action", bye);
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/end.jsp");
			dispatcher.forward(request, response);
		}else {
			Slips slips = (Slips) session.getAttribute("kaikei");
			session.removeAttribute("kaikei");
			Integer total = 0;
			for(int i = 0; i < slips.getSlips().size(); i ++) {
				total += slips.getSlips().get(i).getPrice();
			}

			request.setAttribute("total", total);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/end.jsp");
			dispatcher.forward(request, response);

		}
	}
}
