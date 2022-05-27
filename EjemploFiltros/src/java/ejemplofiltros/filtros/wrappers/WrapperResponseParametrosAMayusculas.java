/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofiltros.filtros.wrappers;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author nicol
 */
public class WrapperResponseParametrosAMayusculas  extends HttpServletResponseWrapper{
    
    private CharArrayWriter salidaFalsa;
    
    public WrapperResponseParametrosAMayusculas(HttpServletResponse response) {
        super(response);
        
        salidaFalsa=new CharArrayWriter();
    }
    //control espacio getwriter
    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(salidaFalsa);
    }

    @Override
    public String toString() {
       return salidaFalsa.toString();
    }
    
    
    
}
