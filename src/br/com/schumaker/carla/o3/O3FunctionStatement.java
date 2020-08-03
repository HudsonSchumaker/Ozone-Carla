package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author schumaker
 */
@Data
@AllArgsConstructor
public class O3FunctionStatement implements IO3Statement {

     // private String functionSignature;
    private List<O3Variable> variables;
    private List<O3FileLine> lines;

}
