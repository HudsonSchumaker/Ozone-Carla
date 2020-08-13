package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.lexer.o3.IO3Statement;
import br.com.schumaker.carla.lexer.o3.O3Argument;
import br.com.schumaker.carla.lexer.o3.O3FunctionCall;
import br.com.schumaker.carla.lexer.o3.O3FunctionVariableTable;
import br.com.schumaker.carla.lexer.o3.O3TypeValue;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.lexer.utils.StringUtils;
import br.com.schumaker.carla.o3.O3Keyword;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schumaker
 */
public class LexerFunctionCall {
    
    public List<O3FunctionCall> getFunctionCalls(IO3Statement statement, O3FunctionVariableTable variableTable) {
        var functionCalls = new ArrayList<O3FunctionCall>();
        for (O3FileLine line : statement.getLines()) {
            if (line.isFunctionCall()) {
                functionCalls.add(this.getFunctionCall(line, variableTable));
            }
        }
        return functionCalls;
    }
    
    public O3FunctionCall getFunctionCall(O3FileLine line, O3FunctionVariableTable variableTable) {
        var functionName = this.getFunctionName(line.getData());
        var arguments = this.getArguments(line, variableTable);
        
        return new O3FunctionCall(functionName, arguments);
    } 
    
    public String getFunctionName(String data) {
        var clean = data.trim();
        var name = clean.substring(0, clean.indexOf(O3Keyword.OPEN_EXPRESSION)).trim();
        return name;
    }
    
    public List<O3Argument> getArguments(O3FileLine line, O3FunctionVariableTable variableTable) {
        var raw = line.getData().trim().substring(line.getData()
                .trim().indexOf(O3Keyword.OPEN_EXPRESSION) + 1,
                line.getData().trim().indexOf(O3Keyword.CLOSE_EXPRESSION));
        
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
    
    public O3Argument resloveArgument(String data, O3FunctionVariableTable variableTable) {
        if (variableTable.varibleIsDeclared(data)) {
            return new O3Argument(data, true,
                    O3TypeValue.of(O3VariableType.STRING, O3Argument.VALUE));
        } else {
            return this.resolveTypeAndValue(data);
        }
    }
    
    public O3Argument resolveTypeAndValue(String data) {
        if (data.contains("\"")){
            return new O3Argument(O3Argument.NAME, 
                    false, O3TypeValue.of(O3VariableType.STRING, data));
        } 
        
        if (data.contains(O3Keyword.TRUE) || data.contains(O3Keyword.FALSE)) {
            return new O3Argument(O3Argument.NAME, 
                    false, O3TypeValue.of(O3VariableType.BOOL, data));
        }
        
        //TODO fazer o resto
        return null;
    }
    
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