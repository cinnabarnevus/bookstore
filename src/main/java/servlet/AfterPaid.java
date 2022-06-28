package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;
import dao.BookDao;


/**
 * Servlet implementation class AfterPaid
 */
@WebServlet("/AfterPaid")
public class AfterPaid extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//更新数据库，如果有商品被购买完，那么在数据库进行删除
		//如果仍有存货，那么更新商品数量
		ArrayList<Book> cart = (ArrayList<Book>) request.getSession().getAttribute("cart");
		HashMap<String, Book> list2 = (HashMap<String, Book>) request.getSession().getAttribute("list2");
		BookDao bookDao = new BookDao();
		for(Book book:cart) {
			Book oldBook  = list2.get(book.getId()+"");
			int count = oldBook.getBookCount();
			String id = book.getId()+"";
			if(book.getBookCount()==count) {
				bookDao.deleteId(id);
			}
			oldBook.setBookCount(count-book.getBookCount());
			bookDao.updateAndDelete("update tb_books set bookCount="+oldBook.getBookCount()+" where id="+id);
		}

		session.invalidate(); //我猜失效之后，那些属性一定也被失效了
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		response.sendRedirect("/paid.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
