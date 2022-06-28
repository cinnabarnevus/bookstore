package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/SubmitResult1")
public class SubmitResult1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String randStr = (String)session.getAttribute("randStr");
        PrintWriter out = response.getWriter();
        if(!code.equals(randStr)) {
            System.out.println("code.equals(randStr)");
            out.print("<script> alert(\"验证码错误! \");</script>");
            response.setHeader("refresh", "1,url=/register.jsp");
        }else{
            out.print("<script> alert(\"注册成功\");</script>");
            response.setHeader("refresh","1,url=/register.jsp");
        }
        }
}

