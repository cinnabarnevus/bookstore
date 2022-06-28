package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import dao.BookDao;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddBook.java");
		Book book = new Book();
		String name = request.getParameter("name");
		Double price = Double.valueOf(request.getParameter("price"));
		int bookCount = Integer.valueOf(request.getParameter("bookCount"));
		String author = request.getParameter("author");
		book.setName(name);
		book.setPrice(price);
		book.setBookCount(bookCount);
		book.setAuthor(author);
		String sql = "insert into tb_books(name,price,bookCount,author) values(?,?,?,?)";
		BookDao dUtils = new BookDao();
		dUtils.insertRecord(book, sql);
		response.getWriter().print("<script> alert(\"添加成功! \");</script>");
		response.setHeader("refresh", "1,url=index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
