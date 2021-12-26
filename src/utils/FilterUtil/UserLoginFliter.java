package utils.FilterUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//访问某些资源时过滤
@WebFilter(
        urlPatterns = "/filter/before/*",
        filterName = "WebUserAuthorFliter",
        initParams = {
                @WebInitParam(name = "username", value = "username"),
                @WebInitParam(name = "password", value = "password")
        },
        description = "WebUserAuthorFliter",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
)
public class UserLoginFliter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-------验证用户是否有权限-------");
        String username=filterConfig.getInitParameter("username");
        String password=filterConfig.getInitParameter("password");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //session.setAttribute("webUserLogin",loginUserVO);
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=request.getSession();
        if (session.getAttribute("webUserLogin")!=null){
            //已有授权
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            //获取授权
            request.getRequestDispatcher("/before/user/login.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("-------------=----验证结束-------------------");
    }
}
