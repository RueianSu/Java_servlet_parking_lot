package tw.com.parking.lot.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.parking.lot.model.QueryUserDAO;
import tw.com.parking.lot.model.UserData;

@WebServlet("/QueryUser")
public class QueryUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		QueryUserDAO userDao = new QueryUserDAO();
		UserData user = userDao.getUserByEmail(email);

		if (user != null && password.equals(user.getPassword())) {
			// 登入成功
			request.getRequestDispatcher("view/home.jsp").forward(request, response);
		} else {
			// 失敗

		}
		userDao.Close();
	}

}
