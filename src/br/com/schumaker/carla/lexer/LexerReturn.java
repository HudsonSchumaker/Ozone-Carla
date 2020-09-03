package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.exception.ReturnTypeNotFoundException;
import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.lexer.o3.O3FunctionVariableTable;
import br.com.schumaker.carla.lexer.o3.O3Return;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.o3.O3SyntaxKeyword;
import br.com.schumaker.carla.o3.core.O3CoreLibrary;

/**
 * This class resolves the return type of a O3 function.
 *
 * @author Hudson Schumaker
 */
public class LexerReturn {
    public static final String IGNORED_RETURN = "irv";
    public static final String NA = "n/a";

    private O3FunctionVariableTable variableTable;
    private O3CoreLibrary coreLibrary;

    public LexerReturn(O3FunctionVariableTable variableTable) {
        this.variableTable = variableTable;
        this.coreLibrary = new O3CoreLibrary();
    }
    
    public O3Return resolveReturnType(String functioName, O3FileLine line) {
        var function = coreLibrary.getByName(functioName);
        
        // void return from a function
        if (O3VariableType.VOID.equals(function.getReturnType())) {
            return new O3Return(functioName, 
                    O3VariableType.VOID,
                    false,
                    false,
                    O3VariableType.VOID.getName(),
                    O3VariableType.VOID.getName());
        } else {
            var rawLine = line.getData();
            if (!rawLine.contains(O3SyntaxKeyword.ASSINGN)) {
                return new O3Return(functioName, 
                    function.getReturnType(),
                    false,
                    false,
                    IGNORED_RETURN,
                    IGNORED_RETURN);
            }
            
            if (rawLine.contains(O3SyntaxKeyword.ASSINGN)) {
                var clear = rawLine.trim();
                var subLine = clear.substring(0, clear.indexOf(O3SyntaxKeyword.ASSINGN)).trim();
                var o3variable = variableTable.getVariableByName(subLine);
              
                return new O3Return(functioName, 
                    function.getReturnType(),
                    true,
                    false,
                    o3variable.getInternalName().replaceAll(":", ""),
                    NA);
            } 
            
            // resolve when return to a function 
            
        }
            
        throw new ReturnTypeNotFoundException();
    }
}