package tw.com.parking.lot.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryUserDAO extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection conn = null;

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public QueryUserDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get SQL Password
			JDBC getJDBC = new JDBC();
			conn = DriverManager.getConnection(getJDBC.getJdbcUrl(), getJDBC.getJdbcUser(), getJDBC.getJdbcPassword());

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("sql 連接套件錯誤");
			e.printStackTrace();
		}
	}

	public UserData getUserByEmail(String email) {
		UserData user = null;

		try {

			// SQL find
			String sql = "SELECT * FROM users WHERE email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new UserData(null, sql, sql, null, sql, null, null);

				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

			} else {
				// 沒找到 email
				System.out.println("沒找到 email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql 連接錯誤");
		} finally {
			Close();
		}
		return user;
	}

	public void Close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("關閉錯誤");
		}
	}
}
