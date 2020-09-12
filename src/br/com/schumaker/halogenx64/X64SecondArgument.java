package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.lexer.o3.O3Argument;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.o3.core.IO3CoreFunction;
import br.com.schumaker.carla.o3.core.O3CoreLibrary;
import lombok.Getter;

/**
 * This class holds the argument attributes for the 2sd argument syscall.
 *
 * @author Hudson Schumaker
 */
public class X64SecondArgument {

    public static String SecondArgument = "rsi";
    
    private final O3CoreLibrary coreLibrary = new O3CoreLibrary();

    @Getter
    private final String name;

    @Getter
    private final String amsFunctionName;

    @Getter
    private final String registerName;

    @Getter
    private final O3VariableType type;

    @Getter
    private final boolean isInitialized;

    @Getter
    private final IO3CoreFunction coreFunction;

    public X64SecondArgument(String coreFunctionName, O3Argument source) {
        this.name = source.getName();
        this.type = source.getType();
        this.coreFunction = coreLibrary.getByName(coreFunctionName);
        this.amsFunctionName = coreFunction.getCoreNameByType(type.getName());
        this.registerName = coreFunction.getRegistersByCoreName(amsFunctionName).get(0);
        this.isInitialized = source.isInitialized();
    }
}
