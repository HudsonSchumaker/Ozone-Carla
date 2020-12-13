package br.com.schumaker.carla.run;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.RawSourceFileChecker;
import br.com.schumaker.carla.io.impl.SourceFileBuilder;
import br.com.schumaker.carla.lexer.impl.Lexer;

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
        System.out.println("Reading source file: " + args.get(0));

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
