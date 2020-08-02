package br.com.schumaker.carla.run;

import br.com.schumaker.carla.files.O3FileBuilder;
import br.com.schumaker.carla.lexer.RawSourceFileChecker;
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
        var fileBuilder = new O3FileBuilder();
        var file = fileBuilder.build(args.get(0));
        
        var preChecker = new RawSourceFileChecker();
        preChecker.startCheck(file);
       
        
        
        System.out.println(file.getLines());
        
      
     
    }
    
    public void start(String something) {
        
    }
}
