package br.com.schumaker.carla.lexer.o3;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This holds the declared o3functions inside an atom.
 *
 * @author Hudson Schumaker
 */
@Data
@ToString
@NoArgsConstructor
public class O3FunctionTable {

    private Set<O3Function> functions = new HashSet<>();

    public void add(O3Function o3Func) {
        functions.add(o3Func);
    }

    public Set<O3Function> getAllFunctions() {
        return functions;
    }

    public boolean functionIsDeclared(String name) {
        //Predicate<O3Function> pVar = v -> v.getName().equals(name);
        return functions.stream()
                .parallel()
                .anyMatch(v -> v.getName().equals(name));
    }

    public O3Function getFunctionByName(String name) {
        return functions.stream()
                .parallel()
                .filter(v -> v.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
