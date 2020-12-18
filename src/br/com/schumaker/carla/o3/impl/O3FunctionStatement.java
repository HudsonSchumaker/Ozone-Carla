package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.o3.Statement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class O3FunctionStatement implements Statement {

    private List<O3Parameter> parameters;
    private List<O3Variable> variables;
    private O3Return funcReturn;
    private List<O3FunctionCall> functionCalls;
    private List<O3FileLine> lines;
}
