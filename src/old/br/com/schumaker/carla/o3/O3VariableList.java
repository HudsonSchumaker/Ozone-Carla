package old.br.com.schumaker.carla.o3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import old.br.com.schumaker.carla.files.O3FileLine;

/**
 * Create a list of variables inside in the a O3 function scope.
 *
 * @author Hudson Schumaker
 */
@Data
public class O3VariableList {

    private List<O3FileLine> lines;
    private Set<String> variables = new HashSet<>();

    public O3VariableList(List<O3FileLine> lines) {
        this.lines = lines;
        this.loadVariableList(this.lines);
    }

    public void add(String name) {
        this.variables.add(name);
    }

    public boolean isVariablePreDeclared(String name) {
        return variables.stream()
                .parallel()
                .anyMatch(v -> v.equals(name));
    }

    public void loadVariableList(List<O3FileLine> lines) {
        for (O3FileLine line : lines) {
            var data = line.getData().trim();
            var name = data.substring(O3SyntaxKeyword.VARIABLE.length(), data.length()).trim();
            variables.add(name.substring(0, name.indexOf(O3SyntaxKeyword.ASSINGN)).trim());
        }
    }
}
