package br.com.schumaker.carla.lexer.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This holds the declared variables inside a function.
 * @author schumaker
 */
@Data
@AllArgsConstructor
public class O3FunctionVariableTable implements IO3VariableTable {
    
    private Set<O3Variable> funcVars = new HashSet<>();
    
    public void add(O3Variable o3Var) {
        funcVars.add(o3Var);
    }
    
    public Set<O3Variable> getVariables() {
        return funcVars;
    }
    
    public boolean varibleIsDeclared(String name) {
        //Predicate<O3Variable> pVar = v -> v.getName().equals(name);
        return funcVars.stream()
                .parallel()
                .anyMatch(v -> v.getName().equals(name));
    }

    @Override
    public List<O3FileLine> getLines() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
