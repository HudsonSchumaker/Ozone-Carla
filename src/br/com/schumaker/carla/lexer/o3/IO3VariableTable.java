package br.com.schumaker.carla.lexer.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.List;

/**
 *
 * @author schumaker
 */
public interface IO3VariableTable {
    List<O3FileLine> getLines();
}