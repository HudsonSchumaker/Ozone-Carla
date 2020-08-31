package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3File;
import br.com.schumaker.carla.lexer.o3.O3Atom;
import br.com.schumaker.carla.lexer.o3.O3AtomVariableTable;
import br.com.schumaker.carla.lexer.o3.O3Function;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public interface ILexer {
    O3Atom createProgram(O3File o3File);
    O3AtomVariableTable fillAtomVariableTable(List<O3Function> functions);
}
