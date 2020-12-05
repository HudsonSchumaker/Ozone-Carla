package br.com.schumaker.carla.run;

import br.com.schumaker.carla.io.O3File;
import br.com.schumaker.carla.io.RawSourceFileChecker;
import br.com.schumaker.carla.io.SourceFileBuilder;
import br.com.schumaker.carla.lexer.Lexer;

import java.util.Arrays;
import java.util.List;

/**
 * This class orchestrates all the compilation process.
 *
 * @author Hudson Schumaker
 */
public final class Maestro {

    private final List<String> args;

    public Maestro(String[] args) {
        this.args = Arrays.asList(args);
    }

    public void start()  throws Exception {
        var sourceFile = this.initializeSourceFile(args.get(0));
        var lexer = new Lexer();
        var atom = lexer.createProgram(sourceFile);
        this.machineCode();
    }

    public void machineCode() {

    }

    public O3File initializeSourceFile(String path) throws Exception {
        var file =  new SourceFileBuilder().build(path);
        new RawSourceFileChecker().doCheck(file);
        return file;
    }
}
