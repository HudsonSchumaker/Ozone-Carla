package br.com.schumaker.carla.o3.core;

import br.com.schumaker.carla.lexer.o3.O3VariableType;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public interface IO3CoreFunction {
    String getO3Name();
    String getCoreNameByType(O3VariableType type);
    List<String> getOverloadMethods();
}
