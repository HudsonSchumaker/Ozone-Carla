package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.o3.VariableTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hudson Schumaker
 */
public class O3FunctionVariableTable implements VariableTable {

    private Set<O3Parameter> funcParams = new HashSet<>();
    private Set<O3Variable> funcVars = new HashSet<>();
    private O3Return funcReturn;

    public O3FunctionVariableTable(List<O3Parameter> parameters) {
        this.addParameter(parameters);
    }

    @Override
    public void addParameter(O3Parameter parameter) {
        funcParams.add(parameter);
    }

    @Override
    public void addParameter(List<O3Parameter> parameters) {
        for (O3Parameter param : parameters) {
            funcParams.add(param);
        }
    }

    @Override
    public List<O3Parameter> getParameters() {
        return new ArrayList<>(funcParams);
    }
}
