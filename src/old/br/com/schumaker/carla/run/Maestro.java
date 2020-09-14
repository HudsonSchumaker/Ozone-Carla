package old.br.com.schumaker.carla.run;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import old.br.com.schumaker.carla.files.O3File;
import old.br.com.schumaker.carla.files.O3FileBuilder;
import old.br.com.schumaker.carla.lexer.Lexer;
import old.br.com.schumaker.carla.lexer.RawSourceFileChecker;
import old.br.com.schumaker.carla.lexer.o3.O3Atom;
import old.br.com.schumaker.halogenx64.HalogenX64;

/**
 * This class orchestrates all the compilation process.
 *
 * @author Hudson Schumaker
 */
public class Maestro {

    private final List<String> args;
    
    public Maestro(String[] args) {
        this.args = Arrays.asList(args);
    }

    public void start() throws Exception {
        var o3File = this.initializeO3File(args.get(0));

        var lexer = new Lexer();
        var atom = lexer.createProgram(o3File);
        //System.out.println(atom);
        
        this.machineCode(atom);
    }
    
    public void machineCode(O3Atom atom) throws IOException {
        var halogenX64 = new HalogenX64();
        halogenX64.processO3Atom(atom);
    }

    /**
     * Create a representation of a .o3 source file in memory.
     * @param path path to the physical file source code (.o3)
     * @return O3File
     * @throws Exception 
     */
    public O3File initializeO3File(String path) throws Exception {
        var fileBuilder = new O3FileBuilder();
        var file = fileBuilder.build(path);

        var preChecker = new RawSourceFileChecker();
        preChecker.startCheck(file);
        return file;
    }
}
