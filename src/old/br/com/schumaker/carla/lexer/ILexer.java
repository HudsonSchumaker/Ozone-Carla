package old.br.com.schumaker.carla.lexer;

import java.util.List;
import old.br.com.schumaker.carla.files.O3File;
import old.br.com.schumaker.carla.lexer.o3.O3Atom;
import old.br.com.schumaker.carla.lexer.o3.O3AtomVariableTable;
import old.br.com.schumaker.carla.lexer.o3.O3Function;

/**
 *
 * @author Hudson Schumaker
 */
public interface ILexer {
    O3Atom createProgram(O3File o3File);
    O3AtomVariableTable fillAtomVariableTable(List<O3Function> functions);
}
