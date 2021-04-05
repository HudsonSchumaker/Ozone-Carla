package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.impl.LexerFunctionTable;
import br.com.schumaker.carla.o3.impl.O3Function;
import br.com.schumaker.carla.o3.impl.O3Parameter;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerFunction {

    List<O3Function> getFunctions(O3File file);

    /**
     * Return a list with the parameters of a function.
     *
     * @param functionName Declared function name.
     * @param headLine     Signature of the function.
     * @return List of parameter of the function.
     */
    List<O3Parameter> getParams(String functionName, O3FileLine headLine);

    /**
     * This method create O3Function object with a basic O3Statement and
     * O3FunctionVariableTable incomplete (only parameter variables), in the next step when
     * is create the O3FunctionStatement and the O3FunctionVariableTable should be update.
     *
     * @param headerLine Signature of the function.
     * @param file       O3File, source file .o3
     * @return O3Function, representation of a function.
     */
    O3Function getBody(O3FileLine headerLine, O3File file);

    List<O3FileLine> getHeaderLines(O3File file);

    boolean isMainFunction(O3FileLine headerLine);

    String getFunctionInternalName(O3FileLine headerLine);

    String getFunctionName(O3FileLine headerLine);

    LexerFunctionTable getFunctionTable();
}
