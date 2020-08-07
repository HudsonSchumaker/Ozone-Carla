package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.lexer.o3.IO3Statement;
import br.com.schumaker.carla.lexer.o3.O3Argument;
import br.com.schumaker.carla.lexer.o3.O3FunctionCall;
import br.com.schumaker.carla.lexer.utils.StringUtils;
import br.com.schumaker.carla.o3.O3Keyword;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schumaker
 */
public class LexerFunctionCall {
    
    public List<O3FunctionCall> getFunctionCalls(IO3Statement statement) {
        var functionCalls = new ArrayList<O3FunctionCall>();
        for (O3FileLine line : statement.getLines()) {
            if (line.isFunctionCall()) {
                functionCalls.add(this.getFunctionCall(line));
            }
        }
        return functionCalls;
    }
    
    public O3FunctionCall getFunctionCall(O3FileLine line) {
        var functionName = this.getFunctionName(line.getData());
        var arguments = getArguments(line);
        
        return null;
    } 
    
    public String getFunctionName(String data) {
        var clean = data.trim();
        var name = clean.substring(O3Keyword.VARIABLE.length(), clean.length()).trim();
        name = name.substring(0, name.indexOf(O3Keyword.ASSINGN)).trim();
        return name;
    }
    
    public List<O3Argument> getArguments(O3FileLine line) {
        var raw = line.getData()
                .trim().substring(line.getData()
                        .trim().indexOf(O3Keyword.OPEN_EXPRESSION) + 1,
                line.getData().trim().indexOf(O3Keyword.CLOSE_EXPRESSION));
        
        var rawArgs = raw.split(",");
        if (!this.validArgsArray(rawArgs)) {
            return new ArrayList<>();
        }
        
        var args = new ArrayList<O3Argument>();
        for (String a : rawArgs) {
            var clean = a.trim();
            
        }
        
        
        return args;
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
    
    public O3Argument resolveTypeAndValue(String data) {
        return null;
    }
}