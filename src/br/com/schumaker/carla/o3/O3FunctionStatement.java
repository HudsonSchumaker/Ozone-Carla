package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.List;
import lombok.Data;

/**
 *
 * @author schumaker
 */
@Data
public class O3FunctionStatement implements IO3Statement {

    private List<O3FileLine> lines;

}