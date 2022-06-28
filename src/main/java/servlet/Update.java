package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import dao.BookDao;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		String bookCount = request.getParameter("bookCount");
		System.out.println(bookCount);
		
		HashMap<String, Book> list2 = (HashMap<String, Book>) request.getSession().getAttribute("list2");
		list2.get(id).setBookCount(Integer.valueOf(bookCount));
		
		new BookDao().updateAndDelete("update tb_books set bookCount='"+bookCount+"' where id='"+id+"'");
		response.getWriter().print("<p>更新成功！</p>");
		response.setHeader("refresh", "1,url=/bookStorage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
