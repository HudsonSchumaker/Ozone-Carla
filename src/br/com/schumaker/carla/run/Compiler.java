package br.com.schumaker.carla.run;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.RawSourceFileChecker;
import br.com.schumaker.carla.io.impl.SourceFileBuilder;
import br.com.schumaker.carla.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class orchestrates all the compilation process.
 *
 * @author Hudson Schumaker
 */
public final class Compiler {

    private final List<String> args;
    private final SourceFileBuilder sourceFileBuilder;
    private final RawSourceFileChecker rawSourceFileChecker;

    public Compiler(String[] args) {
        this.args = Arrays.asList(args);
        this.sourceFileBuilder = new SourceFileBuilder();
        this.rawSourceFileChecker = new RawSourceFileChecker();
    }

    public void start() throws Exception {
        System.out.println("Reading source folder: " + args.get(0));
        var sourceFile = this.initializeSourceFolder(args.get(0));

        var lexer = new Lexer();
        var tabula = lexer.createProgram(sourceFile);
        this.machineCode();
    }

    public void machineCode() {
        // TODO
    }

    public List<O3File> initializeSourceFolder(String path) throws Exception {
        var paths = FileUtils.getFilePathsFromRoot(path);

        List<O3File> sourceFiles = new ArrayList<>();
        for (var p : paths) {
            var o = sourceFileBuilder.build(p);
            rawSourceFileChecker.doCheck(o);
            sourceFiles.add(o);
        }

        rawSourceFileChecker.checkForFunctionMain(sourceFiles);
        return sourceFiles;
    }
}
