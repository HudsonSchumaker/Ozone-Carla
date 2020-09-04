package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.exception.UnsupportedNumberOfArgumentsException;
import br.com.schumaker.carla.lexer.o3.O3Function;
import br.com.schumaker.carla.lexer.o3.O3FunctionCall;
import br.com.schumaker.carla.lexer.o3.O3FunctionStatement;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
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
            var argument = new X64FirstArgument(coreFunctionName, arguments.get(0));
            if (coreFunction.getArgumentSizeByO3Name(argument.getAmsFunctionName()) == arguments.size()) {
                buffer.append("\n");
                if (argument.getType().getName().equalsIgnoreCase(O3VariableType.STRING.getName())) {
                    buffer.append("\t")
                            .append(argument.getRegisterName())
                            .append(", ")
                            .append(argument.getName());
                } else {
                    buffer.append("\t")
                            .append(argument.getRegisterName())
                            .append(", ").append("[rel ")
                            .append(argument.getName())
                            .append("]");
                }

                buffer.append("\n");
                buffer.append("\tcall ").append(argument.getAmsFunctionName());
                buffer.append("\n");
                if (call.isHasReturn()) {
                    buffer.append("\tmov [rel r_" + call.getFunctionName()+ "], rax");
                    buffer.append("\n");
                    
                    if (call.getO3return().isReturnToVariable()) {
                        // verificar mov para variavel de scetion .data e/ou criar e mover dados para .bss                                                         
                        buffer.append("\tmov [rel " + call.getO3return().getVariableName() + "], rax");
                        buffer.append("\n");
                    } else {
                        // return to a function should b e resolved here.
                    }
                }
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
