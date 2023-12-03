package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebFilter(urlPatterns={"/list", "/new" , "/delete", "/update" , "/sort" ,"/mypage" })

public class LoginFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {}
	
	public void doFilter(ServletRequest request , ServletResponse response , FilterChain chain) throws IOException,ServletException{
		//filterにつけたいことを記載
		request.setCharacterEncoding("UTF-8");

		// ServletRequestをHttpServletRequestにダウンキャストします
        HttpServletRequest hreq = (HttpServletRequest) request;
        // ServletResponseをHttpServletResponseにダウンキャストします
        HttpServletResponse hres = (HttpServletResponse) response;
		
		
		 HttpSession session = hreq.getSession(false);
		 String userId = (String)session.getAttribute("userId"); 
         
            
            if ( userId == null) {
            	
                hres.sendRedirect("login");
                return;
            }
            
            chain.doFilter(request,response);
            

		

	}
	
	public void destroy(){}
	
}
