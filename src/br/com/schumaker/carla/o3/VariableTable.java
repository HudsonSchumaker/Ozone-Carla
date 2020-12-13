package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.o3.impl.O3Parameter;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface VariableTable {
    void addParameter(O3Parameter parameter);

    void addParameter(List<O3Parameter> parameters);

    List<O3Parameter> getParameters();
}
