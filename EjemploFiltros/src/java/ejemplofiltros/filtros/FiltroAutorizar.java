/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofiltros.filtros;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicol
 */
public class FiltroAutorizar implements Filter {

    private String usuario;
    private String contrasena;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        usuario=filterConfig.getInitParameter("usuario");
        contrasena=filterConfig.getInitParameter("contrasena");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        
           HttpSession sesion= ((HttpServletRequest)request).getSession();
           
           if (sesion.getAttribute("usuario") == null && usuario.equals(request.getParameter("usuario")) && contrasena.equals(request.getParameter("contrasena"))) {
               sesion.setAttribute("usuario", usuario);
           }
           
           if(sesion.getAttribute("usuario") != null) {
               chain.doFilter(request, response);
           } else {
               System.out.println("LOG [" + new Date() + "] > intento de acceso no autorizado");
               
               ((HttpServletResponse)response).sendRedirect("/EjemploFiltros/AccesoNoAutorizado");
           }
       // System.out.println("!filtrado!!");
        
       // chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
}
