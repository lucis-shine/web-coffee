package utils.FilterUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----------编码过滤----------");
        encode= filterConfig.getInitParameter("encode");
        System.out.println(encode);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    /*    System.out.println("--------设置字符集编码------"+encode);*/
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        req.setCharacterEncoding(encode);
        resp.setCharacterEncoding(encode);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("-------编码过滤完成------");
    }
}
