package servlet;
import beans.User;
import dao.UserDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*登录界面的验证码*/
@WebServlet("/SubmitResult")
public class SubmitResult extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
//	protected int judge(){
//
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String randStr = (String)session.getAttribute("randStr");
		PrintWriter out = response.getWriter();
		if(!code.equals(randStr)) {
			System.out.println("code.equals(randStr)");
			out.print("<script> alert(\"验证码错误! \");</script>");
			response.setHeader("refresh", "1,url=/login.jsp");
		}
		else {

//			String acc = "123456";
//			String pwd = "654321";
			String admin = "admin";
			String adminPwd = "admin";
			String racc = request.getParameter("account");
			String rpwd = request.getParameter("password");

			session.setAttribute("user",racc);

			System.out.println("phone:"+racc);
			System.out.println("pwd:"+rpwd);
			System.out.println("admin:"+admin);
			System.out.println("adminPwd:"+adminPwd);
			boolean flag1 = true;
			boolean flag = true;
			if (admin.equals(racc) && adminPwd.equals(rpwd)){
				response.setHeader("refresh", "1,url=/bookStorage.jsp");
				flag1 = false;
			}else {
				if (flag1) {
					HashMap<String, User> list = new HashMap<>();
					UserDao userDao = new UserDao();
					try {
						list = userDao.getAllUser();
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}

					for (User user1 : list.values()) {
						if (user1.getName().equals(racc) && user1.getPassword().equals(rpwd)) {
							flag = false;
							response.getWriter().print("<p>Signing in</p>");
							response.setHeader("refresh", "1,url=/DoGet");
						}
					}
				}
				if (flag) {
					response.getWriter().print("<script> alert(\"账号或密码错误! \");</script>");
					response.setHeader("refresh", "1,url=/login.jsp");
				}
			}
//			if(acc.equals(racc) && pwd.equals(rpwd)){
//				response.getWriter().print("<p>Signing in</p>");
//				response.setHeader("refresh", "1,url=/DoGet");
//			}
//			else if (admin.equals(racc) && adminPwd.equals(rpwd)) {
//
//				response.setHeader("refresh", "1,url=/bookStorage.jsp");
//			}
//			else
//			{
//				response.getWriter().print("<script> alert(\"账号或密码错误! \");</script>");
//				response.setHeader("refresh", "1,url=/login.jsp");
//			}
		}
	}

}
