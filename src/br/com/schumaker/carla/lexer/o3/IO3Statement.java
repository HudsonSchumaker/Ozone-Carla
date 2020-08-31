package br.com.schumaker.carla.lexer.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */

public interface IO3Statement {
    List<O3FileLine> getLines();
}
