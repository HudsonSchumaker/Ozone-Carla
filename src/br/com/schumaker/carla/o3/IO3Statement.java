package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.List;

/**
 *
 * @author schumaker
 */
public interface IO3Statement {
    List<O3FileLine> getLines();
}
