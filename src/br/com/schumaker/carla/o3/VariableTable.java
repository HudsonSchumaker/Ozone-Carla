package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.o3.impl.O3Parameter;
import br.com.schumaker.carla.o3.impl.O3Return;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface VariableTable {
    void addParameter(O3Parameter parameter);

    void addParameter(List<O3Parameter> parameters);

    List<O3Parameter> getParameters();

    void addVariable(O3Variable variable);

    void addVariables(List<O3Variable> variables);

    List<O3Variable> getVariables();

    void setReturn(O3Return funcReturn);

    O3Return getReturn();
}
