package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.o3.VariableTable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hudson Schumaker
 */
public class O3FunctionVariableTable implements VariableTable {

    private String functionName;
    private Set<O3Parameter> funcParams = new HashSet<>();
    private Set<O3Variable> funcVars = new HashSet<>();
    private O3Return funcReturn;

    public O3FunctionVariableTable(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public void addParameter(O3Parameter parameter) {
        funcParams.add(parameter);
    }

    @Override
    public void addParameter(List<O3Parameter> parameters) {
        funcParams.addAll(parameters);
    }

    @Override
    public List<O3Parameter> getParameters() {
        return new ArrayList<>(funcParams);
    }

    @Override
    public void addVariable(O3Variable variable) {
        this.funcVars.add(variable);
    }

    @Override
    public void addVariables(List<O3Variable> variables) {
        this.funcVars.addAll(variables);
    }

    @Override
    public List<O3Variable> getVariables() {
        return new ArrayList<>(funcVars);
    }

    @Override
    public void setReturn(O3Return funcReturn) {
        this.funcReturn = funcReturn;
    }

    @Override
    public O3Return getReturn() {
        return this.funcReturn;
    }
}
