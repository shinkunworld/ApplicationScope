package servlet;

import java.io.IOException;

//import javax.servlet.RequestDispatcher; forward할때 필요한 임폴트
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// アプリケーションスコープに保存されたサイト評価を取得
		ServletContext application = this.getServletContext();
		SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
		// サイト評価の初期化（初回リクエスト時実行）
		if (siteEV == null) {
			siteEV = new SiteEV();
		}

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		// サイトの評価処理（初回リクエスト時は実行しない）
		SiteEVLogic siteEVLogic = new SiteEVLogic();
		if (action != null && action.equals("like")) {
			siteEVLogic.like(siteEV);
		} else if (action != null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEV);
		}
		// アプリケーションスコープにサイト評価を保存

		application.setAttribute("siteEV", siteEV);
		//forward의 경우
		//	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/minatoIndex.jsp");
		//dispatcher.forward(request, response);

		//redirect의 경우
		response.sendRedirect("TestRedirect");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
