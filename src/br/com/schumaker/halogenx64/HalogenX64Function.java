package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.exception.UnsupportedNumberOfArgumentsException;
import br.com.schumaker.carla.lexer.o3.O3Function;
import br.com.schumaker.carla.lexer.o3.O3FunctionCall;
import br.com.schumaker.carla.lexer.o3.O3FunctionStatement;
import br.com.schumaker.carla.o3.core.O3CoreLibrary;

/**
 *
 * @author Hudson Schumaker
 */
public class HalogenX64Function {

    private X64RegisterArgumentTable x64RegisterArgumentTable = new X64RegisterArgumentTable();
    private O3CoreLibrary coreLibrary = new O3CoreLibrary();

    public String resolveFunctionMain(O3Function o3Func) {
        var statement = (O3FunctionStatement) o3Func.getStatement();
        var functionCalls = statement.getFunctionCalls();

        StringBuffer buffer = new StringBuffer();
        for (var funcCall : functionCalls) {
            buffer.append(this.createFunctionCall(funcCall));
        }
        return buffer.toString();
    }

    public String resolveFunction(O3Function o3Func) {
        return null;
    }

    public String createFunctionCall(O3FunctionCall call) {
        var coreFunctionName = call.getFunctionName();
        var coreFunction = coreLibrary.getByName(coreFunctionName);
        var arguments = call.getArguments();
        
        StringBuffer buffer = new StringBuffer();
        if (arguments.size() == 1) {
            var argument = arguments.get(0);
            var argName = argument.getName();
            var type = argument.getType();
            var amsFuncName = coreFunction.getCoreNameByType(type.getName());
            var registerName = coreFunction.getRegistersByCoreName(amsFuncName).get(0);
   
            if (coreFunction.getArgumentSizeByO3Name(amsFuncName) == arguments.size()) {
                buffer.append("\n\n");
                buffer.append("\t" + registerName  + ", " + argName);
                buffer.append("\n");
                buffer.append("\tcall " + amsFuncName);
                buffer.append("\n");
            } else {
                throw new UnsupportedNumberOfArgumentsException();
            }
        } else {
            int index = 0;
            for (var argument : arguments) {

                index++;
            }
        }

        return buffer.toString();
    }
}
