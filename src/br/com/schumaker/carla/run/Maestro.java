package br.com.schumaker.carla.run;

import br.com.schumaker.carla.files.O3FileBuilder;
import br.com.schumaker.carla.io.O3FileReader;
import br.com.schumaker.carla.lexer.PreChecker;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author schumaker
 */
public class Maestro {
    
    private final List<String> args;
    
    public Maestro(String[] args) {
        this.args = Arrays.asList(args);
    }
    
    public void start() throws Exception {
        System.out.println(args.get(0));
        
        var fileBuilder = new O3FileBuilder();
        var file = fileBuilder.build(args.get(0));
        
        var preChecker = new PreChecker();
        preChecker.removeBlankLines(file);
        preChecker.removeComments(file);
        
        System.out.println(file.getLines());
        
        System.out.println(preChecker.checkFunctionMain(file));
      
     
    }
    
    public void start(String something) {
        
    }
}
