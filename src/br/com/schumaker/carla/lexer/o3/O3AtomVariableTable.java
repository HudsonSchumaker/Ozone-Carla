package br.com.schumaker.carla.lexer.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This holds the declared o3variables inside an atom.
 * @author schumaker
 */
@Data
@NoArgsConstructor
public class O3AtomVariableTable implements IO3VariableTable {

    private Set<O3Variable> variables = new HashSet<>();

    public void add(O3Variable o3var) {
        variables.add(o3var);
    }

    public Set<O3Variable> getAllVariables() {
        return variables;
    }

    public boolean variableIsDeclared(String name) {
        //Predicate<O3Function> pVar = v -> v.getName().equals(name);
        return variables.stream()
                .parallel()
                .anyMatch(v -> v.getName().equals(name));
    }

    public O3Variable getVariableByName(String name) {
        return variables.stream()
                .parallel()
                .filter(v -> v.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<O3FileLine> getLines() {
        // just for do the contract of the interface.
        return new ArrayList<>();
    }
}
