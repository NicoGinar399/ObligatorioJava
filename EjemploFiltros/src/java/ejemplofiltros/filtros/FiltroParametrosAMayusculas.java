/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofiltros.filtros;

import ejemplofiltros.filtros.wrappers.WrapperRequestParametrosAMayusculas;
import ejemplofiltros.filtros.wrappers.WrapperResponseParametrosAMayusculas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicol
 */
public class FiltroParametrosAMayusculas implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        //acciones a la ida
        WrapperRequestParametrosAMayusculas pedidoFalso=new WrapperRequestParametrosAMayusculas((HttpServletRequest)request);
        
        WrapperResponseParametrosAMayusculas respuestaFalsa=new WrapperResponseParametrosAMayusculas((HttpServletResponse)response);
        
        chain.doFilter(pedidoFalso, respuestaFalsa); //le estoy diciendo continue
        
        //acciones a la vuelta
        
        PrintWriter salida=response.getWriter();
        
        try {
            String advertencia="<p style=\"background-color: red; color: white; font-weight: bold;\">!advertencia, este servlet ha sido filtrado. </p>";
            String htmlRespuesta=respuestaFalsa.toString().replace("</body>", advertencia + "\n</body>"); //aca remplzao la etiqueta de cierre por un parrafo y la etiqueta de cierre
            
            salida.print(htmlRespuesta);
            
        } finally {
            salida.close();
        }
        
        
    }

    @Override
    public void destroy() {
        
    }
    
}
