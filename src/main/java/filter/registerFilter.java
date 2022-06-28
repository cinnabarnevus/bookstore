package filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class registerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        String[] urls={"/register.jsp","/login.jsp","css/style.css","css/index.css","css/mjs.js","/img","/CodeServlet","/AddUser","/SubmitResult","/DoGet","/paid.jsp"};
        String url=req.getRequestURI().toString();
        System.out.println(url);
        for(String u:urls){
            if(url.contains(u)){
                chain.doFilter(request,response);
                return;
            }
        }
        HttpSession session=req.getSession();
//        String name = (String) session.getAttribute("name");
//        User user= (User)session.getAttribute("");
        String name = (String) session.getAttribute("user");
        if(name!=null){
            chain.doFilter(request,response);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,response);
        }
    }
    @Override
    public void destroy(){

    }
}
