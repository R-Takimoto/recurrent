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

import bo.ManagerIdCheckLogic;
import bo.ManagerRegisterLogic;
import model.Manager;


@WebServlet("/AccountRegistrationServlet")
public class AccountRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//actionパラメータの受け取り,リクエストスコープに保存
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		request.setAttribute("action", action);
		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/accountCreate.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータの受け取り,Managerクラスに格納
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");

		//リクエストスコープにaction属性を格納
		request.setAttribute("action", action);

		String fowardpath=null;

		//action属性がNullなら（return（戻るボタン）の時はしない）DB登録前チェック
		if(action==null) {
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String name=request.getParameter("name");
			System.out.println(action);
			System.out.println(id);
			System.out.println(pass);
			System.out.println(name);


			//Managerクラスに入力情報格納
			Manager newManager=new Manager(id,pass,name);

			//エラーメッセージ用Mapを用意
			Map<String,String>errMsg=new HashMap<String,String>();

			//入力情報チェック
			if(id!=null&&id.length()>15) {
				//エラーメッセージをMapに格納
				errMsg.put("id","※15文字以内にしてください");
				//エラーメッセージを格納したMapをリクエストスコープに保存
				request.setAttribute("errMsg", errMsg);
				//入力値が15文字以上場合は入力値を再表示させない
				newManager.setId(null);
				//フォワードバスは入力画面
				fowardpath="/WEB-INF/jsp/accountCreate.jsp";
			}else if(pass!=null&&pass.length()>15) {
				errMsg.put("pass","※15文字以内にしてください");
				request.setAttribute("errMsg", errMsg);
				fowardpath="/WEB-INF/jsp/accountCreate.jsp";
			}else if(name!=null&&name.length()>15) {
				errMsg.put("name","※15文字以内にしてください");
				newManager.setName(null);
				request.setAttribute("errMsg", errMsg);
				fowardpath="/WEB-INF/jsp/accountCreate.jsp";
			}

			//IDアカウント重複チェック
			ManagerIdCheckLogic micl=new ManagerIdCheckLogic();
			boolean checkIdResult=micl.checkId(newManager);
			//重複がなければ
			if(checkIdResult&&newManager.getId()!=null&&newManager.getPass()!=null&&newManager.getName()!=null) {
				//セッションスコープに入力情報（Manager情報）を保存
				HttpSession session =request.getSession();
				session.setAttribute("newManager", newManager);
				//フォワードパスは確認画面
				fowardpath="/WEB-INF/jsp/accountCreateConfirm.jsp";
			}else if(checkIdResult==false){
				//ID重複していればエラーメッセージを生成、格納、入力画面にフォワード
				String idDuplicateMsg="管理者ID名はすでに使用されています";
				request.setAttribute("idDuplicateMsg", idDuplicateMsg);
				newManager.setId(null);
				HttpSession session =request.getSession();
				session.setAttribute("newManager", newManager);
				fowardpath="/WEB-INF/jsp/accountCreate.jsp";
			}




		//action属性がdoneの場合（登録ボタン押した場合）
		}else if(action.equals("done")) {
			HttpSession session =request.getSession();
			Manager registerNewManager=(Manager)session.getAttribute("newManager");

			//DBに新規アカウント登録
			ManagerRegisterLogic mrl=new ManagerRegisterLogic();
			mrl.newAccount(registerNewManager);

			//リクエストスコープにManager情報を格納してセッションスコープのManager情報は破棄
			request.setAttribute("newManager", registerNewManager);
			session.removeAttribute("newManager");

			fowardpath="/WEB-INF/jsp/accountCreateDone.jsp";
		}

		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher(fowardpath);
		dispatcher.forward(request, response);
	}

}
