package br.com.schumaker.carla.run;

import br.com.schumaker.carla.files.O3FileBuilder;
import br.com.schumaker.carla.lexer.LexerFunction;
import br.com.schumaker.carla.lexer.RawSourceFileChecker;
import java.util.Arrays;
import java.util.List;

/**
 * This class orchestrates all the compilation process. 
 * @author schumaker
 */
public class Maestro {

    private final List<String> args;

    public Maestro(String[] args) {
        this.args = Arrays.asList(args);
    }

    public void start() throws Exception {
        var fileBuilder = new O3FileBuilder();
        var file = fileBuilder.build(args.get(0));

        var preChecker = new RawSourceFileChecker();
        preChecker.startCheck(file);
        System.out.println(file.getLines());

        var lexerFunc = new LexerFunction();
        var functions = lexerFunc.getFunctions(file);

        System.out.println(functions);
        
        
        

    }

    public void start(String something) {

    }
}
