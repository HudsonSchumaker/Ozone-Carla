package br.com.schumaker.carla.o3.core;

import br.com.schumaker.carla.lexer.o3.O3VariableType;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public interface IO3CoreFunction {
    String getO3Name();
    String getLibrary();
    String getCoreNameByType(String type);
    String getCoreNameByType(O3VariableType type);
    Integer getArgumentSizeByO3Name(String name);
    List<String> getOverloadMethods();
    List<String> getRegistersByCoreName(String name);
    O3VariableType getReturnType();
}
