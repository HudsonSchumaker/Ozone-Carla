package old.br.com.schumaker.carla.lexer;

import java.util.List;
import old.br.com.schumaker.carla.files.O3File;
import old.br.com.schumaker.carla.lexer.o3.O3Atom;
import old.br.com.schumaker.carla.lexer.o3.O3AtomVariableTable;
import old.br.com.schumaker.carla.lexer.o3.O3Function;
import old.br.com.schumaker.carla.lexer.o3.O3FunctionVariableTable;

/**
 * Main class of O3 (Carla Compiler) Lexer.
 *
 * @author Hudson Schumaker
 */
public class Lexer implements ILexer {
    
    @Override
    public O3Atom createProgram(O3File o3File) {
        var lexerFunction = new LexerFunction();
        var functions = lexerFunction.getFunctions(o3File);
        return new O3Atom(o3File.getName(), 
                this.fillAtomVariableTable(functions),
                lexerFunction.getO3FunctionTable(), 
                functions);
    }

    @Override
    public O3AtomVariableTable fillAtomVariableTable(List<O3Function> functions) {
        var atomTable = new O3AtomVariableTable();
        for (var func : functions) {
            var table = (O3FunctionVariableTable)func.getVariableTable();
            for (var v03var : table.getFuncVars()) {
              atomTable.add(v03var);
            }
        }
        return atomTable;
    }
}
