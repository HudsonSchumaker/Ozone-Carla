package old.br.com.schumaker.carla.lexer.o3;

import java.util.List;
import old.br.com.schumaker.carla.files.O3FileLine;

/**
 *
 * @author Hudson Schumaker
 */

public interface IO3Statement {
    List<O3FileLine> getLines();
}
