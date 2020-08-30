package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.lexer.o3.IO3Statement;
import br.com.schumaker.carla.lexer.o3.O3Argument;
import br.com.schumaker.carla.lexer.o3.O3FunctionCall;
import br.com.schumaker.carla.lexer.o3.O3FunctionVariableTable;
import br.com.schumaker.carla.lexer.o3.O3TypeValue;
import br.com.schumaker.carla.lexer.utils.StringUtils;
import br.com.schumaker.carla.o3.O3SyntaxKeyword;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public class LexerFunctionCall {

    private LexerArgument lexerArgument;

    public LexerFunctionCall() {
        this.lexerArgument = new LexerArgument();
    }

    /**
     * Get a list of O³ function call inside a O³ function.
     *
     * @param statement Statement (Body) of a O³ function
     * @param variableTable
     * @return
     */
    public List<O3FunctionCall> getFunctionCalls(IO3Statement statement, O3FunctionVariableTable variableTable) {
        var functionCalls = new ArrayList<O3FunctionCall>();
        for (O3FileLine line : statement.getLines()) {
            if (line.isFunctionCall()) {
                functionCalls.add(this.getFunctionCall(line, variableTable));
            }
        }
        return functionCalls;
    }

    /**
     * Create an O³ FunctionCall element based in the args.
     *
     * @param line
     * @param variableTable
     * @return
     */
    public O3FunctionCall getFunctionCall(O3FileLine line, O3FunctionVariableTable variableTable) {
        var functionName = this.getFunctionName(line.getData());
        var arguments = this.getArguments(line, variableTable);

        return new O3FunctionCall(functionName, arguments);
    }

    /**
     * Extract the name of the O³ function.
     *
     * @param data
     * @return the clean name of the O³ function.
     */
    public String getFunctionName(String data) {
        var clean = data.trim();
        var name = clean.substring(0, clean.indexOf(O3SyntaxKeyword.OPEN_EXPRESSION)).trim();
        return name;
    }

    public List<O3Argument> getArguments(O3FileLine line, O3FunctionVariableTable variableTable) {
        var raw = line.getData().trim().substring(line.getData()
                .trim().indexOf(O3SyntaxKeyword.OPEN_EXPRESSION) + 1,
                line.getData().trim().indexOf(O3SyntaxKeyword.CLOSE_EXPRESSION));

        var rawArgs = raw.split(",");
        if (!this.validArgsArray(rawArgs)) {
            return new ArrayList<>();
        }

        var args = new ArrayList<O3Argument>();
        for (String a : rawArgs) {
            var clean = a.trim();
            args.add(this.resloveArgument(clean, variableTable));
        }

        return args;
    }

    /**
     * Resolves argument values
     *
     * @param data
     * @param variableTable
     * @return
     */
    public O3Argument resloveArgument(String data, O3FunctionVariableTable variableTable) {
        if (variableTable.variableIsDeclared(data)) {
            var o3Var = variableTable.getVariableByName(data); //resolve value when exist
            return new O3Argument(o3Var.getInternalName()
                    .replaceAll(":", ""),
                    true,
                    O3TypeValue.of(o3Var.getType(), O3Argument.VALUE));
        } else {
            return this.resolveTypeAndValue(data);
        }
    }

    public O3Argument resolveTypeAndValue(String data) {
        return lexerArgument.getTypeAndValue(data);
    }

    /**
     * To verify if the function has valid args.
     *
     * @param rawArgs
     * @return
     */
    public boolean validArgsArray(String[] rawArgs) {
        if (rawArgs.length == 0) {
            return false;
        } else {
            if (rawArgs.length == 1) {
                if (StringUtils.isBlankString(rawArgs[0])) {
                    return false;
                }
            }
        }
        return true;
    }
}
