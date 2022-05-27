/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofiltros.filtros.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author nicol
 */
public class WrapperRequestParametrosAMayusculas extends HttpServletRequestWrapper{
    
    public WrapperRequestParametrosAMayusculas(HttpServletRequest request) {
        super(request);
    }
    //control espacio para que me ayude
    @Override
    public String getParameter(String name) {
        return super.getParameter(name).toUpperCase();
    }
    
    
    
}
