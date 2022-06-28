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
 * Servlet implementation class DoGet
 */
@WebServlet("/DoGet2")
public class DoGet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao = new BookDao();
		HashMap<String, Book> list2 = bookDao.getAllBook();
		request.getSession().setAttribute("list2", list2);
//		request.getRequestDispatcher("showBook.jsp").forward(request, response);
	}

}
