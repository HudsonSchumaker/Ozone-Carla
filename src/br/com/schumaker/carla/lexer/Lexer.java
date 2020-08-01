package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.o3.O3Keyword;

/**
 *
 * @author schumaker
 */
public class Lexer {
    
    public String getFunctionMain() {   
        return "";
    }
    
    public static boolean isFunctionHeader(String data) {
        return data.startsWith(O3Keyword.FUNCTION);
    }
}
